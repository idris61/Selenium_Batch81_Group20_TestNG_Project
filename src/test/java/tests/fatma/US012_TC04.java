package tests.fatma;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US012_TC04 {
    @Test
    public void test04() throws InterruptedException {
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
        //7.Account Details’a tıklanır.
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.acoutdetails);
        //8.Hesap bilgisinin görünür oldugu test edilir.
        Assert.assertTrue(alloverPage.accountDetailsText.isDisplayed());
        //9.e posta adresinin görünür oldugu test edilir.
        Assert.assertTrue(alloverPage.emaildegistir.isDisplayed());
        //10.e posta adresinin Update edilebilirliği test edilir.
        alloverPage.emaildegistir.clear();
        alloverPage.emaildegistir.sendKeys(ConfigReader.getProperty("alloverTempEmail"));
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.savechanges);
        ReusableMethods.waitFor(5);
        String succesfully= alloverPage.succesfully.getText();
        System.out.println(succesfully);
        Assert.assertEquals(alloverPage.succesfully.getText(),succesfully);
        alloverPage.emaildegistir.clear();
        alloverPage.emaildegistir.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        alloverPage.jse.executeScript("arguments[0].click();",alloverPage.savechanges);
        //11.sayfayı kapatır.
        Driver.closeDriver();

    }
}
