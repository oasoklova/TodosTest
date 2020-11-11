package pageObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TodoPage {
    private final String PAGE_URL = "/";

    @Step("Я открываю главную страницу")
    public TodoPage openThisPage() {
        open(PAGE_URL);
        return this;
    }

    @Step("Я создаю задачу {0}")
    public TodoPage createTask(String text) {
        String inputLine = "//input[@class = 'new-todo']";
        $x(inputLine).setValue(text).pressEnter();
        return this;
    }

    @Step("Я проверяю, что задача {0} создана")
    public TodoPage checkCreatedTask(String text) {
        String taskList = "//input[@class='edit'][@value = '%s']/../..";
        String selector = String.format(taskList, text);
        $x(selector).shouldBe(visible);
        return this;
    }

    @Step("Я меняю статус задачи {0}")
    public TodoPage changeStatusTask(String text) {
        String checkBox = String.format("//li[contains(.,'%s')]//input[@type = 'checkbox']", text);
        $x(checkBox).click();
        return this;
    }

    @Step("Я проверяю, что статус изменился")
    public TodoPage checkStatusCompleted() {
        $x("//li[@class = 'completed']").shouldBe(visible);
        return this;
    }

    @Step("Я ожидаю, что статус сменился на противоположный")
    public TodoPage checkStatusNotCompleted() {
        $x("//li[@class = 'completed']").shouldNotBe(visible);
        return this;
    }

    @Step("Я удаляю задачу {0}")
    public TodoPage deleteTask(String text) {
        String textSelector = "//input[@class='edit'][@value = '%s']/..";
        String destroyButton = "//button [@class = 'destroy']";
        String selector = String.format(textSelector, text);
        $x(selector).hover();
        $x(selector + destroyButton).click();
        return this;
    }

    @Step("Я проверяю, что текст {0} видимый")
    public TodoPage checkTextVisible(String text) {
        String textSelector = "//*[contains(., '%s')]";
        String selector = String.format(textSelector, text);
        $x(selector).shouldBe(visible);

        return this;
    }

    @Step("Я проверяю, что текст {0} невидимый")
    public TodoPage checkTextNotVisible(String text) {
        String textSelector = "//*[contains(., '%s')]";
        String selector = String.format(textSelector, text);
        $x(selector).shouldBe(Condition.disappear);
        return this;
    }

    @Step("Я редактирую задачу")
    public TodoPage textEditing() {
        String textSelector = "//ul[@class = 'todo-list']//li[1]";
        $x(textSelector).hover().doubleClick();
        String inputSelector = textSelector + "/input";
        $x(inputSelector).shouldBe(focused).sendKeys(Keys.CONTROL, "a");
        $x(inputSelector).shouldBe(focused).sendKeys(Keys.DELETE);
        $x(inputSelector).shouldBe(focused).sendKeys("test2");
        $x(inputSelector).shouldBe(focused).pressEnter();
        return this;
    }

    @Step("Я выбираю фильтр All")
    public TodoPage filterAll() {
        $x("//a[@href='#/']").click();
        return this;
    }

    @Step("Я выбираю фильтр Active")
    public TodoPage filterActive() {
        $x("//a[@href='#/active']").click();
        return this;
    }

    @Step("Я выбираю фильтр Complete")
    public TodoPage filterComplete() {
        $x("//a[@href='#/completed']").click();
        return this;
    }

    @Step("Я устанавливаю все задачам статус выполнено")
    public TodoPage checkedAllTask() {
        $x("//label[@for='toggle-all']").click();
        return this;
    }

    @Step("Я устанавливаю всем задачам статус активно")
    public TodoPage deleteCheckedTasks() {
        $x("//button[@class='clear-completed']").click();
        return this;
    }

    @Step("Я проверяю, что на счётчике отображается число {0}")
    public TodoPage counterActiveTasks(String count) {
        String textSelector = "//strong[@data-reactid='.0.2.0.0'][text()= '%s']";
        String selector = String.format(textSelector, count);
        $x(selector).shouldBe(visible);

        return this;
    }

    @Step("Я проверяю, что задача не создана")
    public TodoPage checkTaskNotVisible(){
        $x("//ul[@class = 'todo-list']").shouldNotBe(visible);
        return this;
    }
}
