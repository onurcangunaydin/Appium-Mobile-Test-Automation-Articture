package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By addTaskButton = MobileBy.id("add_task_fab");
    private By taskCheckbox = MobileBy.id("complete_checkbox");



    public TaskPage clickTaskButton(){

        getAppiumClient().click(addTaskButton);
        return new TaskPage();
    }
    public HomePage() {
        super();
    }

    public void markTaskAsComplete(int taskIndex){
        getDriver().findElements(taskCheckbox).get(taskIndex).click();
    }

}
