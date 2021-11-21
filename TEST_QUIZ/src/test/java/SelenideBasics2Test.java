import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.commands.GetInnerText;
import com.codeborne.selenide.commands.ShouldHave;
import com.codeborne.selenide.conditions.ExactText;
import com.codeborne.selenide.selector.ByText;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Test
public class SelenideBasics2Test {

    public void runTest() {
        open("https://demoqa.com/books");
        $(".rt-tbody").shouldHave(value("O'Reilly Media"));// $("O'Reilly Media");
        $$("div").shouldHave(CollectionCondition.size(10));

    }}
//.$(".rt-td")