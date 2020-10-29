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
                .checkOpenThisPage()
                .taskInputLine()
                .checkTaskInputLine();
    }

    @Test
    @DisplayName("Смена статуса задачи")
    public void changeStatus() {
        todoPage.openThisPage()
                .checkOpenThisPage()
                .taskInputLine()
                .checkTaskInputLine()
                .changeStatusTask()
                .checkChangeStatusTask();
    }
    @Test
    @DisplayName("Смена статуса одной задачи дважды")
public void changeStatusTwice(){
        todoPage.openThisPage()
            .checkOpenThisPage()
            .taskInputLine()
            .checkTaskInputLine()
            .changeStatusTaskTwice();

}


}
