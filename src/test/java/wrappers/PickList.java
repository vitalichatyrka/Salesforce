package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class PickList {
    WebDriver driver;
    String label;

    public PickList(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info("Selecting {} inside picklist {}", option, label);
        driver.findElement(By.xpath(
                String.format("//label[text()='%s']/ancestor::lightning-picklist//button", label))).click();
        driver.findElement(By.xpath(String.format(
                "//label[text()='%s']/ancestor::lightning-picklist//lightning-base-combobox-item//span[text()='%s']",
                label, option))).click();
    }
}
