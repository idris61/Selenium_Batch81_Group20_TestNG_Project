package tests.isa;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IsaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US004_TC02 {
    IsaPage isaPage = new IsaPage();
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
        WebElement signout=Driver.getDriver().findElement(By.xpath("//a[@class='login logout inline-type']"));
        signout.click();
        //orders tıklanır
        WebElement orders=Driver.getDriver().findElement(By.xpath("//a[text()='Orders']"));
        orders.click();
        //go shop tıklanır
        WebElement goShop= Driver.getDriver().findElement(By.xpath("(//a[@href='https://allovercommerce.com/shop/'])[1]"));
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].click()",goShop);
        //Shop yazısının görünür olduğu test edilir
        WebElement shop=Driver.getDriver().findElement(By.xpath("//div[@class='breadcrumb-container container']"));
        String isteneYazi=shop.getText();
        System.out.println(isteneYazi);
        Assert.assertTrue(isteneYazi.contains("Shop"));
        //sepete rastgele ürünler eklenir
        Driver.getDriver().findElement(By.xpath("//a[@class='w-icon-list btn-showtype']")).click();
        WebElement ilkUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14635']"));
        jse.executeScript("arguments[0].click()",ilkUrun);

        WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("//a[@href='?add-to-cart=14782']"));
        jse.executeScript("arguments[0].click()",ikinciUrun);
        //ürünlerin eklendiği test edilir
        WebElement urunAdedi=Driver.getDriver().findElement(By.xpath("(//span[@class='cart-count'])[1]"));
        String urunSayisi=urunAdedi.getText();
        System.out.println(urunSayisi);
        Thread.sleep(2000);
        Assert.assertTrue(!urunSayisi.equals("0"));
        //sepete tıklanır
        WebElement sepet=Driver.getDriver().findElement(By.xpath("//a[@class='cart-toggle']"));
        jse.executeScript("arguments[0].click()",sepet);
        //sepeti görüntüle tıklanır
        WebElement wievCart=Driver.getDriver().findElement(By.xpath("//a[@class='button wc-forward']"));
        jse.executeScript("arguments[0].click()",wievCart);
        // + butonuyla ürün arttırılır
        Thread.sleep(2000);
        WebElement arti=Driver.getDriver().findElement(By.xpath("(//button[@class='quantity-plus w-icon-plus'])[1]"));
        arti.click();
        //eksi butonuyla ürün azaltılır
        Thread.sleep(2000);
        WebElement eksi=Driver.getDriver().findElement(By.xpath("(//button[@class='quantity-minus w-icon-minus'])[1]"));
        eksi.click();
        //ürüne tıklanır
       WebElement sepettekiUrun= Driver.getDriver().findElement(By.xpath("(//a[@href=\"https://allovercommerce.com/urun/1984-george-orwell/\"])[1]"));
        jse.executeScript("arguments[0].click()",sepettekiUrun);
        //stok adedinin görünürlüğü test edilir
        WebElement stokAdedi=Driver.getDriver().findElement(By.xpath("//p[@class='stock in-stock']"));
        Assert.assertTrue(stokAdedi.isDisplayed());
        //stok fazlasının sepete eklenemediği test edilir
        String stokyazisi=stokAdedi.getText();
       String sayi= stokyazisi.replaceAll("\\D","");
        System.out.println("sayi "+sayi+" "+"stokyazisi "+stokyazisi);
       int deger=Integer.parseInt(sayi);
       int degerBuyuk=deger+1;
       String buyukSayi=Integer.toString(degerBuyuk);
        System.out.println(stokyazisi+" "+sayi+" deger "+deger);
        WebElement siparisMiktari=Driver.getDriver().findElement(By.xpath("//div[@class='quantity']"));
        //siparisMiktari.sendKeys(buyukSayi);

        //Sepete geri dönülür
        Driver.getDriver().navigate().back();
        //cupon seçeneğinin erisilebilir oldugu dogrulandı
        WebElement couponButton=Driver.getDriver().findElement(By.xpath("//button[@name='apply_coupon']"));
        Assert.assertTrue(couponButton.isEnabled());
        //alışverişe devam butonunun aktif olduğu doğrulandı
        WebElement continueToShopButtonu=Driver.getDriver().findElement(By.xpath("(//a[@href='https://allovercommerce.com/shop/'])[1]"));
        Assert.assertTrue(continueToShopButtonu.isEnabled());
        //ödeme yap butonu tıklandı
        WebElement odemeyeGit=Driver.getDriver().findElement(By.xpath("//div[@class='wc-proceed-to-checkout']"));
        jse.executeScript("arguments[0].click()",odemeyeGit);
        //fatura detayı görüntülendi
        WebElement faturaDetay=Driver.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']"));
        Assert.assertTrue(faturaDetay.isDisplayed());

        //sepeti TemizleButonuna tıklanır
        WebElement sepetiTemizleButonu=Driver.getDriver().findElement(By.name("clear_cart"));
        jse.executeScript("arguments[0].click()",sepetiTemizleButonu);
        //sepetin temizlendiğ yazısı kontrol edilir
        WebElement sepetBosYazisi=Driver.getDriver().findElement(By.xpath("//*[text()='Your cart is currently empty.']"));
        Assert.assertTrue(sepetBosYazisi.isDisplayed());


    }}
