package tests.cengizhan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CengizhanPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US013_TC05 {

    CengizhanPage page = new CengizhanPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());
    ExpectedConditions ExceptedCondition;


    @Test
    public void Test_US013_TC05() throws Exception {
        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //"sign in" tiklanir
        page.signInWE.click();

        //Gecerli veriler ile "sign in" yapilir
        page.userNameWE.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        page.passwordWE.sendKeys(ConfigReader.getProperty("alloverValidPassword"));
        page.signInButtonWE.click();
        wait.until(ExceptedCondition.visibilityOf(page.myAccountWE));

        //"My Account" linki tiklanir (sayfanin altinda)
        jse.executeScript("arguments[0].click();", page.myAccountWE);

        // aynı işlemi actions class'ı kullanarak yapmak istersek.
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // page.myAccountWE.click();

        wait.until(ExceptedCondition.visibilityOf(page.storeManagerWE));

        //"My Account" sayfasinda "Store Manager" linki tiklanir
        page.storeManagerWE.click();
        wait.until(ExceptedCondition.visibilityOf(page.couponsWE));

        //"Store Manager" sayfasinda "Coupons" linki tiklanir
        page.couponsWE.click();
        wait.until(ExceptedCondition.visibilityOf(page.addNewWE));

        //"Coupons" sayfasinda "Add New" butonu tiklanir
        page.addNewWE.click();
        wait.until(ExceptedCondition.visibilityOf(page.couponExpiryDateWE));

        //"Add Coupon" sayfasında "Coupon expiry date" kutucugunun Enabled oldugu dogrulanır
        Assert.assertTrue(page.couponExpiryDateWE.isEnabled());
        Driver.closeDriver();
    }
}
