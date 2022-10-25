package tests.beyza;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BeyzaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US011_TC03 extends TestBaseRapor {

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

        // My Accaunt butonuna tıklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.myAccountSignOutLink);
        jse.executeScript("arguments[0].click();", beyzaPage.myAccountSignOutLink);

        // Stor Manager butonuna tıklanir
        beyzaPage.storManager.click();

        // Products butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.products);
        jse.executeScript("arguments[0].click();", beyzaPage.products);

        // Add New butonuna tıklanır
        beyzaPage.addNew.click();

        // Toptan urun gosterme ayarlari' butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", beyzaPage.toptanUrunlerGostermeAyarlari);
        jse.executeScript("arguments[0].click();", beyzaPage.toptanUrunlerGostermeAyarlari);

        // Min Order Quantity bolumune veri girisi yapilir
        beyzaPage.minOrderQuantity.click();
        actions.sendKeys("12").perform();

    }
}