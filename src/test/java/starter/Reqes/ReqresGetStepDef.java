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

public class ReqresGetStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Tugas Get list user with valid parameter page
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {

        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {

        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Should return {int} ok")
    public void shouldReturnOk(int ok) {

        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be page {int}")
    public void responseBodyPageShouldBePage(int page) {

        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Tugas Get single user
    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUser(id);
    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @And("Response body id should be id {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }
    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetSingleUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Tugas Get single user with not found id
    @Given("Get single user with not found id {int}")
    public void getSingleUserWithNotFoundIdId(int id) {
        reqresAPI.getSingleUser(id);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


    //Tugas Get list single resource with id
    @Given("Get list single resource with id {int}")
    public void getListResourceWithPage(int id) {
        reqresAPI.getListSingleResource(id);
    }

    @When("Send request get list single resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Response body should contain id {int} , name {string}")
    public void responseBodyShouldContainId(int id,String nama) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.GET_SINGLE_RESOURCE_NAME,equalTo(nama));
    }
    @And("Get list resource json schema validator")
    public void getListResourceJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetListResourceJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Tugas Get list single resource not found id
    @Given("Get list single resource not found id {int}")
    public void getListSingleResourceNotFoundId(int id) {
        reqresAPI.getListSingleResource(id);
    }
}
