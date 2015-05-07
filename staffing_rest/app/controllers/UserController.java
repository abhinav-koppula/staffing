package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import constants.UserConstants;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import models.Login;
import play.Play;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */
public class UserController extends Controller {

    public static Result login() {
        ObjectNode jsonResult = Json.newObject();
        JSONSerializer serializer = new JSONSerializer().exclude("*.class");

        Login loginRequest = new JSONDeserializer<Login>().deserialize(request().body().asJson().toString(), Login.class);
        Login login = Login.attemptToLogin(loginRequest.username, loginRequest.password);
        if(login == null) {
            return returnAuthenticationFailure(jsonResult);
        }
        response().setCookie(UserConstants.AUTH_TOKEN_COOKIE_NAME, login.authToken, Integer.MIN_VALUE, "/", "",
                Play.isProd(), true);

        return ok(serializer.serialize(login));
    }

    private static Result returnAuthenticationFailure(ObjectNode jsonResult) {
        jsonResult.put("message", "Not authorised");
        response().discardCookie(UserConstants.AUTH_TOKEN_COOKIE_NAME);
        return forbidden(jsonResult);
    }
}
