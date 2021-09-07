package demo.project.steps.serenitySteps;

import demo.project.util.EnvironmentVars;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;
import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.given;

public class DashboardSteps {
    private EnvironmentVariables envVar;
    private Response response;
    private String maker;
    private String model;

    @Step()
    public void retrieveDashboard(String resource, String env) {
//TODO using config file to setup environment vars
//        RestAssured.baseURI = EnvironmentSpecificConfiguration.from(envVar).getProperty("api.base.url");
        RestAssured.baseURI = EnvironmentVars.getBaseURL(env);
        RestAssured.basePath = resource;
        given().accept(JSON).contentType(JSON);
    }

    @Step()
    public void getPopularMaker() {
        response = when().get();
        maker = response.then().statusCode(200).extract().body().jsonPath().get("make.id");
    }

    @Step()
    public void checkMakerInfo() {
        response.then().body("make.id", Matchers.anything());
        response.then().body("make.image", Matchers.anything());
        response.then().body("make.name", Matchers.equalTo(EnvironmentVars.getMaker(maker)));
        response.then().body("make.votes", Matchers.anything());
    }

    @Step()
    public void getPopularModel() {
        response = when().get();
        String id = response.then().statusCode(200).extract().body().jsonPath().get("model.id");

        maker = id.split("\\|")[0];
        model = id.split("\\|")[1];
    }

    @Step()
    public void checkModelInfo() {
        response.then().body("model.id", Matchers.anything());
        response.then().body("model.image", Matchers.anything());
        response.then().body("model.make", Matchers.equalTo(EnvironmentVars.getMaker(maker)));
        response.then().body("model.name", Matchers.equalTo(EnvironmentVars.getModel(model)));
        response.then().body("model.votes", Matchers.anything());
    }
}
