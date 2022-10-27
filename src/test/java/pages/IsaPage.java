package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IsaPage {

    public IsaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//span[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath="(//input[@id='username'])[1]")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/shop/'])[1]")
    public WebElement goShop;
    @FindBy(xpath = "//div[@class='breadcrumb-container container']")
   public WebElement shop;
    @FindBy(xpath = "//a[@href='?add-to-cart=14635']")
   public WebElement ilkUrun;
    @FindBy(xpath = "//a[@href='?add-to-cart=14782']")
   public WebElement ikinciUrun;
    @FindBy(xpath = "//a[@class='cart-toggle']")
    public WebElement sepet;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement wievCart;
    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement urunAdedi;
    @FindBy(xpath = "(//button[@class='quantity-plus w-icon-plus'])[1]")
    public WebElement plusButton;
    @FindBy(xpath = "(//button[@class='quantity-minus w-icon-minus'])[1]")
    public WebElement minusButton;
    @FindBy(xpath = "(//a[@href=\"https://allovercommerce.com/urun/1984-george-orwell/\"])[1]")
    public WebElement sepettekiUrun;

    @FindBy(xpath = "//p[@class='stock in-stock']")
    public WebElement stokAdedi;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement couponButton;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/shop/'])[1]")
    public WebElement continueToShopButtonu;

    @FindBy(xpath="//a[@class='login logout inline-type']")
    public WebElement signOut;

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement orders;
    @FindBy(name = "clear_cart")
    public WebElement sepetiTemizleButonu;
    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']")
    public WebElement odemeyeGit;
    @FindBy(xpath = "//tr[@class='cart-subtotal']")
    public WebElement faturaDetay;

    @FindBy(xpath = "//*[text()='Your cart is currently empty.']")
    public WebElement sepetBosYazisi;



    @FindBy(xpath = "//div[@class='quantity']")
    public WebElement siparisMiktari;
}
