package controllers;

import models.Activity;
import models.Day;
import models.Track;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import controllers.routes;

import java.util.Map;

import static play.libs.Json.toJson;

public class TrackController extends Controller {

    public static Result getTracks(){
        return ok(tracks.render(Track.findAll()));
    }

    public static Result serve(long id){
        return ok(track.render(Track.findById(id)));
    }

    public static Result dashboard() {

        return ok(trackDashboard.render(Track.findAll()));
    }


    public static Result add() {
        Track track = Form.form(Track.class).bindFromRequest().get();
        track.save();
        System.out.println(toJson(track));

        return redirect(routes.TrackController.dashboard());
    }


    public static Result delete(long id) {
        Track track = Track.findById(id);
        track.delete();

        return redirect(routes.TrackController.dashboard());
    }

}
