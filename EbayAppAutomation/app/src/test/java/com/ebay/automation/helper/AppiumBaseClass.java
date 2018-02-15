package com.ebay.automation.helper;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by Ruban on 15/02/18.
 */

public abstract class AppiumBaseClass {

    protected AndroidDriver<?> driver() {
        return AppiumController.instance.driver;
    }

}
