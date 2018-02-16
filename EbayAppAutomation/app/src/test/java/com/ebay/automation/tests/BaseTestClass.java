package com.ebay.automation.tests;

import com.ebay.automation.helper.AppiumBaseClass;
import com.ebay.automation.helper.AppiumController;
import com.ebay.automation.pages.HomePage;
import com.ebay.automation.pages.HomePageListener;
import com.ebay.automation.pages.SearchPage;
import com.ebay.automation.pages.SearchPageListener;
import com.ebay.automation.pages.SearchResultPage;
import com.ebay.automation.pages.SearchResultPageListener;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Ruban on 15/02/18.
 */

public class BaseTestClass extends AppiumBaseClass {


    protected HomePageListener loginPage;
    protected SearchPageListener searchPage;
    protected SearchResultPageListener searchResultPage;

    @BeforeSuite
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:

                loginPage = new HomePage(driver());
                searchPage = new SearchPage(driver());
                searchResultPage = new SearchResultPage(driver());

                break;

        }
    }


    @AfterSuite
    public void tearDown() {
        AppiumController.instance.stop();
    }
}

