package tests.fatma;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US019_TC01 {
    @Test
    public void test01() throws InterruptedException {

        FatmaPage alloverPage = new FatmaPage();
        Actions actions=new Actions(Driver.getDriver());
        //1.Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //2."Singin" butonuna tıklanır
        alloverPage.signIn.click();
        //3."Username or email adress" bölümüne vendor email girilir
        //4."Password" bölümüne verdor password girilir
        //5."Sing in" butonuna tıklanır
        actions.click(alloverPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        Thread.sleep(3000);
        //6. My Account’a tıklanır.
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.myAccount);
        //7.Store manager’a tıklanır ve sonrasında Followers'a tıklanır
        alloverPage.storeManagerButton.click();
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.follewers);
        ReusableMethods.waitFor(3);
        //8.İsim ve e posta görünürlüğü test edilir.
        Assert.assertTrue(alloverPage.follewersName.isDisplayed());
        Assert.assertTrue(alloverPage.follewersEmail.isDisplayed());
        //9.sayfayı kapatın
        Driver.closeDriver();
    }
}
