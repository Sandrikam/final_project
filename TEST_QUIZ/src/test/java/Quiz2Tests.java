import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

public class Quiz2Tests {

    WebDriver Driver;

//    Build automation test in IntelliJ IDEA:
//
//            - Create test class in `src/test/java` named `Quiz2Test.java`
//            - Write test that does the following:

    @Test
    public void openTab() {

//
//            - Open the chrome browser
// - Navigate to the https://demoqa.com/progress-bar
//            - Click to 'Start' button
// - Wait until progress bar reach 100 % and print '100%'
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();
        Driver.get("https://demoqa.com/progress-bar");
        Driver.findElements(By.id("startStopButton")).get(0).click();

        waitUntillAction();



    }

    public void waitUntillAction(){
        String xpathQuery = "//div[contains(@id,'progressBar')]";


        WebDriverWait wait = new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathQuery)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathQuery)));

        System.out.println("100%");

    }
//            - Open the chrome browser
// - Navigate to the http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
//            - Choose programming language from dropdown and ensure that it was selected
// - Click on all unselected checkboxes
// - Click on 'Yellow' radio button
// - In 'Selected & Disabled' section check that 'Orange' option in dropdown is disabled
//
//
// - Open the chrome browser
// - Navigate to the http://the-internet.herokuapp.com/iframe
//            - Write text 'Here Goes' in text field
// - Click on 'Align center' icon
//
// - Run all test in headless mode

}
