package services.helper;

import org.json.simple.JSONObject;

public class BookingHelper {

    public String generateBookingAPIRequestBody() {
        JSONObject reqBody = new JSONObject();
        JSONObject dateArray = new JSONObject();

        reqBody.put("firstname", "Test");
        reqBody.put("lastname", "user");
        reqBody.put("totalprice", 10.00);
        reqBody.put("depositpaid", true);

        dateArray.put("checkin", "2022-01-01");
        dateArray.put("checkout", "2024-01-01");

        reqBody.put("bookingdates", dateArray);
        reqBody.put("additionalneeds", "testAdd");
        return reqBody.toJSONString();
    }
}
