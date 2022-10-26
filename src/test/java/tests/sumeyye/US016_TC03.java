package tests.sumeyye;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.SumeyyePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US016_TC03 extends TestBaseRapor {


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
        //Yeni kişi eklenebilirliği test edilir.(kullanıcı adı, email, isim,soyisim)
        sumeyyePage.customerUserName.sendKeys(Faker.instance().name().username());
        sumeyyePage.customerUserEmail.sendKeys(Faker.instance().internet().emailAddress());
        ReusableMethods.waitFor(3);
        sumeyyePage.customerFirstName.sendKeys(Faker.instance().name().firstName());
        ReusableMethods.waitFor(3);
        sumeyyePage.customerLastName.sendKeys(Faker.instance().name().lastName());
        extentTest.pass("Yeni kişi eklenebildiği test edildi.");
    }
}