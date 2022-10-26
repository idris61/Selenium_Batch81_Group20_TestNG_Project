package tests.mansoor;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MansoorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US017_TC02 extends TestBaseRapor {
    MansoorPage mansoorPage = new MansoorPage();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("US017_TC02", "Shipping address; Billing adresleri ayni olarak ekleyebilirler");
        //1.Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");
        //2.Ana sayfaya gidildiği doğrulanır
        String expectedUrl= "https://allovercommerce.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.info("Ana sayfaya gidildiği doğrulandı");
        //3."Sing in" butonuna tıklanır
        mansoorPage.signIn.click();
        extentTest.info("Sing in butonuna tiklandı");
        //4."Username or email adress" bölümüne vendor email girilir
        //5."Password" bölümüne vendor password girilir
        //6."Sing in" butonuna tıklanır.
        mansoorPage.actions.click(mansoorPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        extentTest.info("Username or email adress bölümüne vendor email," +
                               "ve Password bölümüne vendor password girildi," +
                               "ve sonra Sing in butonuna tıklandı");
        //7. My Account’a tıklanır.
        ReusableMethods.waitFor(2);
        MansoorPage.jsClick(mansoorPage.myAccount);
        extentTest.info("My Account’a tıklandı");
        //8.Store manager’a tıklanır ve sonrasında Customer’a tıklanır
        mansoorPage.storeManagerButton.click();
        MansoorPage.jsClick(mansoorPage.customersButton);
        extentTest.info("Store manager’a ve sonrasında Customer’a tıklandı");
        //9. "Add new" butonuna tıklanır.
        mansoorPage.customersAddNew.click();
        extentTest.info("Add new butonuna tıklandı");
        //10."Same as billing" butonunun seçilebilir olduğu test edilir.
        Assert.assertTrue(mansoorPage.customerSameasBillingButton.isSelected());
        extentTest.info("Same as billing butonunun seçilebilir olduğu test edildi");
        //11.Sayfayı kapatalım
        ReusableMethods.waitFor(10); // sonucu gormek icin
        Driver.quitDriver();
        extentTest.info("Sayfayı kapatı");
    }
}
