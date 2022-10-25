package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BeyzaPage {
    public BeyzaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Sign In'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//*[text()='My Account'])[4]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@class='myaccount-content']")
    public WebElement myAccountList;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement myAccountSignOutLink;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[1]")
    public WebElement toptanUrunlerGostermeAyarlari;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement pieceDdm;

    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitPerPiece;

    @FindBy(xpath = "//input[@class='wcfm-text wcfm_ele simple variable external grouped booking field_61d33a93da83d']")
    public WebElement minOrderQuantity;

    @FindBy(xpath = "(//span[@class='text'])[14]")
    public WebElement reports;

    @FindBy(xpath = "(//*[text()='Year']")
    public WebElement year;

    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastMonth;


    @FindBy(xpath = "//*[text()='(//*[text()='This Month'])[1]']")
    public WebElement thisMonth;

    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7Days;

    @FindBy(xpath = "//*[@id='chart-placeholder-canvas']")
    public WebElement grafik;

    @FindBy(xpath = "//input[@placeholder='Choose Date Range ...']")
    public WebElement chooseDateRange;



}
