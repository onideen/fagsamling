package controllers;

import models.Activity;
import models.Day;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;
import java.util.Map;

public class DayController extends Controller {


    public static Result add() {
        List<Day> days = Day.findAll();
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        Day day = new Day();
        day.position = days.size();
        day.setTitle(values.get("title")[0]);
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
