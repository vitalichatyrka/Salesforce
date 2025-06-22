package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountDetailsPage open() {
        log.info("Opening AccountDetails page");
        return null;
    }

    @Override
    public AccountDetailsPage isPageOpened() {
        log.info("AccountDetails page is opened");
        return null;
    }
}
