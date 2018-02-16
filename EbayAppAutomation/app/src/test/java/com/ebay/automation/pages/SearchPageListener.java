package com.ebay.automation.pages;

/**
 * Created by ruban on 16/02/18.
 */

public interface SearchPageListener {

    public void enterValuesInSearchBox(String searchString);
    /*
    Item Number starts from one
     */
    public void selectItemFromSuggestionBox(int itemNumber);



}
