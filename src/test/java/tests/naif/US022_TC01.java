package tests.naif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NaifPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US022_TC01 extends TestBaseRapor {
@Test
public void testTC01() throws InterruptedException {
    Actions actions = new Actions(Driver.getDriver());
    NaifPage naifPage=new NaifPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    extentTest=extentReports.createTest("Tumunu gor linki olmali ve tiklandigin o kategorinin ana tayfalarına götürmeli");

    //Belirt,len Url'gidilir
    Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
    extentTest.info("Belirtilen URL'ye gidldi");
    //"Sign" butonuna tıklanır
    naifPage.sign.click();
    extentTest.info("Sign butonuna tıklandı");
    //"Username or email adress" bölümüne vendor email girilir
    naifPage.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
    extentTest.info("Adress bolumuna vendor email girildi");
    //"Password" bölümüne verdor password girilir
    actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword")).sendKeys(Keys.ENTER).perform();
    extentTest.info("Passwor bolumune vendor password girildi");
    //"Sign" butonuna tıklanır
    naifPage.sign2.click();
    extentTest.info("Sign butonuna tıklandı");






















}
}



