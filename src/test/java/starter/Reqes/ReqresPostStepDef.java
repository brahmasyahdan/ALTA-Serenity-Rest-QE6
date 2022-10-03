package starter.Reqes;

import java.io.File;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import static org.hamcrest.Matchers.equalTo;

public class ReqresPostStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Tugas Post create new user
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }
    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {

        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }
    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {

        SerenityRest.then().statusCode(created);
    }
    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Post json schema validator")
    public void postJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostCreateNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Tugas Post create new user without name
    @Given("Post create new user without name")
    public void postCreateNewUserWithoutName() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostCreateNewUserWithoutName.json");
        reqresAPI.postCreateNewUser(json);
    }



    //Tugas Post create new user without job
    @Given("Post create new user without job")
    public void postCreateNewUserWithoutJob() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostCreateNewUserWithoutJob.json");
        reqresAPI.postCreateNewUser(json);
    }



    //Tugas Post create new user without job
    @Given("Post create new user without name job")
    public void postCreateNewUserWithoutNameJob() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostCreateNewUserWithoutNameJob.json");
        reqresAPI.postCreateNewUser(json);
    }



    //Tugas Post register user
    @Given("Post register user")
    public void postRegisterUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostRegisterUserSuccessful.json");
        reqresAPI.postRegister(json);
    }

    @When("Send Request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID_POST,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Post register json schema validator")
    public void postRegisterJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterUserSuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Tugas Post register user unsuccessful
    @Given("Post register user unsuccessful")
    public void postRegisterUserUnsuccessful() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostRegisterUserUnsuccessful.json");
        reqresAPI.postRegister(json);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Post register unsuccessful json schema validator")
    public void postRegisterUnsuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterUnsuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Tugas Post Post login successful
    @Given("Post login successful")
    public void postLoginSuccessful() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostLoginSuccessful.json");
        reqresAPI.postLogin(json);
    }

    @When("Send Request post login successful")
    public void sendRequestPostLoginSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Post login successful json schema validator")
    public void postLoginSuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginSuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Tugas Post Post login successful
    @Given("Post login unsuccessful")
    public void postLoginUnsuccessful() {
        File json = new File(ReqresAPI.JSON_FILE+"/ReqresBody/PostLoginUnsuccessful.json");
        reqresAPI.postLogin(json);
    }

    @When("Send Request post login unsuccessful")
    public void sendRequestPostLoginUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Post login unsuccessful json schema validator")
    public void postLoginUnsuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginUnsuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
