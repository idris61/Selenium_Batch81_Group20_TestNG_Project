package tests.mansoor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MansoorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US007_TC01 {
    MansoorPage mansoorPage = new MansoorPage();
    @Test
    public void test01() {
        //1.Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //2."Sing in" butonuna tıklanır
        mansoorPage.signIn.click();
        //3."Username or email adress" bölümüne vendor email girilir
        //4."Password" bölümüne verdor password girilir
        //5."Sing in" butonuna tıklanır.
        mansoorPage.actions.click(mansoorPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        //6. My Account’a tıklanır.
        ReusableMethods.waitFor(2);
        MansoorPage.jsClick(mansoorPage.myAccount);
        //7.Store manager’a tıklanır ve sonrasında Product’a tıklanır
        mansoorPage.storeManagerButton.click();
        mansoorPage.products.click();
        //8.Add new butonuna tıklanır
        mansoorPage.addNewButton.click();
        //9.Marka kotegoresinin seçilebildiği test edilir.
        for (WebElement each: mansoorPage.productBrandsElements
        ) {

            MansoorPage.jsClick(each);


        }
        //10.Sayfayı kapatalım
        ReusableMethods.waitFor(15); // sonucu gormek icin
        Driver.closeDriver();

    }
}
