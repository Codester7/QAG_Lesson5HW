import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5HW {
    @Test
    void Hw5() {
        open("https://github.com/selenide/selenide");
        $("[data-tab-item=i5wiki-tab]").click();
        $(byText("Show 2 more pages…")).scrollTo().click();
        $(".Box.Box--condensed.color-shadow-small").$("[href$=SoftAssertions]").click();
        $(".markdown-body").scrollTo().shouldHave(text("3. Using JUnit5 extend test class"));
        SelenideElement parent = $("#user-content-3-using-junit5-extend-test-class").parent();             //user-content-3-using-junit5-extend-test-class
        SelenideElement sibling = $(parent).sibling(0);                                                        // ищу родителя этого класса
        $(sibling).shouldHave(text("class Tests {\n" +                                                         // поcле ищу сиблинга 0 после h4
                "  @Test\n" +                                                                                // после ищу в классе текст
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

}
