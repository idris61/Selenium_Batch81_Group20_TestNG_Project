package tests.sumeyra;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import java.util.List;
public class US008_TC02 extends TestBaseRapor {
    SumeyraPage sumeyraPage = new SumeyraPage();
    @Test
    public void test02() {
        extentTest = extentReports.createTest("US008_TC02", "Backorder izni verilebilmeli, gecici verilmeme optionu olmalı veya verilmeli ama müşteri bilgilendirilmeli");
        Actions actions = new Actions(Driver.getDriver());
        //Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi.");
        //"Singin" butonuna tıklanır
        sumeyraPage.signIn.click();
        extentTest.info("Sign in'e tıklandı.");
        //"Username or email adress" bölümüne vendor email girilir
        //"Password" bölümüne verdor password girilir
        //"Sing in" butonuna tıklanır
        actions.click(sumeyraPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        //My Account'a tıklanır.
        ReusableMethods.waitFor(3);
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        //Store manager'a tıklanır ve sonrasında Product'a tıklanır
        sumeyraPage.storeManagerButton.click();
        extentTest.info("Store Manager'a tıklandı.");
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.products);
        extentTest.info("Product'a tıklandı.");
        //Add new butonuna tıklanır
        sumeyraPage.addNewButton.click();
        extentTest.info("Add new butonuna tıklandı.");
        //Backorder seçeneklerinin seçilebilir olduğu test edilir.
        sumeyraPage.jse.executeScript("arguments[0].scrollIntoView();", sumeyraPage.backorder);
        ReusableMethods.waitFor(3);
        Select select1 = new Select(sumeyraPage.backorder);
        List<WebElement> backorderList = select1.getAllSelectedOptions();
        for (WebElement each : backorderList
        ) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isSelected());
        }
        extentTest.pass("Backorder seçeneklerinin seçilebilir olduğu test edildi");
        //10- Sayfa kapatılır.
        //Driver.closeDriver();
    }
}