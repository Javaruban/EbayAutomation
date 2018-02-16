package com.ebay.automation.tests;

import com.ebay.automation.pages.SearchResultPage;
import com.ebay.automation.util.ExcelUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Created by Ruban on 15/02/18.
 */

public class AddToCartFlow extends BaseTestClass {

    private String sTestCaseName;
    private int iTestCaseRow;
    private final static String EXCEL_PATH = "src/test/assets/EbayTestData.xlsx";
    private final static String EXCEL_NAME = "EbayTestData";
    //Later this can also be passed via excel
    private final static String PRODUCT_TO_SEARCH  = "toys";

    @Test(dataProvider="Authentication")
    public void AddToCartFlow(String sUserName,String sPassword) throws Exception {

       if(homePage.isUserNotSignedIn()){

        homePage.openSlidingMenu();
        homePage.navigateToSignInPage();
        signInPage.signInWithCredentials(sUserName, sPassword);//THIS VALUES COMES FROM EXCEL

        }

        homePage.clickSearchProductBox();
        searchPage.enterValuesInSearchBox(PRODUCT_TO_SEARCH);
        searchPage.selectItemFromSuggestionBox(3);//Later this can also be passed via excel
        searchResultPage.selectItemFromSearchResult(1);
        enterQuantityPage.clickReviewButton();
        buyNowPage.clickBuyItNowButton();
        proceedToPage.clickProceedToPay();

    }

    @DataProvider
    public Object[][] Authentication() throws Exception{

        // Setting up the Test Data Excel file
        ExcelUtils.setExcelFile(EXCEL_PATH, EXCEL_NAME);
        sTestCaseName = this.toString();
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray(EXCEL_PATH, EXCEL_NAME,iTestCaseRow);

        return (testObjArray);

    }

}
