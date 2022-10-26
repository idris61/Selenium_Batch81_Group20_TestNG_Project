package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NaifPage {
    public NaifPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement sign;

    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(linkText = "My Orders")
    public WebElement myOrders;

    @FindBy(xpath = "//*[@Class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement Browseproducts;

    @FindBy(xpath = "(//*[@Class='w-icon-cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "//*[@Class='button checkout wc-forward']")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstname;

    @FindBy(xpath = "//*[@Class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goshop;

    @FindBy(xpath = "(//*[@Class='woocommerce-button button woocommerce-form-login__submit'])[1]")
    public WebElement sign2;

    @FindBy(xpath = "(//*[@Class='button product_type_simple add_to_cart_button ajax_add_to_cart'])[4]")
    public WebElement basket;

    @FindBy(xpath = "(//*[@Class='button product_type_simple add_to_cart_button ajax_add_to_cart'])[3]")
    public  WebElement triko;

    @FindBy(xpath = "(//*[@Class='button product_type_simple add_to_cart_button ajax_add_to_cart'])[2]")
    public WebElement canta;

    @FindBy(xpath = "(//*[@Class='button product_type_simple add_to_cart_button ajax_add_to_cart'])[1]")
    public WebElement crusher;

    @FindBy(xpath = "(//*[@Class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[2]")
    public WebElement tarhana;

    @FindBy(xpath = "(//*[@Class='input-text'])[2] ")
    public WebElement firstName;

    @FindBy(linkText = "(//*[text()='Home & Garden'])[1]")
    public WebElement homegarden;

    @FindBy(linkText = "(//*[text()='Electronics'])[1]")
    public WebElement Electronics;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeorder;

    @FindBy(xpath = "//*[@Class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thenkyou;



}


