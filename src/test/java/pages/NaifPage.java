package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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



}
