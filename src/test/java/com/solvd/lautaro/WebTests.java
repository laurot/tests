package com.solvd.lautaro;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gui.components.NavBar;
import com.solvd.gui.pages.CartPage;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.ItemPage;

public class WebTests implements IAbstractTest {

    @Test(description = "Checks item Nexus 6 and the price")
    @MethodOwner(owner = "Lautaro")
    public void testNexus() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "home page is not opened");
        homePage = new HomePage(getDriver());
        ItemPage itemPage = homePage.selectItem("Nexus 6");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(), "Nexus 6");
        softAssert.assertEquals(itemPage.readPrice(), "$650");
    }

    @Test(description = "Adds a product to the cart and then deletes it")
    @MethodOwner(owner = "Lautaro")
    public void addToCartAndDeleteTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ItemPage itemPage = homePage.selectItem("Nexus 6");
        itemPage.addToCart();
        CartPage cartPage = itemPage.getNavBar().openCartpage();
        cartPage.selectItem("Nexus 6")
                .deleteItemFromCart();
        boolean a = false;
        try {
            cartPage.selectItem("Nexus 6");
        } catch (RuntimeException e) {
            a = true;
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a);
    }

    @Test(description = "Goes to next page and tries to find a product")
    @MethodOwner(owner = "Lautaro")
    public void nextAndPrevTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.nextOptions();
        ItemPage itemPage = homePage.selectItem("MacBook air");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(), "MacBook air");
    }

    @Test(description = "filters laptops and tries to find a product")
    @MethodOwner(owner = "Lautaro")
    public void LaptopsTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.showLaptops();
        ItemPage itemPage = homePage.selectItem("Sony vaio i7");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(), "Sony vaio i7");
    }

    @Test(description = "Test navbar homepage")
    @MethodOwner(owner = "Lautaro")
    public void SomethingTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ItemPage itemPage = homePage.selectItem("Nexus 6");
        NavBar navBar = itemPage.getNavBar();
        homePage = navBar.openHomePage();
        itemPage = homePage.selectItem("Samsung galaxy s6");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.readName(), "Samsung galaxy s6");
    }
}
