package com.ebay.automation.pages;

/**
 * Created by Ruban on 15/02/18.
 */

public interface HomePageListener {

    public boolean isHomePageLoaded();

    public boolean isUserSignedIn();

    public void clickRegister();

    public void clickSignIn();

    public void navigateToSignInPage();

    public void openSlidingMenu();

    public void closeSlidingMenu();

    public void clickSearchProductBox();
}
