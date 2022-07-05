package com.solvd.lautaro;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.mobile.gui.pages.android.CalculatorPage;
import com.zebrunner.agent.core.annotation.TestLabel;

public class AndroidTests implements IAbstractTest, IMobileUtils{
    
    @Test(description = "adds 0 to 9 and checks the result")
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sumAll() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
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

    @Test(description = "Makes a division to check it works")
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void TestDivision() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        calculatorPage.clickFour();
        calculatorPage.clickNine();
        calculatorPage.clickDivide();
        calculatorPage.clickSeven();
        Assert.assertEquals("7", calculatorPage.readResult());
    }

    @Test(description = "Makes a multiplication to check it works")
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void TestMultiplication() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        calculatorPage.clickFour();
        calculatorPage.clickNine();
        calculatorPage.clickMultiply();
        calculatorPage.clickSeven();
        Assert.assertEquals("343", calculatorPage.readResult());
    }

    @Test(description = "Makes a substraction to check it works")
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void TestSubstraction() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        calculatorPage.clickSeven();
        calculatorPage.clickMinus();
        calculatorPage.clickFour();
        calculatorPage.clickNine();
        Assert.assertEquals("−42", calculatorPage.readResult());
    }

    @Test(description = "Makes a substraction to check it works")
    @MethodOwner(owner = "Lautaro")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void TestClean() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        calculatorPage.clickSeven();
        calculatorPage.clickPoint();
        calculatorPage.clickFive();
        calculatorPage.clickMinus();
        calculatorPage.clickFour();
        calculatorPage.clickClear();
        Assert.assertEquals("", calculatorPage.readResult());
    }
}
