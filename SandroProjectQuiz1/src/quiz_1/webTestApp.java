package quiz_1;

//- Create test class in `src/test/java` named `WebElementsTest.java`
//- Write a test that does the following:
//    - Open the chrome browser
//    - Navigate to the http://the-internet.herokuapp.com/add_remove_elements/
//    - Click to 'Add element' three times
//    - Print out the last 'Delete' button element's text with findElement()
//    - Print out the last 'Delete' button elements's text with findElements(). Use cssSelector as locator of element with class name , that starts with 'added' word
//
//    - Navigate to the http://the-internet.herokuapp.com/challenging_dom
//    - Using relative XPath, Print out the Lorem value of element, that has 'Apeirian9' as Ipsum value
//    - Using relative XPath, Print out the next element of element with Ipsum value 'Apeirian9'

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.Test;

public class WebElementsTest {

    WebDriver Driver;

    @Test
    public void openTab() {
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();
        Driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        AddElementThreeTimes();

        PrintDeleteButtonTextBy_findElement();

        PrintDeleteButtonTextBy_findElements();

    }

    private void AddElementThreeTimes() {
        var addButton = Driver.findElement(By.cssSelector("#content > div > button"));
        for (int i = 0; i < 3; i++) {
            addButton.click();
        }
    }

    private void PrintDeleteButtonTextBy_findElement() {
        var lastDeleteButton = Driver.findElement(By.cssSelector("#elements > button:nth-child(3)"));
        System.out.println(lastDeleteButton.getText());
    }

    private void PrintDeleteButtonTextBy_findElements() {
        var buttons = Driver.findElements(By.cssSelector("#elements > button"));
        var thirdButton = buttons.get(2);
        System.out.println(buttons.get(3));
    }

}