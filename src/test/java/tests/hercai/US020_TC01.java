package tests.hercai;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HercaiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US020_TC01 extends TestBaseRapor {

    HercaiPage hercaiPage = new HercaiPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("US020_TC01", "Kullanici bilgisi, yazmış olduğu comment");

        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        //"Sing in" butonuna tıklanır
        hercaiPage.singin.click();
        extentTest.info("Sing in butonuna tiklandi");

        //"Username or email adress" bölümüne vendor email girilir
        hercaiPage.email.sendKeys("grup20.testng@gmail.com");
        extentTest.info("Username or email adress bölümüne vendor email girildi");

        //"Password" bölümüne verdor password girilir
        //"Sing in" butonuna tıklanır
        actions.sendKeys(Keys.TAB).sendKeys(hercaiPage.password, "Vendor20.,")
                .sendKeys(Keys.TAB).click(hercaiPage.singinIkınci).perform();
        extentTest.info("Password bölümüne verdor password girildi");
        extentTest.info("Sing in butonuna tiklandi");


        //Açılan sayfanın alt kısmında bulunan "My Account" butonuna tıklanır
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.myAccount));
        jse.executeScript("arguments[0].scrollIntoView(true);", hercaiPage.myAccount);
        jse.executeScript("arguments[0].click();", hercaiPage.myAccount);
        extentTest.info("My Account butonuna tiklandi");

        //"Store Manager" butonuna tıklanır
        hercaiPage.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        //Reviews butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", hercaiPage.reviewsYazisi);
        jse.executeScript("arguments[0].click();", hercaiPage.reviewsYazisi);
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.reviewsYazisi));
        extentTest.info("Reviews butonuna tiklandi");

        //Products Reviews kutucuğuna tıklanır
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.productsReviews));
        hercaiPage.productsReviews.click();
        extentTest.info("Products Reviews kutucuguna tiklandi");

        //Kullanıcı email yazısının gözüktüğü doğrulanır
        Assert.assertTrue(hercaiPage.userEmail.isDisplayed());
        extentTest.pass("Kullanici email yazisinin gozuktugu dogrulandi");

        //Kullanıcının comment yazının göründüğü doğrulanır
        Assert.assertTrue(hercaiPage.userComment.isDisplayed());
        extentTest.pass("Kullanicinin comment yazisinin gorundugu dogrulandi");

    }

}
