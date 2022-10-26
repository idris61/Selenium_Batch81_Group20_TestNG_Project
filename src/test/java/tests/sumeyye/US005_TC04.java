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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US005_TC04 extends TestBaseRapor {
    SumeyyePage sumeyyePage = new SumeyyePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test() throws AWTException {
        extentTest = extentReports.createTest("Add new Product", "Products menüsünde ürün listesi görünürlüğü testi");
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
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.storeManagerButton);
        extentTest.info("Store Manager'a tıklandı.");
        //Product’a tıklanır
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.products);
        extentTest.info("Products'a tıklandı.");
        //Add new butonuna tıklanır
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.addNewButton);
        extentTest.info("Add new butonununa tıklandı.");
        //Fotoğraf bölümüne tıklanır
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.addPhoto);
        extentTest.info("Add photo butonununa tıklandı.");
        //Select files’a tıklanır.
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.selectFiles);
        extentTest.info("Select files butonununa tıklandı.");
        //Dosya seçilir
        ReusableMethods.waitFor(3);
        Robot robot=new Robot();
        StringSelection str=new StringSelection("C:\\Users\\90552\\Desktop\\Mont1.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        extentTest.info("Dosya seçildi.");
        ReusableMethods.waitFor(3);
        //Select butonuna tıklanır.
        sumeyyePage.jse.executeScript("arguments[0].click();",sumeyyePage.addPhotoSelect);
        extentTest.info("Select butonununa tıklandı.");
        //Dosya görünürlüğü test edilir.
        Assert.assertTrue(sumeyyePage.bigPhotoIsDisplay.isDisplayed());
        extentTest.pass("Fotoğraf görünürlüğü test edildi.");
        //Driver kapatılır.
        Driver.closeDriver();

    }
}