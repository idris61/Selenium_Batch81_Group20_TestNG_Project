package tests.mansoor;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MansoorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US017_TC03 extends TestBaseRapor {
    MansoorPage mansoorPage = new MansoorPage();
    @Test
    public void test01() throws IOException {
        extentTest=extentReports.createTest("US017_TC03", "Shipping address yeniden Billing address bilgilerini farklı olarak eklenebilmeli");
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
                               "ve sonra Sing in butonuna tıklanır");
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
        //10."Same as biliing" butonuna tıklanır.
        MansoorPage.jsClick(mansoorPage.customerSameasBillingButton);
        extentTest.info("Same as biliing butonuna tıklandı");
        //11.Tüm adres bilgilerinin farklı olarak eklenebilirliği test edilir.
        (mansoorPage.customerShippingList).forEach(t->t.sendKeys(Faker.instance().name().name()));
        MansoorPage.selectMethod(mansoorPage.customerShippingCountry).selectByIndex(128);
        extentTest.info("Tüm adres bilgilerinin farklı olarak eklenebilirliği test edildi");
        //12, Submit'e tıklanır.
        MansoorPage.jsClick(mansoorPage.customerSubmitButton);
        extentTest.info("Submit'e tıklandı");
        //13.Sayfayı kapatalım
        ReusableMethods.waitFor(10); // sonucu gormek icin
        ReusableMethods.getScreenshot("US017_TC03");
        Driver.quitDriver();
        extentTest.info("Sayfayı kapatı");



    }
}
