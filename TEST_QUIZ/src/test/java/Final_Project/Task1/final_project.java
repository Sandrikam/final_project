package Final_Project;

// --------  IMPORTS ----------------

import io.restassured.specification.RequestSpecification;

import io.github.bonigarcia.wdm.WebDriverManager;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.testng.Assert;


//Main Class that contains all the test classes
public class final_project {

    //first test case
    @Test
    public void addUserData() {
//defining a URL variable
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
//creating a JSON object
        var bodyData = new JsonObject();

        //getting variables from @userData file which contains USERNAME and PASSWORD
        bodyData.addProperty("userName", userData.USERNAME);
        bodyData.addProperty("password", userData.PASSWORD);
//checking what is in the body
        System.out.println("Data is: " + bodyData);
//conversion of a JSON body to a string
        var jsonString = bodyData.toString();
        request.header("Content-Type", "application/json");
        request.body(jsonString);

        System.out.println("json is: " + jsonString);

//sending request to register a new username
        var response = request.post("/Account/v1/User");
        var statusCode = response.getStatusCode();

//checking response status to be sure that user is registered.
        Assert.assertEquals(statusCode, 200 | 201);

        System.out.println("User Created with: " + statusCode);
    }

    @Test
    public void LogIn() throws InterruptedException {
/*

//login with a request

//defining a base URL
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
//creating requst body
        var bodyData = new JsonObject();
        bodyData.addProperty("userName", userData.USERNAME);
        bodyData.addProperty("password", userData.PASSWORD);

        System.out.println("Data is: " + bodyData);
//body to string conversion.
        var jsonString = bodyData.toString();
        request.header("Content-Type", "application/json");
        request.body(jsonString);

        System.out.println("json is: " + jsonString);

        //sending login request
        var response = request.post("/Account/v1/Authorized");
        var statusCode = response.getStatusCode();

        System.out.println("User logged in with: " + statusCode);
//recieving and expecting code 200 OK  to be sure that user is logged in
        Assert.assertEquals(statusCode, 200);
*/

        //accessing Delete Account Btn
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://demoqa.com/login";
        driver.get(url);

       // webdriver().wait(200);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        userName.click();
        userName.sendKeys(userData.USERNAME);

       // webdriver().wait(200);

        WebElement passWord = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passWord.click();
        passWord.sendKeys(userData.PASSWORD);

       // webdriver().wait(200);
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginBtn.click();

/*
        var deleteAccountSelectorString = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 >" +
                " div.profile-wrapper > div.mt-2.buttonWrap.row > div.text-center.button > button";
        $(deleteAccountSelectorString)
                .click();
        Thread.sleep(200);

        var okBtnSelector = "#closeSmallModal-ok";
        $(okBtnSelector).click();

        var text = switchTo().alert().getText();
        switchTo().alert().accept();
        Assert.assertEquals(text, "User Deleted.");

        Thread.sleep(100);
*/

/*
        var deleteAccountSelectorString = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 >" +
                " div.profile-wrapper > div.mt-2.buttonWrap.row > div.text-center.button > button";
        $(deleteAccountSelectorString)
                .click();
*/

        WebElement delUsrBtn = driver.findElement(By.xpath("//*[@id=\\\"submit\\\"][1]")); //.findElement(By.xpath("//*[@id=\"submit\"]"));
        delUsrBtn.click();


/*
switchTo().frame("profile").
        $("#userName").setValue(userData.USERNAME);
        $("#password").setValue(userData.PASSWORD);
        $("#login").click();
        Thread.sleep(1000);*/

/*

        var delAcctBtnAction = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 >" +
                " div.profile-wrapper > div.mt-2.buttonWrap.row > div.text-center.button > button";
        $(delAcctBtnAction)
                .click();

        System.out.println("Clicked delAcctBtnAction btn: " + delAcctBtnAction);

        //Thread.sleep(200);
        var okBtnSelector = "#closeSmallModal-ok";
        $(okBtnSelector).click();

        System.out.println("btn ok Selected");

        var text = switchTo().alert().getText();
        switchTo().alert().accept();
        Assert.assertEquals(text, "User Deleted.");

        System.out.println("text is: " + text);


        // Thread.sleep(100);
*/

    }

    @Test
    public void validateMessage(){
        //login with a request

//defining a base URL
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
//creating requst body
        var bodyData = new JsonObject();
        bodyData.addProperty("userName", userData.USERNAME);
        bodyData.addProperty("password", userData.PASSWORD);

        System.out.println("Data is: " + bodyData);
//body to string conversion.
        var jsonString = bodyData.toString();
        request.header("Content-Type", "application/json");
        request.body(jsonString);

        System.out.println("json is: " + jsonString);

        //sending login request
        var response = request.post("/Account/v1/Authorized");
        var statusCode = response.getStatusCode();
        var message = response.asString();

        System.out.println("User logged in with: " + statusCode);
//recieving and expecting code 200 OK  to be sure that user is logged in
        Assert.assertEquals(statusCode, 404);
        //var invalidUserText = $("#name").getText();
        Assert.assertEquals(message, "Invalid username or password!");

    }
/*    @Test
    public void CallRequest() {
        var url = "https://bookstore.toolsqa.com/Account/v1";
        RestAssured.baseURI = url;

        RequestSpecification req = RestAssured.given();

        var bodyData = new JsonObject();
        bodyData.addProperty("userName", userData.USERNAME);
        bodyData.addProperty("password", userData.PASSWORD);

        var jsonString = bodyData.toString();
        req.header("Content-Type", "application/json");
        req.body(jsonString);


        var res = req.post("/Authorized");
        var data = ParseResponseBody(res.getBody());

        Assert.assertEquals(data.message, "User not found!");
    }*/
}