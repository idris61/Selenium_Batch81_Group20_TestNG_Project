package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class MansoorPage {
    public MansoorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    public Actions actions = new Actions(Driver.getDriver());

    public static Select selectMethod(WebElement select){
        Select select1=new Select(select);

        return select1;
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    // US007 Locators
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInEmail;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;

    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy (xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindAll({
            @FindBy (xpath = "//input[@value='35']"),

            @FindBy (xpath = "//input[@value='41']"),

            @FindBy (xpath = "//input[@value='46']"),

            @FindBy (xpath = "//input[@value='47']"),

            @FindBy (xpath = "//input[@value='50']"),

            @FindBy (xpath = "//input[@value='52']"),

            @FindBy (xpath = "//input[@value='55']")


    })
    public List<WebElement> productBrandsElements;



    // US017 Locators
    @FindBy (xpath = "(//*[@class='text'])[7]")
    public WebElement customersButton;

    @FindBy (xpath = "(//*[text()='Add New'])[1]")
    public WebElement customersAddNew;

    @FindAll({
            @FindBy(xpath = "//*[@id='bfirst_name']"),

            @FindBy(xpath = " //*[@id='blast_name']"),

            @FindBy(xpath = "//*[@id='bcompany_name']"),

            @FindBy(xpath = "//*[@id='bphone']"),

            @FindBy(xpath = "//*[@id='baddr_1']"),

            @FindBy(xpath = "//*[@id='baddr_2']"),

            @FindBy(xpath = "//*[@id='bcity']"),

            @FindBy(xpath = "//*[@id='bstate']"),

            @FindBy(xpath = "//*[@id='bzip']")

    })
    public List<WebElement> customerBillingList;

    @FindBy(xpath = "//*[@id='bcountry']")
    public WebElement customerBillingCountry;

    @FindBy(xpath = "//*[@id='same_as_billing']")
    public WebElement customerSameasBillingButton;

    @FindAll({
            @FindBy(xpath = "//*[@id='sfirst_name']"),

            @FindBy(xpath = " //*[@id='slast_name']"),

            @FindBy(xpath = "//*[@id='scompany_name']"),

            @FindBy(xpath = "//*[@id='saddr_1']"),

            @FindBy(xpath = "//*[@id='saddr_2']"),

            @FindBy(xpath = "//*[@id='scity']"),

            @FindBy(xpath = "//*[@id='sstate']"),

            @FindBy(xpath = "//*[@id='szip']")

    })
    public List<WebElement> customerShippingList;

    @FindBy(xpath = "//*[@id='scountry']")
    public WebElement customerShippingCountry;

    @FindBy(xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement customerSubmitButton;
}
