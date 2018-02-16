package com.ebay.automation.tests;

import org.testng.annotations.Test;
/**
 * Created by Ruban on 15/02/18.
 */

public class AddToCartFlow extends BaseTestClass {

    @Test
    public void AddToCartFlow() {




             //if(!loginPage.isUserSignedIn()){

             //loginPage.openSlidingMenu();
             //loginPage.navigateToSignInPage();
             //loginPage.clickSignIn();
             loginPage.clickSearchProductBox();
             searchPage.enterValuesInSearchBox("toys");
             searchPage.selectItemFromSuggestionBox(1);
             searchResultPage.selectItemFromSearchResult(1);

            // }else{





            // }



    }



}
