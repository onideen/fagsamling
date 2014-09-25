package controllers;

import models.Day;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(views.html.index.render(Day.findAll()));
    }

    public static Result information(){
        return ok(views.html.information.render());
    }
}
