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

        return ok(activityDashboard.render(Day.findAll()));
    }


    public static Result add(Long dayId) {
        Day day = Day.findById(dayId);
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        Activity activity = new Activity(day);
        activity.setStartTime(values.get("start-time")[0]);
        activity.setEndTime(values.get("end-time")[0]);
        activity.setTitle(values.get("title")[0]);
        activity.save();

        return redirect(controllers.routes.ActivityController.dashboard());
    }


    public static Result delete(long id) {
        Activity activity = Activity.findById(id);
        activity.delete();

        return redirect(controllers.routes.ActivityController.dashboard());
    }
}
