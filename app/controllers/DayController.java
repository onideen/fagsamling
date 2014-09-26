package controllers;

import models.Activity;
import models.Day;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;
import java.util.Map;

public class DayController extends Controller {


    public static Result add() {
        Form<Day> dayForm = Form.form(Day.class).bindFromRequest();

        if(dayForm.hasErrors()){
            return badRequest(activityDashboard.render(Day.findAll()
            ));
        }

        Day day = dayForm.get();

        day.save();

        return redirect(controllers.routes.ActivityController.dashboard());
    }


    public static Result delete(long id) {
        Day day = Day.findById(id);
        for(Activity activity : day.getActivities()){
            activity.delete();
        }
        day.delete();

        return redirect(controllers.routes.ActivityController.dashboard());
    }
}
