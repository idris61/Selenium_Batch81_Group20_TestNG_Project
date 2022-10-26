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
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US013_TC03 extends TestBaseRapor {
    CengizhanPage page = new CengizhanPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());
    ExpectedConditions ExceptedCondition;
    @Test
    public void Test_US013_TC03() throws Exception {
        extentTest=extentReports.createTest("US013_TC03", "Store manager olarak kupon olusturabilme - Indirim sekli / Discount Type olmalı");

        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        //"sign in" tiklanir
        page.signInWE.click();
        extentTest.info("sign in tiklandı");

        //Gecerli veriler ile "sign in" yapilir
        page.userNameWE.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        page.passwordWE.sendKeys(ConfigReader.getProperty("alloverValidPassword"));
        page.signInButtonWE.click();
        extentTest.info("Gecerli veriler ile 'sign in' yapildı");
        wait.until(ExceptedCondition.visibilityOf(page.myAccountWE));

        //"My Account" linki tiklanir (sayfanin altinda)
        jse.executeScript("arguments[0].click();", page.myAccountWE);
        extentTest.info("'My Account' linki tiklandı");

        // aynı işlemi actions class'ı kullanarak yapmak istersek.
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // page.myAccountWE.click();
        wait.until(ExceptedCondition.visibilityOf(page.storeManagerWE));

        //"My Account" sayfasinda "Store Manager" linki tiklanir
        page.storeManagerWE.click();
        extentTest.info("My Account sayfasinda 'Store Manager' linki tıklandı" );
        wait.until(ExceptedCondition.visibilityOf(page.couponsWE));

        //"Store Manager" sayfasinda "Coupons" linki tiklanir
        page.couponsWE.click();
        extentTest.info("Store Manager sayfasinda 'Coupons' linki tiklandı");
        wait.until(ExceptedCondition.visibilityOf(page.addNewWE));

        //"Coupons" sayfasinda "Add New" butonu tiklanir
        page.addNewWE.click();
        extentTest.info("Coupons sayfasinda 'Add New' butonu tiklandı");
        wait.until(ExceptedCondition.visibilityOf(page.discountTypeWE));

        //"Add Coupon" sayfasında "Discount Type" kutucugunun Enabled oldugu dogrulanır
        Assert.assertTrue(page.discountTypeWE.isEnabled());
        extentTest.info("Add Coupon sayfasında 'Discount Type' kutucugunun Enabled oldugu dogrulandı");
        ReusableMethods.getScreenshot("US013_TC03");
        Driver.closeDriver();
    }
}
