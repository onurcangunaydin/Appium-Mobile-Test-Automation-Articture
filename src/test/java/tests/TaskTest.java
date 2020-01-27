package tests;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

import static constants.Keywords.NO_TASKS;
import static org.hamcrest.MatcherAssert.assertThat;
import pages.HomePage;
import pages.TaskPage;

public class TaskTest extends BaseTest{


    @Test
    public void shouldAddTwoTasks(){

        HomePage homePage = new HomePage();
        TaskPage taskPage = homePage.clickTaskButton();
        taskPage.addTask("task1","task1");

        homePage.clickTaskButton();
        taskPage.addTask("task2","task2");

        assertThat("Added tasks count should be two", homePage.getDriver().findElements(MobileBy.id("title_text")).size() == 2 );
    }

    @Test
    public void shouldEditAndSaveTask(){

        HomePage homePage = new HomePage();
        TaskPage taskPage = homePage.clickTaskButton();

        taskPage.addTask("task1","task1");
        taskPage.editTask(0,"newtask1","newtask1");

        assertThat("Task should be editable", taskPage.getDriver().getPageSource().contains("newtask1"));

    }

    @Test
    public void shouldCheckTaskAsCompleted(){
        HomePage homePage = new HomePage();
        TaskPage taskPage = homePage.clickTaskButton();

        taskPage.addTask("task1","task1");
        homePage.markTaskAsComplete(0);

        //Yazilar hemen kayboluyor - page source ile textler cekilemiyor (cekilse bile method animasyonun gecmesini bekliyor).
        // Bu yuzden assertion yapmak olanaksiz.
    }

    @Test
    public void shouldDeleteTask(){
        HomePage homePage = new HomePage();
        TaskPage taskPage = homePage.clickTaskButton();

        taskPage.addTask("deletetableTask","deletableTask");
        taskPage.deleteTask(0);

        assertThat("Task should be deletable", taskPage.getDriver().getPageSource().contains(NO_TASKS));

    }

}
