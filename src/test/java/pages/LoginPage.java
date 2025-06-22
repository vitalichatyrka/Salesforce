package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    private final By LOGIN_BUTTON = By.id("Login"),
            USER_NAME_FIELD = By.id("username"),
            PASSWORD_FIELD = By.id("password");

    private final String adminName = "tborodich@tms.sandbox";
    private final String adminPassword = "Password002!";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        log.info("Opening Login page {}", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_BUTTON)));
            log.info("Login Page is opened");
        } catch (Exception e) {
            log.error("Login Page is NOT opened: " + e.getMessage(), e);
            throw new AssertionError("Login Page did not open as expected", e);
        }
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    @Step("Input name: {userName} and password: {password) and click to the 'Log in' button for login action")
    public HomePage login(String userName, String password) {
        log.info("Log in with credentials {} in to {}", userName, password);
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Log in with username: {} and password: {} ",userName, password );
        return new HomePage(driver);
    }

}
