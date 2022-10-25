package tests.naif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NaifPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US003_TC01 {
@Test
public void testTC01() throws InterruptedException {
    Actions actions = new Actions(Driver.getDriver());
    NaifPage naifPage=new NaifPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    //Belirt,len Url'gidilir
    Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
    //"Sign" butonuna tıklanır
    naifPage.sign.click();
    //"Username or email adress" bölümüne vendor email girilir
    naifPage.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
    //"Password" bölümüne verdor password girilir
    actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword")).sendKeys(Keys.ENTER).perform();
    //"Sign" butonuna tıklanır
    naifPage.sign2.click();
    //"My orders" butonuna tıklanır
    jse.executeScript("arguments[0].click();", naifPage.myOrders);
    //"Go Shop" butonuna tıklanır
    jse.executeScript("arguments[0].click();", naifPage.goshop);















}
}



//