package tests;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        loginPage.openLoginPage();
        loginPage.fillInLoginCredentials(loginPage.getAdminName(), loginPage.getAdminPassword());
        loginPage.clickLogInButton();

        newAccountModal.open();
        newAccountModal.createAccount(
                "Vitali4",
                "+375291891200",
                "+375171234566",
                "www.qa-auto.com",
                "Cold",
                "Prospect",
                "12 Uborevicha street",
                "13 Kolesnikova street");
        newAccountModal.clickSaveButton();
    }
}
