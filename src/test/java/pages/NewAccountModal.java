package pages;

import dto.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.PickList;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal open() {
        driver.get(String.format("%s/lightning/o/Account/new", BASE_URL));
        return this;
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='SaveEdit']")));
        return this;
    }

    public NewAccountModal      createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new PickList(driver, "Rating").select(account.getRating());
        return this;
    }

    @Step
    public void clickSaveButton(){
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
