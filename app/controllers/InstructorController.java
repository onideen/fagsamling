package controllers;

import models.Activity;
import models.Day;
import models.Instructor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.activityDashboard;
import views.html.activityEdit;
import views.html.instructorEdit;

import static play.data.Form.form;

public class InstructorController extends Controller {


    public static Result dashboard(){
        return ok(views.html.instructorDashboard.render(Instructor.findAll()));
    }

    public static Result insForm(long id) {
        Form<Instructor> iForm = form(Instructor.class);
        iForm.fill(Instructor.findById(id));

        return ok(instructorEdit.render(iForm));
    }

    public static Result edit(long id) {
        Form<Instructor> instructorForm = form(Instructor.class).bindFromRequest();

        if(instructorForm.hasErrors()){
            return badRequest(views.html.instructorEdit.render(instructorForm
            ));
        }

        Instructor instructor = instructorForm.get();
        instructor.save();

        return redirect(routes.InstructorController.dashboard());
    }


    public static Result delete(long id) {
        Instructor instructor = Instructor.findById(id);
        instructor.delete();

        return redirect(routes.InstructorController.dashboard());
    }
}
