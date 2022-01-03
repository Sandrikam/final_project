package Deserialize_new;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class restassured_homework<ISBN> {

    private Object Book;

    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";

    String baseUrl = "https://demoqa.com/BookStore/v1/";

    private static Response response;


    @Test

    public void getBook() {

        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();

        Response response = request.get("/Books");

        System.out.println("Response Body is =>  " + response.asString());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

        String contentType = response.header("Content-Type");

        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
    }

    @Test

    public void DisplayBooks() {

        Book response = RestAssured.given().when()

                .get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862")

                .as(Book.class);

        System.out.println("ISBN is: " + response.isbn);

        System.out.println("title is: " + response.title);

        System.out.println("subTitle is: " + response.subTitle);
    }


    @Test

    public void addBooks() {

        RequestSpecification request = given();

        given().queryParam("ISBN", Request.ISBN, ObjectMapperType.JAXB).when()

                .get("https://bookstore.toolsqa.com/BookStore/v1/Book").then().log().all();

    }


    @Test

    public void bookIsAdded() {

        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();

        Response response = request.get("/Books");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

        Assert.assertEquals(Request.ISBN,Request.ISBN,"Book Exixsts");
    }

}
