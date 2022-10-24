package tests.beyza;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class US011_TC01 extends TestBaseRapor {
    BeyzaPage beyzaPage = new BeyzaPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void testTC001() {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");




        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("belirtilen URL'e gidildi");


        // Singin butonuna tıkalnır
        beyzaPage.signIn.click();
        extentTest.info("Singin buttonu na tıklandi");

        // Gecerli bir username girilir
        beyzaPage.username.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Gecerli username girildi");

        // Gecerli bir password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("gecerli password girildi");

        // Singin butonuna basilir.
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("singin buttonu na tıklandi");

        // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);

        extentTest.info("My Accaunt a tıklandı");


        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();
        extentTest.info("Stor Manger'a tiklandi");


        // Products butonuna tıklanır

        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.products);
        jse.executeScript("arguments[0].click();", beyzaPage.products);


        // Add New butonuna tıklanır
        beyzaPage.addNew.click();

        // Toptan urun gosterme ayarlari' butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.toptanUrunlerGostermeAyarlari);
        jse.executeScript("arguments[0].click();", beyzaPage.toptanUrunlerGostermeAyarlari);
        extentTest.info("Products butonuna tıklandi");


        // Piece Type' butonuna tiklar'
        // piece' si secer

        Select select = new Select(beyzaPage.pieceDdm);
        select.selectByIndex(1);
        extentTest.pass("piece 'i secti" );




    }

}
