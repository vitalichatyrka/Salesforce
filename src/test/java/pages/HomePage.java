package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        log.info("Opening home page {} ", String.format("%slightning/setup/SetupOneHome/home", BASE_URL));
        driver.get(String.format("%slightning/setup/SetupOneHome/home", BASE_URL));
        return this;
    }

    @Override
    public HomePage isPageOpened() {
        log.info("Home page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".uiImage")));
        return this;
    }

}
