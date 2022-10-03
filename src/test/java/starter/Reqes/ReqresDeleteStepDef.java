package starter.Reqes;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class ReqresDeleteStepDef {

    @Steps
    ReqresAPI reqresAPI;
    //Tugas Delete user with valid id
    @Given("Delete user with valid {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Should return {int} no content")
    public void shouldReturnNoContent(int noContain) {
        SerenityRest.then().statusCode(noContain);
    }

    //Tugas Delete user with invalid id
    @Given("Delete user with invalid {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUser(id);
    }
}
