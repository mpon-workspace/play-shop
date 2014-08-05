package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

import models.*;

public class Application extends Controller {

	@Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render());
    }

    public static Result login() {
    	return ok(login.render(Form.form(User.class)));
    }

    public static Result logout() {
    	session().clear();
    	return redirect(routes.Application.login());
    }

    public static Result authenticate() {
    	Form<User> loginForm = Form.form(User.class).bindFromRequest();
    	if (loginForm.hasErrors()) {
    		return badRequest(login.render(loginForm));
    	}
    	session().clear();
        session("name", loginForm.get().name);
    	return redirect(routes.Application.index());
    }

    public static Result addUser() {
    	User masato = User.find.where().eq("name", "masato").findUnique();
    	if (masato == null) {
    		User.create("masato", "password123");
    	}
    	return redirect(routes.Application.login());
    }

}
