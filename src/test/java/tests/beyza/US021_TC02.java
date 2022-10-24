package tests.beyza;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class US021_TC02 extends TestBaseRapor {
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
        beyzaPage.username.click();
        extentTest.info("Gecerli username girildi");

        // Gecerli bir password girilir
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password dirildi");

        // Singin butonuna basilir.
        actions.sendKeys(Keys.ENTER).perform();

        // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);

        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();

        //Reports butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.products);
        jse.executeScript("arguments[0].click();", beyzaPage.products);

        // Add New butonuna tıklanır
        beyzaPage.addNew.click();

        // Bir tarih araligi secilebildigi dogrulanir


    }
}