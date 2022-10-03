package starter.Reqes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class ReqresPatchStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with id {int}")
    public void patchUpdateUserWithId(int id){
        File json=new File(ReqresAPI.JSON_FILE+"/ReqresBody/PatchUpdateUserWithId.json");
        reqresAPI.patchUpdateUser(id,json);
    }


    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Patch json schema validator")
    public void patchJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PatchUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
