package tests.beyza;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class US011_TC02 extends TestBaseRapor {
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
        beyzaPage.username.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Gecerli username girildi");

      // Gecerli bir password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"));

        extentTest.info("Gecerli password dirildi");

      // Singin butonuna basilir.
        actions.sendKeys(Keys.ENTER).perform();

        extentTest.info("gecerli password girildi");

      // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);

        extentTest.info("My Accaunt a tıklandı");

        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();
        extentTest.info("Stor Manager butonuna tıklandi");


        // Products butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.products);
        jse.executeScript("arguments[0].click();", beyzaPage.products);
        extentTest.info("Products butonuna tıklandi");


        // Add New butonuna tıklanır
        beyzaPage.addNew.click();
        extentTest.info("Add New butonuna tıklandi");


        // Toptan urun gosterme ayarlari' butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.toptanUrunlerGostermeAyarlari);
        jse.executeScript("arguments[0].click();", beyzaPage.toptanUrunlerGostermeAyarlari);
        extentTest.info("Toptan urun gosterme ayarlari' butonuna tiklandi");


        // Units Per Piece bolumune veri girisi yapilir
       beyzaPage.unitPerPiece.click();
       actions.sendKeys("234").perform();
        extentTest.pass("Units Per Piece bolumune veri girisi yapildi");


    }
}
