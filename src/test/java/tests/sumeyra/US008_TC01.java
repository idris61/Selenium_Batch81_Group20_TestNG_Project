package tests.sumeyra;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import java.io.IOException;
public class US008_TC01 extends TestBaseRapor {
    SumeyraPage sumeyraPage = new SumeyraPage();
    @Test
    public void test01() throws IOException {
        extentTest = extentReports.createTest("US008_TC01", "Urun miktarı stock belirlenmeli");
        Actions actions = new Actions(Driver.getDriver());
        //1.Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi.");
        //2."Singin" butonuna tıklanır
        sumeyraPage.signIn.click();
        extentTest.info("Sign in'e tıklandı.");
        //3."Username or email adress" bölümüne vendor email girilir
        //4."Password" bölümüne verdor password girilir
        //5."Sing in" butonuna tıklanır
        actions.click(sumeyraPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        ReusableMethods.waitFor(3);
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        // 6. My Account'a tıklanır.
        ReusableMethods.waitFor(3);
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        // 7.Store manager'a tıklanır ve sonrasında Product'a tıklanır
        sumeyraPage.storeManagerButton.click();
        extentTest.info("Store Manager'a tıklandı.");
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.products);
        extentTest.info("Product'a tıklandı.");
        // 8.Add new butonuna tıklanır
        sumeyraPage.addNewButton.click();

        extentTest.info("Add new butonuna tıklandı.");
        //Stok kodu ve stok adedinin girilebildiği test edilir.
        for (WebElement each : sumeyraPage.sMs
        ) {
            Assert.assertTrue(each.isEnabled());
        }
        ReusableMethods.waitFor(3);
        sumeyraPage.jse.executeScript("arguments[0].scrollIntoView();", sumeyraPage.draft);
        sumeyraPage.sku.sendKeys("1245");
        sumeyraPage.actions.sendKeys(Keys.TAB, Keys.SPACE, Keys.TAB)
                .sendKeys("100").perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("urun ekleme ekrani");
        extentTest.info("Stok kodu ve stok adedinin girilebildiği test edildi.");
        //10- Sayfa kapatılır.
        //Driver.closeDriver();
    }
}