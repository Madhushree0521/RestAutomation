package services.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAPIClient {

    public Response postCall(String url, String playlistRequest, String path, String expectedResponseCode) {

        Response response = RestAssured
                .given()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .body(playlistRequest)
                .when()
                .post(path)
                .then()
                .statusCode(Integer.parseInt(expectedResponseCode)).
                extract().
                response();
        return response;
    }

    public Response getCall(String url, String path, String expectedResponseCode) {
        Response response = RestAssured.given()
                .baseUri(url)
                .when().get(path)
                .then()
                .statusCode(Integer.parseInt(expectedResponseCode))
                .extract()
                .response();
        return response;
    }
}

