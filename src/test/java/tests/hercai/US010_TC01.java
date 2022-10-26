package tests.hercai;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class US010_TC01 extends TestBaseRapor {

    HercaiPage hercaiPage = new HercaiPage();

    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("US010_TC01", "Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli");

        //Belirtilen URL` ye gidilir "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        //Sing in butonuna tıklanır
        hercaiPage.singin.click();
        extentTest.info("Sing in butonuna tiklandi");

        //Username or email adress bölümüne vendor email girilir "grup20.testng@gmail.com"
        hercaiPage.email.sendKeys("grup20.testng@gmail.com");
        extentTest.info("Username or email adress bölümüne vendor email girildi");

        //Password girilir "Vendor20.,"
        //Sing In butonuna tıklanır
        actions.sendKeys(Keys.TAB).sendKeys(hercaiPage.password, "Vendor20.,")
                .sendKeys(Keys.TAB).click(hercaiPage.singinIkınci).perform();
        extentTest.info("Password bölümüne verdor password girildi");
        extentTest.info("Sing in butonuna tiklandi");

        //Sayfanın altından My Account butonuna tıklanır
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(hercaiPage.myAccount));
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
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        hercaiPage.attributies.click();
        extentTest.info("Attributes kutusuna tiklandi");

        //Color yazısının yanındaki kutucuğa tıklanır
        hercaiPage.colorBox.click();
        extentTest.info("Color yazisinin yanindaki kutucuga tiklandi");

        //Select All kutusuna basılır
        hercaiPage.selectAll.click();
        extentTest.info("Select All kutusuna basildi");

        //Tum renklerin seçildiği doğrulanır
        //   wait.until(ExpectedConditions.visibilityOf(hercaiPage.allColorSelected));
        //  Assert.assertTrue(hercaiPage.allColorSelected.isDisplayed());
        List<WebElement> acutualColorResult = hercaiPage.allColorSelected;
        Assert.assertTrue(acutualColorResult.size() > 0);
        extentTest.pass("Tum renklerin secildigi dogrulandi");

        //SUBMIT butonuna tıklanır
        Thread.sleep(1000);
        hercaiPage.submitButton.click();

    }


}