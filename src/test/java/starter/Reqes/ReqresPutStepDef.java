package starter.Reqes;


import java.io.File;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ReqresPutStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Tugas Put update user with id
    @Given("Put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json=new File(ReqresAPI.JSON_FILE+"/ReqresBody/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Put json schema validator")
    public void putJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PutUpdateUserWithValidIdJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
