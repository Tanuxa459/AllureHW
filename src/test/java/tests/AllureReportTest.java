package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class AllureReportTest extends TestBase{

    public static final String REPOSITORY = "Tanuxa459/AllureHW";
    public static final String TITLE = "Welcome to issues!";
    @Test
    void SelenideTest (){

            open("Tanuxa459/AllureHW");
            $("#issues-tab").click();
            $(".container-md").shouldHave(text("Welcome to issues!"));
    }
    @Test
    void LambdaTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открываем страницу с репозиторием" + REPOSITORY, () -> {
            open(REPOSITORY);
        });
        step("Нажимаем на вкладку issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем строку на кладке issues", () -> {
            $(".container-md").shouldHave(text(TITLE));
        });

    }
    @Test
    public void annotetedStepsTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();
        step.openRepository(REPOSITORY);
        step.clickUssues();
        step.checkTitle(TITLE);


    }




}


