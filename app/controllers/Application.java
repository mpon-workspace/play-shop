package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

import models.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result login() {
    	return ok(login.render(Form.form(User.class)));
    }

    public static Result authenticate() {
    	Form<User> loginForm = Form.form(User.class).bindFromRequest();
    	if (loginForm.hasErrors()) {
    		return badRequest(login.render(loginForm));
    	}
    	return redirect(routes.Application.index());
    }

    public static Result addUser() {
    	User user = new User();
    	user.name = "Tom";
    	user.password = "password123";
    	user.save();
    	return redirect(routes.Application.login());
    }

}
