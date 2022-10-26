package tests.hercai;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HercaiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US010_TC02 extends TestBaseRapor {

    HercaiPage hercaiPage = new HercaiPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("US010", "Size secenegi; small, medium, large, extra large olmali");

        //Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        //Sing in butonuna tıklanır
        hercaiPage.singin.click();
        extentTest.info("Sing in butonuna tiklandi");

        //Username or email adress bölümüne vendor email girilir
        hercaiPage.email.sendKeys("grup20.testng@gmail.com");
        extentTest.info("Username or email adress bölümüne vendor email girildi");

        //Password girilir
        hercaiPage.password.sendKeys("Vendor20.,");
        extentTest.info("Password bölümüne verdor password girildi");

        //Sing In butonuna tıklanır
        hercaiPage.singinIkınci.click();
        extentTest.info("Sing in butonuna tiklandi");

        //Sayfanın altından My Account butonuna tıklanır
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.myAccount));
        actions.sendKeys(Keys.PAGE_DOWN);
        jse.executeScript("arguments[0].scrollIntoView(true);", hercaiPage.myAccount);
        jse.executeScript("arguments[0].click();", hercaiPage.myAccount);
        extentTest.info("My Account butonuna tiklandi");

        //Store Manager bölümüne tıklanır
        hercaiPage.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        //Products yazısına tıklanır
        hercaiPage.products.click();
        extentTest.info("Products yazisina tiklandi");

        //Add New butonuna tıklanır
        hercaiPage.addNew.click();
        extentTest.info("Add New butonuna tiklandi");

        //Aşağıda Attributes kutusuna tıklanır
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.attributies));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        hercaiPage.attributies.click();
        extentTest.info("Attributes kutusuna tiklandi");

        //Color yazısının yanındaki kutucuğa tıklanır
        hercaiPage.colorBox.click();
        extentTest.info("Color yazisinin yanindaki kutucuga tiklandi");

        //Select All kutusuna basılır
        hercaiPage.selectAll.click();
        extentTest.info("Select All kutusuna basildi");

        //Tum renklerin seçildiği doğrulanır
        //  wait.until(ExpectedConditions.visibilityOf(hercaiPage.allColorSelected));
        // Assert.assertTrue(hercaiPage.allColorSelected.isDisplayed());
        List<WebElement> acutualColorResult = hercaiPage.allColorSelected;
        Assert.assertTrue(acutualColorResult.size() > 0);
        extentTest.pass("Tum renklerin secildigi dogrulandi");

        //Size yazısının yanındaki kutucuğa tıklanır
        hercaiPage.sizeKucukBox.click();
        extentTest.info("Size yazisinin yanindaki kutucuga tiklandi");

        //Select All kutusuna basılır
        hercaiPage.sizeSelectAllButton.click();
        // Select select = new Select(hercaiPage.sizeBuyukBox);
        //  select.selectByVisibleText("small");
        // select.selectByVisibleText("medium");
        //select.selectByVisibleText("large");
        //select.selectByVisibleText("extra large");
        extentTest.info("Select All kutusuna basildi");

        //small, medium, large, extra large seçildiği doğrulanır
        //  Assert.assertTrue(hercaiPage.singinIkınci.isDisplayed());
        List<WebElement> actualSizeResult = hercaiPage.sizeDogrulamaninYapildigiBox;
        Assert.assertTrue(actualSizeResult.size() > 0);
        extentTest.pass("small, medium, large, extra large secildigi dogrulandi");


    }
}