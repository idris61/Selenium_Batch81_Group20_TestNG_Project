package tests.mansoor;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MansoorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US017_TC03 {
    MansoorPage mansoorPage = new MansoorPage();
    @Test
    public void test01() {
        //1.Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //2.Ana sayfaya gidildiği doğrulanır
        String expectedUrl= "https://allovercommerce.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //3."Sing in" butonuna tıklanır
        mansoorPage.signIn.click();
        //4."Username or email adress" bölümüne vendor email girilir
        //5."Password" bölümüne verdor password girilir
        //6."Sing in" butonuna tıklanır.
        mansoorPage.actions.click(mansoorPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        //7. My Account’a tıklanır.
        ReusableMethods.waitFor(2);
        MansoorPage.jsClick(mansoorPage.myAccount);
        //8.Store manager’a tıklanır ve sonrasında Customer’a tıklanır
        mansoorPage.storeManagerButton.click();
        MansoorPage.jsClick(mansoorPage.customersButton);
        //9. "Add new" butonuna tıklanır.
        mansoorPage.customersAddNew.click();
        //10."Same as biliing" butonuna tıklanır.
        MansoorPage.jsClick(mansoorPage.customerSameasBillingButton);
        //11.Tüm adres bilgilerinin farklı olarak eklenebilirliği test edilir.
        (mansoorPage.customerShippingList).forEach(t->t.sendKeys(Faker.instance().name().name()));
        MansoorPage.selectMethod(mansoorPage.customerShippingCountry).selectByIndex(128);
        //12, Submit'e tıklanır.
        MansoorPage.jsClick(mansoorPage.customerSubmitButton);
        //13.Sayfayı kapatalım
        ReusableMethods.waitFor(10); // sonucu gormek icin
        Driver.closeDriver();


    }
}
