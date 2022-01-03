package Final_Project.Task2;

// --------  IMPORTS ----------------

import io.restassured.specification.RequestSpecification;
import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.testng.Assert;

import java.util.List;

public class main {

    @BeforeClass
    public static void SetUpBrowser() {
        Configuration.browser = "edge";
        SelenideLogger.addListener("allure", new AllureSelenide());
        System.out.println("browser Started! ");
    }


    @BeforeMethod
    public void SetUp() {
        open("https://demoqa.com/books");
        System.out.println("Page opened! ");
    }


    @Test
    public void Test() {
        var domBooks = _getDOMBooks();
        System.out.println("got api! ");
        var apiBooks = _getApiBooks();
        System.out.println("got books! ");


        assert apiBooks != null;
        var filteredApiBooks = _filterApiBooksByPublisher(apiBooks, "O'Reilly Media");
        bookCountValidator(domBooks, filteredApiBooks);
        System.out.println("filtered Books: " + filteredApiBooks);


        ECMAScriptValidator(domBooks, apiBooks);

    }


    private List<SelenideElement> _getDOMBooks() {
        var searchBoxElement = $("#searchBox");
        var searchPhrase = "O'Reilly Media";

        searchBoxElement.setValue(searchPhrase);
        var cssSelector = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper >" +
                " div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody  .rt-tr:not(.-padRow)";
        return $$(cssSelector).stream().toList();

    }


    private List<bookDetails> _filterApiBooksByPublisher(List<bookDetails> apiBooks, String publisher) {
        return apiBooks.stream().filter(book -> book.publisher.contains(publisher)).toList();
    }

    private List<bookDetails> _getApiBooks() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        RequestSpecification req = RestAssured.given();
        var bodyData = new JsonObject();
        var jsonString = bodyData.toString();

        req.header("Content-Type", "application/json");
        req.body(jsonString);


        var response = req.get("/BookStore/v1/Books");
        var apiBookResponse = _parseResponseBody(response.getBody());
        if (apiBookResponse == null) {
            return null;
        }
        return apiBookResponse.books;


    }


    private getBookDetails.RGETApiBooksDetails _parseResponseBody(ResponseBody responseBody) {
        try {
            return responseBody.as(getBookDetails.RGETApiBooksDetails.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    private void bookCountValidator(List<SelenideElement> bookElements, List<bookDetails> apiBooks) {
        Assert.assertEquals(bookElements.size(), apiBooks.size());
    }

    private void ECMAScriptValidator(List<SelenideElement> bookElements, List<bookDetails> apiBooks) {
        var isLast = eCMAScriptIsLast(bookElements, apiBooks);
        Assert.assertFalse(isLast);
    }

    private boolean eCMAScriptIsLast(List<SelenideElement> bookElements, List<bookDetails> apiBooks) {
        var isLast = false;
        var actualTitle = "Understanding ECMAScript 6";
        var lastApiBook = apiBooks.get(apiBooks.size() - 1);


        isLast = lastApiBook.title.contains(actualTitle);
        if (!isLast) {
            return false;
        }

        var lastBookElement = bookElements.get(bookElements.size() - 1);
        isLast = lastBookElement.getText().contains(actualTitle);
        System.out.println("Book is last: " + isLast);
        return isLast;
    }


}
