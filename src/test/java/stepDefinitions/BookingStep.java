package stepDefinitions;

import Controllers.BookingController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.context.Context;
import services.context.ScenarioContext;
import services.context.TestContext;
import services.logger.Log;

public class BookingStep {

    BookingController bookingController;
    String response;
    TestContext testContext;
    ScenarioContext scenarioContext;

    public BookingStep(TestContext context) {
        testContext = context;
        bookingController = new BookingController(context);
    }

    @When("user hits the booking api with the expected response code as {string}")
    public void userHitsTheBookingApiWithTheExpectedResponse(String expectedResponseCode) {
        try {
            String id = bookingController.postBookingStatusAPI(expectedResponseCode);

            testContext.getScenarioContext().setContext(Context.BOOKING_ID, id);
        } catch (Exception e) {
            Log.warn(e.getMessage());
        }
    }

    @Then("user hits the booking get api to confirm on the booking with the expected response code as {string}")
    public void userVerifiesTheStatuscode(String expectedResponseCode) {
        try {
            response = bookingController.getBookingStatusAPI(testContext.getScenarioContext().getContext(Context.BOOKING_ID).toString(), expectedResponseCode);
            Log.info(response);
        } catch (Exception e) {
            Log.warn(e.getMessage());
        }
    }

}
