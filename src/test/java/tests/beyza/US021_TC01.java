package tests.beyza;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US021_TC01 extends TestBaseRapor {

    BeyzaPage beyzaPage = new BeyzaPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testTC002() {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");


        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("belirtilen URL'e gidildi");

        // Singin butonuna tıkalnır
        beyzaPage.signIn.click();
        extentTest.info("Singin buttonu na tıklandi");

        // Gecerli bir username girilir
        beyzaPage.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        extentTest.info("Gecerli username girildi");

        // Gecerli bir password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword"));
        extentTest.info("gecerli password girildi");

        // Singin butonuna basilir.
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("gecerli password girildi");


        // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);
        extentTest.info("gecerli password girildi");


        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();
        extentTest.info("gecerli password girildi");

        // Reports butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.reports);
        jse.executeScript("arguments[0].click();", beyzaPage.reports);
        extentTest.info("gecerli password girildi");



        //  Year gorunurlugu dogrulanir
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.year);
        jse.executeScript("arguments[0].click();", beyzaPage.year);
        Assert.assertTrue(beyzaPage.year.isEnabled());
        extentTest.info("Year gorunurlugu dogrulandi");




        //  Last Month gorunurlugu dogrulanir
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.lastMonth);
        jse.executeScript("arguments[0].click();", beyzaPage.lastMonth);
        Assert.assertTrue(beyzaPage.lastMonth.isEnabled());
        extentTest.info("Last Month gorunurlugu dogrulandi");


        //  This Month gorunurlugu dogrulanir
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.thisMonth);
        jse.executeScript("arguments[0].click();", beyzaPage.thisMonth);
        Assert.assertTrue(beyzaPage.thisMonth.isEnabled());
        extentTest.info(" This Month gorunurlugu dogrulandi");


        //   Last 7 Days gorunurlugu dogrulanir
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.last7Days);
        jse.executeScript("arguments[0].click();", beyzaPage.last7Days);
        Assert.assertTrue(beyzaPage.last7Days.isEnabled());
        extentTest.pass("Last 7 Days gorunurlugu dogrulandi");


    }
}