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

import java.nio.file.Files;
import java.nio.file.Path;

public class US016_TC02 extends TestBaseRapor {

    SumeyyePage sumeyyePage = new SumeyyePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test() {
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
        sumeyyePage.storeManagerButton.click();
        extentTest.info("Store Manager'a tıklandı.");
        //Customer’a tıklanır
        sumeyyePage.jse.executeScript("arguments[0].click();", sumeyyePage.customersButton);
        extentTest.info("Customer'a tıklandı.");
        //Pdf Excel ve Csv olarak indirilebilirliği test edilir.
        for (WebElement each: sumeyyePage.pdfExcelCSV
        ) {
            each.click();
        }
        ReusableMethods.waitFor(4);
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\90552\\Downloads\\Store Manager - Allover Commerce.pdf")));
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\90552\\Downloads\\Store Manager - Allover Commerce.csv")));
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\90552\\Downloads\\Store Manager - Allover Commerce.xlsx")));
        extentTest.pass("PDF Excel ve CSV dosyalarının indirildiği test edildi.");

    }
}
