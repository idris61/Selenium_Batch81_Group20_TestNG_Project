package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class FatmaPage {
    public FatmaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public Actions actions = new Actions(Driver.getDriver());
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement signInEmail;
    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/']")
    public WebElement myAccount;
    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersButton;
    @FindBy(xpath = "(//h4[text()='Orders'])[1]")
    public WebElement ordersYazisi;
    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> ordersHeaderList;
    @FindBy(xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsButton;
    @FindBy(xpath = "//*[text()='No downloads available yet.']")
    public WebElement noDownload;
    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addressesButton;
    @FindBy(xpath = "//*[text()='Billing address']")
    public WebElement billingAddressText;
    @FindBy(xpath = "//*[text()='Shipping address']")
    public WebElement shippingAddressText;
    @FindBy(xpath = "(//a[text()='Account details'])[1]")
    public WebElement acoutdetails;
    @FindBy(xpath = "//*[text()='Account Details']")
    public WebElement accountDetailsText;
    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emaildegistir;
    @FindBy(xpath = "//*[text()='Save changes']")
    public WebElement savechanges;
    @FindBy(xpath = "//*[text()='Account details changed successfully.']")
    public WebElement succesfully;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;
}