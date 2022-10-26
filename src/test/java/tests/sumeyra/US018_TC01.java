package tests.sumeyra;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class US018_TC01 extends TestBaseRapor {
    SumeyraPage sumeyraPage = new SumeyraPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test() {
        extentTest = extentReports.createTest("US018", "RequestID; geri isteme isteği");
        //Belirtilen Url ye gidilir.
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
        ReusableMethods.waitFor(2);
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        //My Account’a tıklanır.
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        //Store manager’a tıklanır
        sumeyraPage.storeManagerButton.click();
        extentTest.info("Store Manager'a tıklandı.");
        //Refund'a tıklanır.
        sumeyraPage.jse.executeScript("arguments[0].click();", sumeyraPage.refundButton);
        extentTest.info("Refund'a tıklandı.");
        // RequestID görünürlüğü test edilir.
        Assert.assertTrue(sumeyraPage.refundRequestId.isDisplayed());
        extentTest.pass("RequestID görünürlüğü test edildi.");
    }
}