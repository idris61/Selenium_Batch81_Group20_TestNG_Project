package tests.idris;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IdrisPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US009_TC01 {
   
    @Test
    public void testTC_001() {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        IdrisPage idrisPage = new IdrisPage();
        idrisPage.signIn.click();
        idrisPage.username.sendKeys(ConfigReader.getProperty("userName"));

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(idrisPage.signOut.isDisplayed());

    }

}