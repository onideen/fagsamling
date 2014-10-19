package controllers;

import models.Information;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.sound.midi.ControllerEventListener;


/**
* Created by martesaether on 13.10.14.
*/
public class InfoController extends Controller {


	public static Result information(){
        return ok(views.html.information.render());
    }
}
