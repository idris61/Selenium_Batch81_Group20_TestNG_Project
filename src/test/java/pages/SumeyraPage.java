package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.List;

public class SumeyraPage {
    public SumeyraPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public Actions actions = new Actions(Driver.getDriver());
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//thead//tr//th[4]")
    public WebElement refundAmount;
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
    @FindBy(css = "#user_email")
    public WebElement email;
    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInEmail;
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;
    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;
    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;
    @FindBy(xpath = "//input[@id='sku']")
    public WebElement sku;
    @FindBy(xpath = "//input[@id='wcfm_products_simple_draft_button']")
    public WebElement draft;
    @FindAll({
            @FindBy(xpath = "//input[@id='sku']"),
            @FindBy(xpath = "//input[@id='manage_stock']"),
            @FindBy(xpath = "//input[@id='stock_qty']")
    })
    public List<WebElement> sMs;
    @FindBy(xpath = "//select[@id='stock_status']")
    public WebElement backorder;
    @FindBy(xpath = "(//*[@class='text'])[8]")
    public WebElement refundButton;
    @FindBy(xpath = "//thead//tr//th[2]")
    public WebElement refundRequestId;
    @FindBy(xpath = "//thead//tr//th[3]")
    public WebElement refundOrderId;
    @FindAll({
            @FindBy(xpath = "//thead//tr//th[5]"),
            @FindBy(xpath = "//thead//tr//th[6]")
    })
    public List<WebElement> refundTypeReason;

}
