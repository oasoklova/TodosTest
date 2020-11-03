package scenario;

import config.BaseTest;
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
                .checkStatusCompleted();
    }

    @Test
    @DisplayName("Смена статуса одной задачи дважды")
    public void changeStatusTwice() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask()
                .changeStatusTask()
                .checkStatusCompleted()
                .changeStatusTask()
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
                .checkTaskNotVisible();

    }
}
