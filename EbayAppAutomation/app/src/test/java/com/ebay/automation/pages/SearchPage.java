package com.ebay.automation.pages;


import com.ebay.automation.helper.AppiumHelper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by Ruban on 16/02/18.
 */

public class SearchPage extends AppiumHelper implements SearchPageListener {


    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'search_src_text')]")
    public MobileElement searchBox;


    @FindBy(xpath = "//android.widget.ListView[contains(@resource-id,'suggestionList')]")
    public List<MobileElement> suggestionList;

    public SearchPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void enterValuesInSearchBox(String searchString) {
        typeText(searchBox, searchString);

    }

    @Override
    public void selectItemFromSuggestionBox(int itemNumber){
        selectItem(suggestionList, itemNumber);

    }
}
