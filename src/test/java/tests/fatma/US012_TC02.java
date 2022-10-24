package tests.fatma;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US012_TC02 {
    @Test
    public void test02() throws InterruptedException {
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
        alloverPage.jse.executeScript("arguments[0].click();", alloverPage.myAccount);

        //7.Downloads a tıklanır
        alloverPage.downloadsButton.click();

        //8-Kullanici "Henüz indirilecek bir ürün yok."yazısının göründüğünü test eder
        Assert.assertTrue(alloverPage.noDownload.isDisplayed());

        //9- sayfayi kapatir
        Driver.closeDriver();
    }
}
