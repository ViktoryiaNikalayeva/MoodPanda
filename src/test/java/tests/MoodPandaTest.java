package tests;

import org.testng.annotations.Test;


public class MoodPandaTest extends BaseTest {


    @Test(description = "check correct updating of mood with data = 'Older' + registration")
    public void loginOlder() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "Older", "2020", "Feb", "29", "5 am", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description", "2020", "Feb", "29");

    }

    @Test(description = "check correct updating of mood with data = 'Now' + registration")
    public void loginNow() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "Now")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description");

    }

    @Test(description = "check correct updating of mood with data = 'Yesterday'")
    public void loginYesterdayDay() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "Yesterday", "5 am", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description", "1d ·");

    }

    @Test(description = "check correct updating of mood with data = '2 days ago' + registration")
    public void login2Days() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "2 days ago", "5 am", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description", "2d ·");

    }


    @Test(description = "check correct updating of mood with data = '3 days ago' + registration")
    public void login3Days() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "3 days ago", "5 am", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description", "3d ·");

    }

}
