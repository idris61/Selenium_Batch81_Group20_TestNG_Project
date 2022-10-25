package tests.sumeyye;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyyePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005_TC02 extends TestBaseRapor {
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
        //Add new butonuna tıklanır
        sumeyyePage.addNewButton.click();
        extentTest.info("Add new butonununa tıklandı.");
        //Virtual veya downloadable işaretlenebilirmi test edilir?
        sumeyyePage.virtualCheckBox.click();
        extentTest.info("virtual checkbox'a tıklandı.");
        Assert.assertTrue(sumeyyePage.virtualCheckBox.isSelected());
        extentTest.pass("virtual checkbox'ın seçilebilir olduğu test edildi.");
        ReusableMethods.waitFor(3);
        sumeyyePage.downloadableCheckBox.click();
        extentTest.info("downloadable CheckBox'a tıklandı.");
        Assert.assertTrue(sumeyyePage.downloadableCheckBox.isSelected());
        extentTest.pass("downloadable checkbox'ın seçilebilir olduğu test edildi.");
        //Sayfa kapatılır.

    }
}