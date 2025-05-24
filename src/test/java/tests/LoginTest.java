package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkSuccessLogin() {
        loginPage.openLoginPage();
        loginPage.fillInLoginCredentials(loginPage.getAdminName(), loginPage.getAdminPassword());
        loginPage.clickLogInButton();
        softAssert.assertTrue(driver.findElement(
                By.xpath("//div[@role='tablist']")).isDisplayed());
    }

}
