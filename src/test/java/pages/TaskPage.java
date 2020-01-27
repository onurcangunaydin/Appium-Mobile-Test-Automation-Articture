package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class TaskPage extends BasePage {

    private By taskTitle = MobileBy.id("add_task_title_edit_text");
    private By taskDescription = MobileBy.id("add_task_description_edit_text");
    private By saveTaskButton = MobileBy.id("save_task_fab");
    private By editTaskButton = MobileBy.id("edit_task_fab");
    private By taskLists = MobileBy.id("title_text");
    private By deleteTask = MobileBy.id("menu_delete");


    public TaskPage(){
        super();
    }

    public TaskPage addTask(String taskTitleText, String taskDescriptionText){
        getAppiumClient().fillTextBox(taskTitle,taskTitleText);
        getAppiumClient().fillTextBox(taskDescription,taskDescriptionText);
        getAppiumClient().click(saveTaskButton);
        return this;

    }

    public TaskPage goToTask(int taskIndex){
        List<MobileElement> tasks = getDriver().findElements(taskLists);
        tasks.get(taskIndex).click();
        return this;
    }

    public TaskPage editTask(int TaskIndex , String newTaskTitle,String newTaskDescription){
        getDriver().findElements(taskLists).get(TaskIndex).click();
        getAppiumClient().click(editTaskButton);
        getAppiumClient().fillTextBox(taskTitle,newTaskTitle);
        getAppiumClient().fillTextBox(taskDescription,newTaskDescription);
        getAppiumClient().click(saveTaskButton);

        return this;

    }

    public HomePage  deleteTask(int taskIndex){
        goToTask(taskIndex);
        getAppiumClient().click(deleteTask);
        return new HomePage();
    }


}
