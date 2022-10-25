package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CengizhanPage {
    public CengizhanPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInWE;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameWE;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordWE;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButtonWE;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountWE;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerWE;

    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement couponsWE;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNewWE;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement codeBoxWE;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement descriptionWE;

    @FindBy(xpath = "//select[@id='discount_type']")
    public WebElement discountTypeWE;

    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement couponAmountWE;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement couponExpiryDateWE;

    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement freeShippingWE;

    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showOnStoreWE;

    @FindBy(xpath = "//div[@id='coupons_manage_limit']")
    public WebElement limitButtonWE;

    @FindBy(xpath = "//input[@id='usage_limit']")
    public WebElement usageLimitWE;

    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement limitUsageToXItemsWE;

    @FindBy(xpath = "//input[@id='usage_limit_per_user']")
    public WebElement usageLimitPerUserWE;
}
