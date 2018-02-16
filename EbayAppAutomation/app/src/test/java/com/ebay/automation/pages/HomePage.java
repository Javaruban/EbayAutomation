package com.ebay.automation.pages;

import com.ebay.automation.helper.AppiumHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by Ruban on 15/02/18.
 */

public class HomePage extends AppiumHelper implements HomePageListener {

    private static final int SECONDS=1;

    @FindBy(xpath = "//android.widget.Button[@text='RELOAD']")
    public MobileElement reloadButton;


    @FindBy(xpath = "//android.widget.Button[@text='REGISTER']")
    public MobileElement registerButton;

    @FindBy(xpath = "//android.widget.Button[@text='SIGN IN']")
    public MobileElement signInButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textview_sign_in_status')]")
    public MobileElement displayName;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textview_sign_out_status')]")
    public MobileElement signText;

    @FindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'home')]")
    public MobileElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'search_box')]")
    public MobileElement searchBoxTxtVw;

       //android.widget.TextView[@content-desc="Sign in,double tap to activate"]
    //com.ebay.mobile:id/textview_sign_in_status

    public HomePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean isHomePageLoaded() {

        boolean isElementPresent;
        topBottomSwipe(SECONDS);
        try{
            isElementPresent = isElementVisibleWaitAndCheck(reloadButton);
        }catch(NoSuchElementException NSE){
            isElementPresent = false;
        }

        return isElementPresent;
    }

    @Override
    public boolean isUserSignedIn() {
        openSlidingMenu();
        return isElementPresent(displayName);
    }

    @Override
    public void clickRegister() {
        clickElement(registerButton);
    }

    @Override
    public void clickSignIn() {
        clickElement(signInButton);


    }

    /*
     Navigate to sign in Page
     */
    @Override
    public void navigateToSignInPage() {
        //openSlidingMenu();
        clickElement(signText);

    }

    @Override
    public void openSlidingMenu() {
        clickElement(menuButton);
    }

    @Override
    public void closeSlidingMenu() {
        rightLeftSwipe(SECONDS);//closing sliding  navigation menu
    }

    @Override
    public void clickSearchProductBox() {
        clickElement(searchBoxTxtVw);
    }


}
