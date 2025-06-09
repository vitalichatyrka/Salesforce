package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickCheckbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(
                "//span[text()='%s']/ancestor::lightning-input//input",
                label))));

    }

}
