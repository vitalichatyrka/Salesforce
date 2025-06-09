package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkSuccessLogin() {
        loginPage.open()
                .login(loginPage.getAdminName(), loginPage.getAdminPassword())
                .isPageOpened();
        assertTrue(driver.findElement(
                By.xpath("//div[@role='tablist']")).isDisplayed());
    }
}
