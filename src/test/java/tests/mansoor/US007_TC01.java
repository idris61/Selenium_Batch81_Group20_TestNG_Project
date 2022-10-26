package tests.mansoor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MansoorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US007_TC01 extends TestBaseRapor {
    MansoorPage mansoorPage = new MansoorPage();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("US007_TC01", "Secilen ürünlerin brandini belirlemeli");
        //1.Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");
        //2."Sing in" butonuna tıklanır
        mansoorPage.signIn.click();
        extentTest.info("Sing in butonuna tiklandı");
        //3."Username or email adress" bölümüne vendor email girilir
        //4."Password" bölümüne vendor password girilir
        //5."Sing in" butonuna tıklanır.
        mansoorPage.actions.click(mansoorPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        extentTest.info("Username or email adress bölümüne vendor email, " +
                               "ve Password bölümüne vendor password girildi " +
                               "ve sonra Sing in butonuna tıklandı");
        //6. My Account’a tıklanır.
        ReusableMethods.waitFor(2);
        MansoorPage.jsClick(mansoorPage.myAccount);
        extentTest.info("My Account’a tıklandı");
        //7.Store manager’a tıklanır ve sonrasında Product’a tıklanır
        mansoorPage.storeManagerButton.click();
        mansoorPage.products.click();
        extentTest.info("Store manager’a ve sonrasında Product’a tıklandı");
        //8.Add new butonuna tıklanır
        mansoorPage.addNewButton.click();
        extentTest.info("Add new butonuna tıklandı");
        //9.Marka kotegoresinin seçilebildiği test edilir.
        for (WebElement each: mansoorPage.productBrandsElements
        ) {

            MansoorPage.jsClick(each);


        }
        extentTest.info("Marka kotegoresinin seçilebildiği test edildi");
        //10.Sayfayı kapatalım
        ReusableMethods.waitFor(15); // sonucu gormek icin
        Driver.quitDriver();
        extentTest.info("Sayfayı kapatı");

    }
}
