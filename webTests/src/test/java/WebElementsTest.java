
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
        for (int i = 0; i <= 2; i++) {
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
