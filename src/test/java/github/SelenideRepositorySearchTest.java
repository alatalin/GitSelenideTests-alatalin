package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideRepositorySearchTest {

    @BeforeAll
    static void setupBeforeTest() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldFindSoftAssertionsJUnitCode() {
       open("/selenide/selenide");
       $("#wiki-tab").click();
       $("#wiki-body").shouldBe(visible).shouldHave(text("Soft assertions"));
       $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
       $("#wiki-body").shouldHave(text(
               "@ExtendWith({SoftAssertsExtension.class})\n" +
               "class Tests {\n" +
               "  @Test\n" +
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
