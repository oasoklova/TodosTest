package scenario;

import config.BaseTest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.TodoPage;

@DisplayName("Тестирование приложения todos")
public class TodoTest extends BaseTest {
    TodoPage todoPage = new TodoPage();

    @Test
    @DisplayName("Создание задачи")
    public void openPage() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask();
    }

    @Test
    @DisplayName("Смена статуса задачи")
    public void changeStatus() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask()
                .checkTextVisible("test")
                .changeStatusTask("test")
                .checkStatusCompleted();
    }

    @Test
    @DisplayName("Смена статуса одной задачи дважды")
    public void changeStatusTwice() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask()
                .changeStatusTask("test")
                .checkStatusCompleted()
                .changeStatusTask("test")
                .checkStatusNotCompleted();

    }

    @Test
    @DisplayName("Удаление задачи")
    public void removeTask() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask()
                .checkTextVisible("test")
                .deleteTask()
                .checkTextNotVisible("test");

    }

    @Test
    @DisplayName("Редактирование задачи")
    public void taskEditing(){
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask()
                .checkTextVisible("test")
                .textEditing()
                .checkTextVisible("test2");
    }

    @Test
    @DisplayName("Показать список всех задач")
    public void taskFilterAll(){
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .checkCreatedTask()
                .changeStatusTask("test_complete")
                .checkStatusCompleted()
                .filterAll()
                .checkTextVisible("test_active")
                .checkTextVisible("test_complete");
    }

}
