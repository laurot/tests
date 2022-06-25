package com.solvd.lautaro;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.ItemPage;

public class WebTests implements IAbstractTest{
    
    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testSomething(){

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not opened");

        homePage = new HomePage(getDriver());
        ItemPage itemPage = homePage.selectItem("Nexus 6");
        
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(),"Nexus 6");
        softAssert.assertEquals(itemPage.readPrice(), "$650");
    }
}
