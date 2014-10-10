package controllers;

import models.Instructor;
import models.Track;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

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

    public static Result form(long id) {
        return ok(trackEdit.render(Track.findById(id)));
    }

    public static Result edit(long id) {
        System.out.println(id);
        Track track = Form.form(Track.class).bindFromRequest("id", "title", "host", "room", "format", "level", "equipment", "audience", "description").get();

        String[] instructorNames = request().body().asFormUrlEncoded().get("instructors")[0].split(",");

        List<Instructor> instructors = new ArrayList<>();





       for (String instructorName : instructorNames) {
           System.out.println(instructorName);
            if(instructorName.equals(""))continue;
            Instructor instructor = Instructor.findByName(instructorName);
            instructor = (instructor != null) ? instructor : new Instructor(instructorName);
            instructors.add(instructor);
        }

        track.setInstructors(instructors);

        if(track.isNew()){
            track.save();
        } else {
            track.update();
        }

        System.out.println(track.getInstructorsAsString());

        System.out.println(Track.findById(track.getId()).getInstructorsAsString());
        return redirect(controllers.routes.TrackController.dashboard());
    }

    public static Result delete(long id) {
        Track track = Track.findById(id);
        track.delete();

        return redirect(routes.TrackController.dashboard());
    }

}
