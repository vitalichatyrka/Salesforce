package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By LOGIN_BUTTON = By.id("Login"),
            USER_NAME_FIELD = By.id("username"),
            PASSWORD_FIELD = By.id("password");

    private final String adminName = "tborodich@tms.sandbox";
    private final String adminPassword = "Password002!";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    @Step("Opening the login page")
    public void openLoginPage() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Input name: {userName} and password: {password) for login action")
    public void fillInLoginCredentials(String userName, String password) {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Click to the 'Log in' button")
    public void clickLogInButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
