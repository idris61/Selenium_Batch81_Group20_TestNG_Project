package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SumeyraPage {
    public SumeyraPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public Actions actions=new Actions(Driver.getDriver());
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//input[@id='wcfm_products_simple_draft_button']")
    public WebElement draft;


    @FindAll({
            @FindBy(xpath = "//input[@id='sku']"),


            @FindBy(xpath = "//input[@id='manage_stock']"),


            @FindBy(xpath = "//input[@id='stock_qty']")


    })
    public List<WebElement> sMs;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement signInEmail;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/']")
    public WebElement myAccount;


    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//*[@class='text'])[4]")
    public  WebElement products;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@id='sku']")
    public WebElement sku;
    @FindBy (xpath = "//select[@id='stock_status']")
    public WebElement backorder;


}
