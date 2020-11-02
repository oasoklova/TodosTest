package pageObject;

import com.codeborne.selenide.Condition;
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
    public TodoPage createTask() {
        $x("//input[@class = 'new-todo']").setValue("test").pressEnter();
        return this;
    }

    @Step("Задача создана")
    public TodoPage checkCreatedTask() {
        $x("//ul[@class = 'todo-list']").shouldBe(visible);
        return this;
    }

    @Step("Сменить статус")
    public TodoPage changeStatusTask() {
        $x("//input[@class = \"toggle\"]").click();
        return this;
    }

    @Step("Статус изменился")
    public TodoPage checkStatusCompleted() {
        $x("//li[@class = \"completed\"]").shouldBe(visible);
        return this;
    }

    @Step("Статус изменился на противоположный")
    public TodoPage checkStatusNotCompleted() {
        $x("//li[@class = \"completed\"]").shouldNotBe(visible);
        return this;
    }

    @Step("Удаление задачи")
    public  TodoPage deleteTask(){
        $x("//ul[@class = 'todo-list']").hover();
        $x("//button [@class = 'destroy']").click();
        return this;
    }
    @Step("Проверка видимости текста")
    public TodoPage checkTaskVisible(){
      $x("//*[contains(text(),'test')]").shouldBe(visible);
        return this;
    }
    @Step("Проверка отсутствия текста")
    public TodoPage checkTaskNotVisible() {
        $x("//*[contains(.,'test')]").shouldBe(Condition.disappear);
        return this;
    }
}
