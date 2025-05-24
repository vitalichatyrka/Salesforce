package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@name='SaveEdit']")));
    }
    public void createAccount(String name, String phoneNumber, String fax, String website, String rating, String type,
                              String billingStreet, String shippingStreet){
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phoneNumber);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new PickList(driver, "Rating").select(rating);
        new PickList(driver, "Type").select(type);
        new Checkbox(driver, "VIP Client").clickCheckbox();
        new Checkbox(driver, "TeachMeSkills").clickCheckbox();
        new TextArea(driver,"Billing Street").write(billingStreet);
        new TextArea(driver,"Shipping Street").write(shippingStreet);
    }
    public void clickSaveButton(){
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
