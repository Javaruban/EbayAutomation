package com.ebay.automation.pages;

import com.ebay.automation.helper.AppiumHelper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by Ruban on 16/02/18.
 */

public class SignInPagePage extends AppiumHelper implements SignInPageListener {

  //  public static final By username = By.id("com.ebay.mobile:id/edit_text_username");
   // public static final By password = By.id("com.ebay.mobile:id/edit_text_password");
   // public static final By signinbutton = By.id("com.ebay.mobile:id/button_sign_in");

    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'edit_text_username')]")
    public MobileElement userName;

    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'edit_text_password')]")
    public MobileElement password;

    @FindBy(xpath = "//android.widget.Button[contains(@resource-id,'button_sign_in')]")
    public MobileElement signButton;

    public SignInPagePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void signInWithCredentials(String user_name, String pwd) {
        typeText(userName, user_name);
        typeText(password, pwd);
        clickElement(signButton);
    }
}
