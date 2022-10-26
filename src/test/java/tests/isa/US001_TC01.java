package tests.isa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IsaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US001_TC01 {

   IsaPage isaPage = new IsaPage();

    @Test
    public void testTc_01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        isaPage.signIn.click();
       isaPage.username.sendKeys("grup20.testng@gmail.com");
        Actions actions = new Actions(Driver.getDriver());
       // isaPage.password.sendKeys(ConfigReader.getProperty("vendorPassword"));
        actions.sendKeys(Keys.TAB).sendKeys("Vendor20.,"+Keys.ENTER).perform();
        WebElement signout=Driver.getDriver().findElement(By.xpath("//a[@class='login logout inline-type']"));
        signout.click();
        WebElement orders=Driver.getDriver().findElement(By.xpath("//a[text()='Orders']"));
        orders.click();

       WebElement goShop= Driver.getDriver().findElement(By.xpath("(//a[@href='https://allovercommerce.com/shop/'])[1]"));
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].click()",goShop);
        WebElement shop=Driver.getDriver().findElement(By.xpath("//div[@class='breadcrumb-container container']"));
        String isteneYazi=shop.getText();
        System.out.println(isteneYazi);
        Assert.assertTrue(isteneYazi.contains("Shop"));
       /* WebElement ilkUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14635']"));
        ilkUrun.click();

        WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14782']"));
        ikinciUrun.click();
        WebElement sepet=Driver.getDriver().findElement(By.xpath("//a[@class='cart-toggle']"));
        sepet.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        WebElement sepetDevam=Driver.getDriver().findElement(By.xpath("https://allovercommerce.com/cart/"));
        sepetDevam.click();

        */
        Driver.getDriver().findElement(By.xpath("//a[@class='w-icon-list btn-showtype']")).click();
        WebElement ilkUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14635']"));
        jse.executeScript("arguments[0].click()",ilkUrun);

        //ilkUrun.click();
        WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14782']"));
        jse.executeScript("arguments[0].click()",ikinciUrun);


    }
}

