package tests.sumeyra;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US008_TC02 {
    SumeyraPage alloverPage = new SumeyraPage();


    @Test
    public void test02() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());

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
        // 6. My Account’a tıklanır.
        ReusableMethods.waitFor(3);
        alloverPage.jse.executeScript("arguments[0].click();", alloverPage.myAccount);
        // 7.Store manager’a tıklanır ve sonrasında Product’a tıklanır
        alloverPage.storeManagerButton.click();
        alloverPage.jse.executeScript("arguments[0].click();", alloverPage.products);
        // 8.Add new butonuna tıklanır
        alloverPage.addNewButton.click();
        //9.Backorder seçeneklerinin seçilebilir olduğu test edilir.
        alloverPage.jse.executeScript("arguments[0].scrollIntoView();", alloverPage.backorder);
        ReusableMethods.waitFor(3);
        Select select1 = new Select(alloverPage.backorder);
        List<WebElement> backorderList = select1.getAllSelectedOptions();
        for (WebElement each : backorderList
        ) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isSelected());

        }
        //10- Sayfa kapatılır.
        Driver.closeDriver();


    }
}
