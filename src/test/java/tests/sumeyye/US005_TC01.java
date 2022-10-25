package tests.sumeyye;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyyePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005_TC01 extends TestBaseRapor {
    SumeyyePage sumeyyePage = new SumeyyePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test() {
        extentTest = extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris yapabilmeli");
        //Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi.");
        //"Singin" butonuna tıklanır
        sumeyyePage.signIn.click();
        extentTest.info("Sign in'e tıklandı.");
        //"Username or email adress" bölümüne vendor email girilir
        //"Password" bölümüne verdor password girilir
        //"Sing in" butonuna tıklanır
        actions.click(sumeyyePage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        //My Account’a tıklanır.
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        //Store manager’a tıklanır
        sumeyyePage.storeManagerButton.click();
        extentTest.info("Store Manager'a tıklandı.");
        //Product’a tıklanır
        sumeyyePage.products.click();
        extentTest.info("Products'a tıklandı.");
        //Ürün listisenin göründüğü test edilir (status, stock, price, date)
        /*Assert.assertTrue(alloverPage.statusText.isDisplayed());
        Assert.assertTrue(alloverPage.dateText.isDisplayed());
        Assert.assertTrue(alloverPage.priceText.isDisplayed());
        Assert.assertTrue(alloverPage.stockText.isDisplayed());*/
        for (WebElement each : sumeyyePage.productHeaders
        ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("status, stock, price ve date görünürlüğü test edildi.");
        //10. Sayfa kapatılır.
        Driver.closeDriver();
    }
}