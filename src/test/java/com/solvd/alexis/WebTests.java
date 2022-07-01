package com.solvd.alexis;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gui.alexisGui.components.Header;
import com.solvd.gui.alexisGui.pages.CartPage;
import com.solvd.gui.alexisGui.pages.HomePage;
import com.solvd.gui.alexisGui.pages.ModelInfoPage;
import com.solvd.gui.alexisGui.pages.PhonesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTests implements IAbstractTest {
    @Test(description = "Attempt to go to the header menu and click on CART")
    @MethodOwner(owner = "Alexis")
    public void testCartPage(){

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Header headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2),"Header menu wasn't found!");
        CartPage cartPage = headerMenu.openCartPage();
    }

    @Test(description = "Attempt to open phones page and select the Samsung Galaxy S6 model")
    @MethodOwner(owner = "Alexis")
    public void testProductSpecs() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new HomePage(getDriver());
        PhonesPage phonesPage = homePage.getCategories().openPhonesPage();

        ModelInfoPage modelInfoPage = phonesPage.selectModel("Samsung galaxy s6");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(modelInfoPage.readDescription(),"Product description\n" +
                "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with" +
                " 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.");
        softAssert.assertEquals(modelInfoPage.readPrice(),"$360 *includes tax","Invalid display info!");
        softAssert.assertAll();
    }
}
