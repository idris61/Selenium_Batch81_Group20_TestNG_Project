package tests.isa;

import org.testng.annotations.Test;
import pages.IsaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001_TC01 {

   IsaPage isaPage = new IsaPage();

    @Test
    public void testTc_01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        isaPage.signIn.click();
        isaPage.username.sendKeys(ConfigReader.getProperty("vendorEmail"));
        isaPage.password.sendKeys(ConfigReader.getProperty("vendorPassword"));
    }
}

