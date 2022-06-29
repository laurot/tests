package com.solvd.alexis;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gui.alexisGui.components.Header;
import com.solvd.gui.alexisGui.pages.CartPage;
import com.solvd.gui.alexisGui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Alexis")
    public void testCartPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Header headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2),"Header menu wasn't found!");
        CartPage cartPage = headerMenu.openCartPage();
    }
}
