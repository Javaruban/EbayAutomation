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

public class SearchResultPage extends AppiumHelper implements SearchResultPageListener {

    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'search_src_text')]")
    public MobileElement searchBox;


    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[contains(@resource-id,'recycler')]")
    public List<MobileElement> suggestedItemList;

    public SearchResultPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Override
    public void selectItemFromSearchResult(int itemNumber) {
        selectItem(suggestedItemList, itemNumber);
    }
}
