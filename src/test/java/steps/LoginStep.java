package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

@Log4j2
public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void auth(String user, String password) {
        log.info("Authorization with user name: {} and password: {}", user, password);
        loginPage.open()
                .isPageOpened()
                .login(loginPage.getAdminName(), loginPage.getAdminPassword())
                .isPageOpened();
    }
}

