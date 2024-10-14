package Controllers;

import io.restassured.response.Response;
import services.constant.AppEndPoints;
import services.context.TestContext;
import services.helper.BookingHelper;
import services.logger.Log;
import services.util.RestAPIClient;

public class BookingController extends BookingHelper {


    RestAPIClient restAPIClient;
    TestContext testContext;

    public BookingController(TestContext context) {
        testContext = context;
        restAPIClient = new RestAPIClient();
    }

    public String postBookingStatusAPI(String expectedResponseCode) {
        String reqBody = generateBookingAPIRequestBody();
        Response id = restAPIClient.postCall(AppEndPoints.HOST_NAME,reqBody,AppEndPoints.BOOKING_ENDPOINT,expectedResponseCode);
        Log.info(id.getBody().prettyPrint());
        return id.jsonPath().get("bookingid").toString();
    }

    public String getBookingStatusAPI(String bookingId, String expectedResponseCode) {

        Response responseBody = restAPIClient.getCall(AppEndPoints.HOST_NAME, AppEndPoints.BOOKING_ENDPOINT + "/" + bookingId,expectedResponseCode);
        return responseBody.jsonPath().prettyPrint().toString();
    }
}