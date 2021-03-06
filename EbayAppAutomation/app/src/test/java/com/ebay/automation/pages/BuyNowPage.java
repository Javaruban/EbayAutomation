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

public class BuyNowPage extends AppiumHelper implements BuyNowPageListener {

    @FindBy(xpath = "//android.widget.Button[contains(@resource-id,'button_bin')]")
    public MobileElement buyItNow;


    public BuyNowPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Override
    public void clickBuyItNowButton() {
        clickElement(buyItNow);
    }
}
