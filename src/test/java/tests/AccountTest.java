package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        Account account = AccountFactory.getAccount("Cold");
        loginStep.auth(loginPage.getAdminName(), loginPage.getAdminPassword());
        accountStep.createAccount(account);
    }

    @Test
    public void createdAccountIsDisplayedInAccountsList() {
        Account account = AccountFactory.getAccount("Cold");
        loginStep.auth(loginPage.getAdminName(), loginPage.getAdminPassword());
        accountStep.createAccount(account);
        accountListPage.open()
                .isPageOpened();
        Assert.assertTrue(accountListPage.findCreatedAccountLink(account.getName()).isDisplayed());
    }
}
