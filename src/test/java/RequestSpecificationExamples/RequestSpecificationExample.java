package RequestSpecificationExamples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {

    public static void main(String[] args) {
/*
To club common request specifications together and put as a common entity, we can use RequestSpecification
in Rest Assured. RequestSpecification is an interface that allows you to specify how the request will look like.
This interface has readymade methods to define base URL, base path, headers, etc. We need to use given() method
of RestAssured class to get a reference for RequestSpecification. Remember RequestSpecification is an
interface and we can not create an object of it. RequestSpecificationImpl is its implemented class.

Can be used in the way below:
RestAssured.given(requestSpecification)
OR
RestAssured.given().spec(requestSpecification)
*/

        // Creating request specification using given()
        RequestSpecification request1 = RestAssured.given();
        // Setting Base URI
        request1.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request1.basePath("/booking");

        // Creating request specification using with()
        RequestSpecification request2 = RestAssured.with();
        // Setting Base URI
        request2.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request2.basePath("/ping");

        // You can also use builder pattern as below
        RequestSpecification request3 = RestAssured.with();
        request3.baseUri("https://restful-booker.herokuapp.com").basePath("/ping");

    }

}
