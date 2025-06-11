package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AccountListPage extends BasePage{

    private final String accountsPageUrl = String.format("%s/lightning/o/Account/list?filterName=__Recent", BASE_URL);
    private final By titleOfAccountsTable = By.xpath("//div[@class='slds-breadcrumb slds-list_horizontal slds-wrap']//ancestor::h1");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage open() {
        log.info("Opening AccountList page {}", accountsPageUrl);
        driver.get(accountsPageUrl);
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleOfAccountsTable)));
        log.info("AccountListPage is opened");
        return this;
    }

    @Step
    public WebElement findCreatedAccountLink(String nameOfCreatedAccount) {
        log.info("Finding created account element {}", nameOfCreatedAccount);
        return driver.findElement(By.xpath(String.format(
                "//span[@class='slds-grid slds-grid_align-spread slds-grid--align-spread forceInlineEditCell']" +
                        "//ancestor::a[contains(text(), '%s')]", nameOfCreatedAccount)));
    }
}
