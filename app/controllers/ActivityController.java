package controllers;

import akka.actor.dsl.Creators;
import com.avaje.ebean.Ebean;
import models.Activity;
import models.Day;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;
import java.util.Map;

import static play.libs.Json.toJson;

public class ActivityController extends Controller {

    public static Result dashboard() {

        return ok(activityDashboard.render(Day.findAll()));
    }


    public static Result add() {
        Activity activity = Form.form(Activity.class).bindFromRequest().get();
        activity.save();
        return redirect(controllers.routes.ActivityController.dashboard());
    }

    public static Result form(long id) {
        return ok(activityEdit.render(Activity.findById(id)));
    }

    public static Result edit(long id) {
        System.out.println(id);
        Activity activity = Form.form(Activity.class).bindFromRequest().get();
        if(activity.isNew()){
            activity.save();
        } else {
            activity.update();
        }
        return redirect(controllers.routes.ActivityController.dashboard());
    }


    public static Result delete(long id) {
        Activity activity = Activity.findById(id);
        activity.delete();

        return redirect(controllers.routes.ActivityController.dashboard());
    }
}
