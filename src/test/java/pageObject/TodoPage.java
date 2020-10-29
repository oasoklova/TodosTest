package pageObject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TodoPage {
    private final String PAGE_URL = "/";

    @Step("Открытие главной страницы")
    public TodoPage openThisPage() {
        open(PAGE_URL);
        return this;
    }
    @Step("Страница открыта")
    public TodoPage checkOpenThisPage() {
        $x("//input[@placeholder ='What needs to be done?' ]").shouldBe(visible);
        return this;
    }

    @Step("Создание задачи")
    public TodoPage taskInputLine() {
        $x("//input[@class = 'new-todo']").setValue("test").pressEnter();
        return this;
    }
    @Step("Задача создана")
    public TodoPage checkTaskInputLine(){
        $x("//ul[@class = 'todo-list']").shouldBe(visible);
        return this;
    }

    @Step("Сменить статус")
    public TodoPage changeStatusTask(){

        return this;
    }
    @Step("Статус изменился")
    public TodoPage checkChangeStatusTask(){
        $x("//li[@class = \"completed\"]").shouldBe(visible);
        return this;
    }
    @Step("Сменить статус задачи дважды")
    public TodoPage changeStatusTaskTwice(){
        $x("//input[@class = \"toggle\"]").click();
        $x("//input[@class = \"toggle\"]").click();
        return this;
    }
    public TodoPage checkChangeStatusTaskTwice(){

        return this;
    }



}
