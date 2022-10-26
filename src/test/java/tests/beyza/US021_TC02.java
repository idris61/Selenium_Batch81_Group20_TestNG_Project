package tests.beyza;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US021_TC02 extends TestBaseRapor {
    BeyzaPage beyzaPage = new BeyzaPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testTC002() throws IOException, InterruptedException {
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
        extentTest.info("Singin butonuna basildi");


        // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);
        extentTest.info("My Accaunt butonuna tıklandi");


        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();
        extentTest.info("Stor Manager butonuna tıklandi");

        //Reports butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.reports);
        jse.executeScript("arguments[0].click();", beyzaPage.reports);
        extentTest.info("Reports butonuna tıklandi");





        // Bir tarih araligi secilebildigi dogrulanir
        jse.executeScript("arguments[0].click();", beyzaPage.chooseDateRange);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        beyzaPage.octoberButton.click();
        beyzaPage.decemberButton.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(beyzaPage.grafik.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        ReusableMethods.getScreenshot("US021_TC02");


        extentTest.pass("Bir tarih araligi secilebildigi dogrulandi");









    }
}