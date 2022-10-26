package tests.etka;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EtkaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class US006_TC01 extends TestBaseRapor {
    EtkaPage etkaPage = new EtkaPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test() {
        extentTest = extentReports.createTest("Kategori belirleme", "Eklenecek ürünlerin kategorilerini belirleme testi");
        //Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi.");
        //"Singin" butonuna tıklanır
        etkaPage.signIn.click();
        extentTest.info("Sign in'e tıklandı.");
        //"Username or email adress" bölümüne vendor email girilir
        //"Password" bölümüne verdor password girilir
        //"Sing in" butonuna tıklanır
        actions.click(etkaPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        //"My Account" yazısının açılan sayfa sonunda görüldüğü doğrulanır
        ReusableMethods.waitFor(2);
        Assert.assertTrue(etkaPage.myAccount.isDisplayed());
        etkaPage.jse.executeScript("arguments[0].click();", etkaPage.myAccount);
        extentTest.info("My Account yazısının görünür olduğu test edildi.");
        //Store manager’a tıklanır ve
        etkaPage.storeManagerButton.click();
        extentTest.info("Store Manager tıklandı.");
        //Product’a tıklanır
        etkaPage.products.click();
        extentTest.info("Product'a tıklandı.");
        //Add new butonuna tıklanır
        etkaPage.jse.executeScript("arguments[0].click();", etkaPage.addNewButton);
        extentTest.info("Add new butonuna tıklandı.");
        //Kategorilerin seçilebildiği test edilir.
        for (WebElement each : etkaPage.categoriesList
        ) {
            etkaPage.jse.executeScript("arguments[0].click();", each);
        }
        extentTest.pass("Kategorilerin seçilebildiği test edildi.");

        //Dirver kapatılır.
        Driver.closeDriver();
    }
}