package com.solvd.lautaro;

import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.ItemPage;

public class WebTests implements IAbstractTest{
    
    @Test()
    public void testSomething(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not opened");

        homePage = new HomePage(getDriver());
        ItemPage itemPage = homePage.selectModel("Nexus 6");
        
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(),"Nexus 6");
        softAssert.assertEquals(itemPage.readPrice(), "$650");
    }
}
