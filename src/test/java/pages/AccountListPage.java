package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage{

    private final String accountsPageUrl =
            "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=__Recent";

    @Step
    public void openAccountsPage() {
        driver.get(accountsPageUrl);
    }
    public AccountListPage(WebDriver driver) {
        super(driver);
    }
}
