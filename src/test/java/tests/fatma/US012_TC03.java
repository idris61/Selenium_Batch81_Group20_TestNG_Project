package tests.fatma;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US012_TC03 extends TestBaseRapor {
    @Test
    public void test03() throws InterruptedException {
        extentTest=extentReports.createTest("US012_TC03","Daha once girilen fatura adresi ve gönderim adresi listelenmeli");
        FatmaPage alloverPage = new FatmaPage();
        Actions actions=new Actions(Driver.getDriver());
        //1.Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi");
        //2."Singin" butonuna tıklanır
        alloverPage.signIn.click();
        extentTest.info("SignIn'e tıklandı");
        //3."Username or email adress" bölümüne vendor email girilir
        //4."Password" bölümüne verdor password girilir
        //5."Sing in" butonuna tıklanır
        actions.click(alloverPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        Thread.sleep(3000);
        extentTest.info("Username ve password bolumune giris yapıldı ve signIn'e tıklandı");
        //6. My Account’a tıklanır.
        alloverPage.jse.executeScript("arguments[0].click();", alloverPage.myAccount);
        extentTest.info("MyAccount'a tıklandı");
        Thread.sleep(3000);
        //7.Address'lere tıklanır.
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.addressesButton);
        extentTest.info("Addresses'a tıklandı");
        //8.Fatura adresi görünürlüğü test edilir.
        Assert.assertTrue(alloverPage.billingAddressText.isDisplayed());
        extentTest.pass("Fatura adresi görünürlüğü test edildi");
        //9.Gönderim adresi görünürlüğü test edilir.
        Assert.assertTrue(alloverPage.shippingAddressText.isDisplayed());
        extentTest.pass("Gönderim adresi görünürlüğü test edildi");
        //10- sayfayi kapatir
        //Driver.closeDriver();
    }
}