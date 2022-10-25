package tests.sumeyra;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SumeyraPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US008_TC01 {

        /*    SumeyraPage alloverPage=new SumeyraPage();
            @Test
            public void test01() throws InterruptedException, IOException {
                Actions actions=new Actions(Driver.getDriver());
//1.Belirtilen URL` ye gidilir
                Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//2."Singin" butonuna tıklanır.
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

                // 9.Stok kodu ve stok adedinin girilebildiği test edilir.
                for (WebElement each:alloverPage.sMs
                ) {
                    Assert.assertTrue(each.isEnabled());
                }

                ReusableMethods.waitFor(3);
                alloverPage.jse.executeScript("arguments[0].scrollIntoView();",alloverPage.draft);

                alloverPage.sku.sendKeys("1245");
                alloverPage.actions.sendKeys(Keys.TAB, Keys.SPACE, Keys.TAB)
                        .sendKeys("100").perform();

                ReusableMethods.waitFor(3);
                ReusableMethods.getScreenshot("urun ekleme ekrani");
                //10- Sayfa kapatılır.
                Driver.closeDriver();



            }*/
        }




