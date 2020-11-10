package pageObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TodoPage {
    private final String PAGE_URL = "/";

    @Step("Открытие главной страницы")
    public TodoPage openThisPage() {
        open(PAGE_URL);
        return this;
    }
       @Step("Создание задачи")
    public TodoPage createTask(String text) {
        String inputLine = "//input[@class = 'new-todo']";
        $x(inputLine).setValue(text).pressEnter();
        return this;
    }

    @Step("Задача создана")
    public TodoPage checkCreatedTask() {
        String taskList = "//ul[@class = 'todo-list']";
        $x(taskList).shouldBe(visible);
        return this;
    }

    @Step("Сменить статус")
    public TodoPage changeStatusTask(String text) {
        String checkBox = String.format("//li[contains(.,'%s')]//input[@type = 'checkbox']", text);
        $x(checkBox).click();
        return this;
    }

    @Step("Статус изменился")
    public TodoPage checkStatusCompleted() {
        $x("//li[@class = 'completed']").shouldBe(visible);
        return this;
    }

    @Step("Статус изменился на противоположный")
    public TodoPage checkStatusNotCompleted() {
        $x("//li[@class = 'completed']").shouldNotBe(visible);
        return this;
    }

    @Step("Удаление задачи")
    public TodoPage deleteTask() {
        $x("//ul[@class = 'todo-list']").hover();
        $x("//button [@class = 'destroy']").click();
        return this;
    }

    @Step("Проверка видимости текста")
    public TodoPage checkTextVisible(String text) {
        String textSelector = "//*[contains(., '%s')]";
        String selector = String.format(textSelector, text);
        $x(selector).shouldBe(visible);

        return this;
    }

    @Step("Проверка отсутствия текста")
    public TodoPage checkTextNotVisible(String text) {
        String textSelector = "//*[contains(., '%s')]";
        String selector = String.format(textSelector, text);
        $x(selector).shouldBe(Condition.disappear);
        return this;
    }
    @Step("Редактирование задачи")
    public TodoPage textEditing(){
        String textSelector = "//ul[@class = 'todo-list']//li[1]";
        $x(textSelector).hover().doubleClick();
        String inputSelector = textSelector + "/input";
        $x(inputSelector).shouldBe(focused).sendKeys(Keys.CONTROL,"a");
        $x(inputSelector).shouldBe(focused).sendKeys(Keys.DELETE);
        $x(inputSelector).shouldBe(focused).sendKeys("test2");
        $x(inputSelector).shouldBe(focused).pressEnter();
        return this;
    }
    @Step("Показать весь список задач")
    public TodoPage filterAll(){
        $x("//a[@href=\"#/\"]").click();
        return this;
    }

    @Step("Показать список активных задач")
    public TodoPage filterActive(){
        $x("//a[@href=\"#/active\"]").click();
        return this;
    }
    @Step("Показать список выполненых задач")
    public TodoPage filterComplete(){
        $x("//a[@href='#/completed']").click();
        return this;
    }
    @Step("Выбрать всё")
    public TodoPage checkedAllTask(){
        $x("//label[@for='toggle-all']").click();
        return this;
    }
    @Step("Очистить список выполненных задач")
    public TodoPage deleteCheckedTasks(){
        $x("//button[@class='clear-completed']").click();
        return this;
    }
}
