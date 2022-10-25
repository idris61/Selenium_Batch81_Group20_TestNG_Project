package tests.idris;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IdrisPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class US014_TC05 extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("US014_TC05", "Exclude categories / bazi kategorileri disinda tut");

        IdrisPage page = new IdrisPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        // "Sing in" butonuna tıklanır
        page.signIn.click();
        extentTest.info("Sing in butonuna tiklandi");

        // "Username or email adress" bölümüne vendor email girilir
        page.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        extentTest.info("Username or email adress bölümüne vendor email girildi");

        // "Password" bölümüne verdor password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword")).perform();
        extentTest.info("Password bölümüne verdor password girildi");

        // "Sing in" butonuna tıklanır
        page.signIn2.click();
        Driver.getDriver().navigate().refresh();
        extentTest.info("Sing in butonuna tiklandi");

        // Açılan sayfanın alt kısmında bulunan "My Account" butonuna tıklanır
        jse.executeScript("arguments[0].click();", page.myAccount);
        extentTest.info("My Account butonuna tiklandi");

        // "Store Manager" butonuna tıklanır
        page.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        // "Coupons" altında bulunan "Add New" butonuna tıklanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        jse.executeScript("arguments[0].click();", page.coupons);
        page.couponsAddNew.click();
        extentTest.info("Add New butonuna tiklandi");

        // "Exclude categories" seçeneği tıklanır
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Select select=new Select(page.ddExcludeCategories);
        Thread.sleep(2000);

        List<WebElement> ddmList = select.getOptions();
        for (int i = 0; i < ddmList.size(); i++) {
            select.selectByIndex(i);
            Thread.sleep(200);
        }
        extentTest.pass("Dropdown menüdeki tüm seçeneklere tek tek tiklandi");
        Thread.sleep(1000);

        ReusableMethods.getScreenshot("US014_TC05");

    }
}



