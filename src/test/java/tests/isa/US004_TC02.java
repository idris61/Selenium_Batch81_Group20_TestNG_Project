package tests.isa;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IsaPage;
import pages.NaifPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US004_TC02 extends TestBaseRapor {
    IsaPage isaPage = new IsaPage();
    NaifPage naifPage = new NaifPage();
    @Test
    public void testTc_01() throws InterruptedException {
        //Belirtilen urlye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //sign in butonu tıklanır
        isaPage.signIn.click();
        //Vendor olarak email adresi girilir
        isaPage.username.sendKeys("grup20.testng@gmail.com");
        Actions actions = new Actions(Driver.getDriver());
        //Vendor şifresi doğru olarak girilir ve entera basılır
        actions.sendKeys(Keys.TAB).sendKeys("Vendor20.,"+Keys.ENTER).perform();
        //signout butonu tıklanır
        isaPage.signOut.click();
        //orders tıklanır
        isaPage.orders.click();
        //go shop tıklanır
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].click()",isaPage.goShop);
        //Shop yazısının görünür olduğu test edilir
        String isteneYazi=isaPage.shop.getText();
        System.out.println(isteneYazi);
        Assert.assertTrue(isteneYazi.contains("Shop"));
        //sepete rastgele ürünler eklenir
        Driver.getDriver().findElement(By.xpath("//a[@class='w-icon-list btn-showtype']")).click();
        jse.executeScript("arguments[0].click()",isaPage.ilkUrun);
        jse.executeScript("arguments[0].click()",isaPage.ikinciUrun);
        jse.executeScript("arguments[0].click();", naifPage.basket);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.triko);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.canta);


        //sepete tıklanır
        jse.executeScript("arguments[0].click()",isaPage.sepet);
        //sepeti görüntüle tıklanır
        jse.executeScript("arguments[0].click()",isaPage.wievCart);
        //ürünlerin eklendiği test edilir
        Thread.sleep(2000);
       // WebElement urunAdedi=Driver.getDriver().findElement(By.xpath("(//span[@class='cart-count'])[1]"));
        String urunSayisi=isaPage.urunAdedi.getText();
        System.out.println(urunSayisi);
        Assert.assertTrue(!urunSayisi.equals("0"));
        // + butonuyla ürün arttırılır
        Thread.sleep(3000);

        isaPage.plusButton.click();


        //eksi butonuyla ürün azaltılır
        Thread.sleep(2000);
        isaPage.minusButton.click();


        //ürüne tıklanır
        jse.executeScript("arguments[0].click()",isaPage.sepettekiUrun);

        //stok adedinin görünürlüğü test edilir
        Assert.assertTrue(isaPage.stokAdedi.isDisplayed());

        //stok fazlasının sepete eklenemediği test edilir
        String stokyazisi=isaPage.stokAdedi.getText();
       String sayi= stokyazisi.replaceAll("\\D","");
        System.out.println("sayi "+sayi+" "+"stokyazisi "+stokyazisi);
       int deger=Integer.parseInt(sayi);
       int degerBuyuk=deger+1;
       String buyukSayi=Integer.toString(degerBuyuk);
        System.out.println(stokyazisi+" "+sayi+" deger "+deger);

        jse.executeScript("arguments[0].click();", isaPage.siparisMiktari);
       // isaPage.siparisMiktari.sendKeys(buyukSayi);


        //Sepete geri dönülür
        Driver.getDriver().navigate().back();

        //cupon seçeneğinin erisilebilir oldugu dogrulandı
        Assert.assertTrue(isaPage.couponButton.isEnabled());

        //alışverişe devam butonunun aktif olduğu doğrulandı
        Assert.assertTrue(isaPage.continueToShopButtonu.isEnabled());

        //ödeme yap butonu tıklandı
        jse.executeScript("arguments[0].click()",isaPage.odemeyeGit);

        //fatura detayı görüntülendi
        Assert.assertTrue(isaPage.faturaDetay.isDisplayed());

        //sepeti TemizleButonuna tıklanır
        jse.executeScript("arguments[0].click()",isaPage.sepetiTemizleButonu);

        //sepetin temizlendiğ yazısı kontrol edilir
        Assert.assertTrue(isaPage.sepetBosYazisi.isDisplayed());


    }}
