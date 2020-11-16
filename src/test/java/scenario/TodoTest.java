package scenario;

import config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.TodoPage;
import utils.TestDataGenerator;

@DisplayName("Тестирование приложения todos")
public class TodoTest extends BaseTest {
    TodoPage todoPage = new TodoPage();

    @Test
    @DisplayName("Создание задачи")
    public void openPage() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask("test");
    }

    @Test
    @DisplayName("Смена статуса задачи")
    public void changeStatus() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask("test")
                .checkTextVisible("test")
                .changeStatusTask("test")
                .checkStatusCompleted();
    }

    @Test
    @DisplayName("Смена статуса задачи дважды")
    public void changeStatusTwice() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask("test")
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
                .checkCreatedTask("test")
                .checkTextVisible("test")
                .deleteTask("test")
                .checkTextNotVisible("test");

    }

    @Test
    @DisplayName("Редактирование задачи")
    public void taskEditing() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test")
                .checkCreatedTask("test")
                .checkTextVisible("test")
                .textEditing()
                .checkTextVisible("test2");
    }

    @Test
    @DisplayName("Показать список всех задач")
    public void taskFilterAll() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_complete")
                .changeStatusTask("test_complete")
                .checkStatusCompleted()
                .filterAll()
                .checkTextVisible("test_active")
                .checkTextVisible("test_complete");
    }

    @Test
    @DisplayName("Показать список активных задач")
    public void taskFilterActive() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_complete")
                .changeStatusTask("test_complete")
                .checkStatusCompleted()
                .filterActive()
                .checkTextNotVisible("test_complete");
    }

    @Test
    @DisplayName("Показать список выполненных задач")
    public void taskFilterComplete() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .checkCreatedTask("test_complete")
                .checkCreatedTask("test_active")
                .changeStatusTask("test_complete")
                .checkStatusCompleted()
                .filterComplete()
                .checkTextNotVisible("test_active");
    }

    @Test
    @DisplayName("Отметить все задачи")
    public void toggleAll() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_complete")
                .createTask("test_complete_2")
                .checkCreatedTask("test_complete")
                .checkCreatedTask("test_complete_2")
                .checkedAllTask()
                .filterComplete()
                .checkTextVisible("test_complete");
    }

    @Test
    @DisplayName("Отметить все задачи")
    public void toggleAllTwice() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_complete")
                .createTask("test_complete_2")
                .checkCreatedTask("test_complete")
                .checkCreatedTask("test_complete")
                .checkedAllTask()
                .checkedAllTask()
                .filterComplete()
                .checkTextNotVisible("test_complete");
    }

    @Test
    @DisplayName("Отметить все задачи с разным статусом")
    public void toggleTasksWithDifferentStatuses() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_complete")
                .changeStatusTask("test_complete")
                .checkStatusCompleted()
                .checkedAllTask()
                .filterComplete()
                .checkTextVisible("test_active");
    }

    @Test
    @DisplayName("Удалить выполненные задачи")
    public void deleteCompletedTasks() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_complete")
                .createTask("test_complete_2")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_complete")
                .checkCreatedTask("test_complete_2")
                .changeStatusTask("test_complete")
                .changeStatusTask("test_complete_2")
                .deleteCheckedTasks()
                .checkTextNotVisible("test_complete");
    }

    @Test
    @DisplayName("Проверка счётчика активных задач. Отметить одну задачу")
    public void checkCounterCheckTask() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_active_2")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_active_2")
                .checkCreatedTask("test_complete")
                .changeStatusTask("test_complete").counterActiveTasks("2");

    }

    @Test
    @DisplayName("Проверка счётчика активных задач.Снять отметку с выполненной задачи")
    public void uncheckCounterUncheckTask() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_active_2")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_active_2")
                .checkCreatedTask("test_complete")
                .changeStatusTask("test_complete")
                .changeStatusTask("test_complete")
                .counterActiveTasks("3");

    }

    @Test
    @DisplayName("Проверка счётчика активных задач. Удалить одну задачу")
    public void checkCounterDeleteTask() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask("test_active")
                .createTask("test_active_2")
                .createTask("test_complete")
                .checkCreatedTask("test_active")
                .checkCreatedTask("test_active_2")
                .checkCreatedTask("test_complete")
                .deleteTask("test_complete")
                .counterActiveTasks("2");

    }

    @Test
    @DisplayName("Создание задачи из пустой строки")
    public void taskInputLineNegative() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask(" ")
                .checkTaskNotVisible();

    }

    @Test
    @DisplayName("Создание задачи с длинным названием")
    public void longNameTaskNegative() {
        String taskText = TestDataGenerator.generateText(1000);
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .createTask(taskText)
                .checkCreatedTask(taskText);

    }

    @Test
    @DisplayName("Создание 100 задач")
    public void create100Tasks() {
        todoPage.openThisPage()
                .checkTextVisible("What needs to be done?")
                .creatingALotOfTasks("test", 100);

    }

}