package com.ebay.automation.pages;

import com.ebay.automation.helper.AppiumHelper;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

/**
 * Created by ruban on 16/02/18.
 */

public class SearchPage extends AppiumHelper implements SearchPageListener {


    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'search_src_text')]")
    public MobileElement searchBox;

}
