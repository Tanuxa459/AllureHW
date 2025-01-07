package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {


    @Step("Открываем репохиторий {repo}")
    public void openRepository(String repo){
        open(repo);
    }

    @Step("Переходим на  вкладку issues")
    public void clickUssues(){
        $("#issues-tab").click();
    }

    @Step("Проверяем надпись {title}")
    public void checkTitle(String title){
        $(".container-md").shouldHave(text(title));
    }



}
