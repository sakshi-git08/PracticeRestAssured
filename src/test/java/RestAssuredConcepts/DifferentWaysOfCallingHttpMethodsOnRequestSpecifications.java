package RestAssuredConcepts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DifferentWaysOfCallingHttpMethodsOnRequestSpecifications {


    public static void main(String[] args) {

        // Creating request specification using given()
        RequestSpecification requestSpecification = RestAssured.given();
        // Setting Base URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        requestSpecification.basePath("/booking");


        // We can directly call http verbs on RequestSpecification
        Response res1= requestSpecification.get();
        System.out.println(res1.asString());

        // We can also pass RequestSpecification reference variable in overloaded given() method
        Response res2 = RestAssured.given(requestSpecification).get();
        System.out.println(res2.asString());

        // We can also pass RequestSpecification using spec() method
        Response res3 = RestAssured.given().spec(requestSpecification).get();
        System.out.println(res3.asString());


    }

}
