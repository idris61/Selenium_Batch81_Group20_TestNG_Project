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

public class SumeyyePage {


    public SumeyyePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Actions actions = new Actions(Driver.getDriver());
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//*[text()='Select']")
    public WebElement addPhotoSelect;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement bigPhotoIsDisplay;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='excerpt_ifr']")
    public WebElement addNewShortDescIframe;
    @FindBy(xpath = "//*[@id='description_ifr']")
    public WebElement addNewLongDescIframe;
    @FindBy(xpath = "(//body[@id='tinymce'])[1]")
    public WebElement shortDescription;

    @FindBy(css = "#user_email")
    public WebElement email;


    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInEmail;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;


    //Dashboord
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;


    // Store Manager
    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindAll({
            @FindBy(xpath = "//thead//tr/th[5]"),
            //public WebElement statusText;

            @FindBy(xpath = "//thead//tr/th[6]"),
            //public WebElement stockText;

            @FindBy(xpath = "//thead//tr/th[7]"),
            //public WebElement priceText;

            @FindBy(xpath = "//thead//tr/th[11]")
            //public WebElement dateText;
    })
    public List<WebElement> productHeaders;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindBy(xpath = "(//input[@type='checkbox'])")
    public WebElement virtualCheckBox;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement downloadableCheckBox;

    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitleBox;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement addPhoto;

    @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
    public WebElement selectFiles;


    @FindBy(xpath = "(//*[@class='text'])[7]")
    public WebElement customersButton;


    @FindAll({
            @FindBy(xpath = "//thead//tr//th[1]"),
            @FindBy(xpath = "//thead//tr//th[2]"),
            @FindBy(xpath = "//thead//tr//th[3]"),
            @FindBy(xpath = "//thead//tr//th[4]"),
            @FindBy(xpath = "//thead//tr//th[6]")
    })
    public List<WebElement> customerTableHeads;

    @FindAll({
            @FindBy(xpath = "//*[text()='PDF']"),


            @FindBy(xpath = "//*[text()='Excel']"),


            @FindBy(xpath = "//*[text()='CSV']")

    })
    public List<WebElement> pdfExcelCSV;


    @FindBy(xpath = "//*[@id='user_name']")
    public WebElement customerUserName;

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement customerUserEmail;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement customerFirstName;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement customerLastName;


}

