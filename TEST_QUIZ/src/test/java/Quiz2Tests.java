import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public void callAllTests(){
        taskThree();
        openTab();
        openBrowser();
    }

    public void openTab() {

//
//            - Open the chrome browser
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();

// - Navigate to the https://demoqa.com/progress-bar

        Driver.get("https://demoqa.com/progress-bar");
//            - Click to 'Start' button
        Driver.findElements(By.id("startStopButton")).get(0).click();

// - Wait until progress bar reach 100 % and print '100%'
        waitUntillAction();



    }

    //

    public void waitUntillAction(){
        String xpathQuery = "//div[contains(@id,'progressBar')]";


        WebDriverWait wait = new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathQuery)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathQuery)));

        System.out.println("100%");

    }



// - Open the chrome browser

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();

// - Navigate to the http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
        Driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

//            - Choose programming language from dropdown and ensure that it was selected
        Select progLang = new Select(Driver.findElement(By.id("dropdowm-menu-1")));
        progLang.selectByVisibleText("Python");
        progLang.deselectByIndex(1);
// - Click on all unselected checkboxes



// - Click on 'Yellow' radio button
        Select radioBtn = new Select(Driver.findElement(By.name("color")));
        radioBtn.selectByVisibleText("Green");

    }
// - In 'Selected & Disabled' section check that 'Orange' option in dropdown is disabled

    public void taskThree(){
        WebDriverManager.chromedriver().setup();


// - Open the chrome browser
        Driver = new ChromeDriver();
// - Navigate to the http://the-internet.herokuapp.com/iframe

        Driver.get("http://the-internet.herokuapp.com/iframe");
//            - Write text 'Here Goes' in text field

        WebElement textInput = Driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        textInput.click();
//        WebElement textContent = Driver.findElement(By.id("tinymce"));
//        textContent.clear();
        //Driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
        //textInput.sendKeys("Here Goes");

        WebDriverWait wait = new WebDriverWait(Driver, 5);
        // - Click on 'Align center' icon
        WebElement centerAlign = Driver.findElement(By.xpath("//*[@aria-label='Align center']"));
        centerAlign.click();
    }

    }
//
//
//
// - Run all test in headless mode


