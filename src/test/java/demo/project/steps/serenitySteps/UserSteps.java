package demo.project.steps.serenitySteps;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserSteps {
    private static Response response;

    @Step
    public static void createUser(Map<String, String> userInfo) {
        Faker faker = new Faker();
        String fn = faker.name().firstName();
        String ln = faker.name().lastName();
        String username = userInfo.get("username");
        username = username.equalsIgnoreCase("random") ? fn + ln : username;
        given().accept(JSON).contentType(JSON);
        String body = "{\"username\":\"" + username + "\",\"firstName\":\"" + fn + "\",\"lastName\":\"" + ln + "\",\"password\":\"" + userInfo.get("password") + "\",\"confirmPassword\":\"" + userInfo.get("password") + "\"}";
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(body);
        RequestSpecification requestSpec = builder.build();
        response = given().spec(requestSpec).when().post();
    }

    @Step
    public static void checkRegisterResponse(Map<String, String> expectInfo) {
        response.then().statusCode(Integer.parseInt(expectInfo.get("status")));
        if (expectInfo.get("message") != null) {
            String msg = response.then().extract().body().asString();
            System.out.println("---------------" + msg);
            assertTrue(msg.contains(expectInfo.get("message")));
        }
    }

    @Step
    public static void login(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        response = given().params(params).when().post();
    }

    @Step
    public static void checkLoginResponse(int status, String message) {
        response.then().statusCode(status);
        assertTrue(response.then().extract().body().asString().contains(message));
    }
}