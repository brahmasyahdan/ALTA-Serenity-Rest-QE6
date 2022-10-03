package starter.Reqes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ReqresDelayStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with delay {int}")
    public void getListUserWithDelay(int delay) {
        reqresAPI.delayResponse(delay);
    }
    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(ReqresAPI.DELAY_RESPONSE);
    }


}
