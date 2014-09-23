package controllers;

import models.Activity;
import models.Day;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;
import java.util.Map;

public class ActivityController extends Controller {

    public static Result dashboard() {

        return ok(activityDashboard.render(Activity.findAll()));
    }


    public static Result add() {
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        Activity day = new Activity();
        day.setTitle(values.get("title")[0]);
        day.save();

        return redirect(controllers.routes.ActivityController.dashboard());
    }


    public static Result delete(long id) {
        Activity activity = Activity.findById(id);
        activity.delete();

        return redirect(controllers.routes.ActivityController.dashboard());
    }
}
