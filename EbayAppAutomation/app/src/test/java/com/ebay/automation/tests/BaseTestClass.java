package com.ebay.automation.tests;

import com.ebay.automation.helper.AppiumBaseClass;
import com.ebay.automation.helper.AppiumController;
import com.ebay.automation.pages.BuyNowPage;
import com.ebay.automation.pages.BuyNowPageListener;
import com.ebay.automation.pages.EnterQuantityPage;
import com.ebay.automation.pages.EnterQuantityPageListener;
import com.ebay.automation.pages.HomePage;
import com.ebay.automation.pages.HomePageListener;
import com.ebay.automation.pages.ProceedToPageListener;
import com.ebay.automation.pages.ProceedToPayPage;
import com.ebay.automation.pages.SearchPage;
import com.ebay.automation.pages.SearchPageListener;
import com.ebay.automation.pages.SearchResultPage;
import com.ebay.automation.pages.SearchResultPageListener;
import com.ebay.automation.pages.SignInPageListener;
import com.ebay.automation.pages.SignInPagePage;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Ruban on 15/02/18.
 */

public class BaseTestClass extends AppiumBaseClass {



    protected BuyNowPageListener buyNowPage;
    protected EnterQuantityPageListener enterQuantityPage;
    protected HomePageListener homePage;
    protected ProceedToPageListener proceedToPage;
    protected SearchPageListener searchPage;
    protected SearchResultPageListener searchResultPage;
    protected SignInPageListener signInPage;

    @BeforeSuite
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:

                buyNowPage = new BuyNowPage(driver());
                enterQuantityPage = new EnterQuantityPage(driver());
                homePage = new HomePage(driver());
                proceedToPage = new ProceedToPayPage(driver());
                searchPage = new SearchPage(driver());
                searchResultPage = new SearchResultPage(driver());
                signInPage = new SignInPagePage(driver());

                break;

        }
    }


    @AfterSuite
    public void tearDown() {
        AppiumController.instance.stop();
    }
}

