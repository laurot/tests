package com.solvd.lautaro;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.mobile.gui.pages.android.CalculatorPage;
import com.zebrunner.agent.core.annotation.TestLabel;

public class AndroidTests implements IAbstractTest, IMobileUtils{
    
    @Test()
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sumAll() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        Assert.assertTrue(calculatorPage.isPageOpened(), "Page wasn't open");
        calculatorPage.clickZero();
        calculatorPage.clickPlus();
        calculatorPage.clickOne();
        calculatorPage.clickPlus();
        calculatorPage.clickTwo();
        calculatorPage.clickPlus();
        calculatorPage.clickThree();
        calculatorPage.clickPlus();
        calculatorPage.clickFour();
        calculatorPage.clickPlus();
        calculatorPage.clickFive();
        calculatorPage.clickPlus();
        calculatorPage.clickSix();
        calculatorPage.clickPlus();
        calculatorPage.clickSeven();
        calculatorPage.clickPlus();
        calculatorPage.clickEight();
        calculatorPage.clickPlus();
        calculatorPage.clickNine();
        Assert.assertEquals("45", calculatorPage.readResult());
    }
}
