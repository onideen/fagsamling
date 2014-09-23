package controllers;

import models.Activity;
import models.Day;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.activityDashboard;

import java.util.Map;

public class TrackController extends Controller {

    public static Result serve(){
        return ok(tracks.render(Track.findAll()));
    }

    public static Result dashboard() {

        return ok(trackDashboard.render(Track.findAll()));
    }

/*
    public static Result add(Long dayId) {
        Day day = Day.findById(dayId);
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        Activity activity = new Activity(day);
        activity.setStartTime(values.get("start-time")[0]);
        activity.setEndTime(values.get("end-time")[0]);
        activity.setTitle(values.get("title")[0]);
        activity.save();

        return redirect(TrackController.dashboard());
    }


    public static Result delete(long id) {
        Activity activity = Activity.findById(id);
        activity.delete();

        return redirect(TrackController.dashboard());
    }

    */
}
