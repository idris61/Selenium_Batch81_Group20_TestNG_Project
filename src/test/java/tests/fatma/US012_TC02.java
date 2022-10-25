package tests.fatma;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US012_TC02 extends TestBaseRapor {
    @Test
    public void test02() throws InterruptedException {
        extentTest=extentReports.createTest("US012_TC02","indirilen ürünler listelenmeli");
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
        //7.Downloads a tıklanır
        alloverPage.downloadsButton.click();
        extentTest.info("Downloads'a tıklandı");
        //8-Kullanici "Henüz indirilecek bir ürün yok."yazısının göründüğünü test eder
        Assert.assertTrue(alloverPage.noDownload.isDisplayed());
        extentTest.pass("\"Henüz indirilecek bir ürün yok.\"yazısının göründüğünü test edildi");
        //9- sayfayi kapatir
        //Driver.closeDriver();
    }
}