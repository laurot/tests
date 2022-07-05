package com.solvd.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.gui.pages.common.CalculatorBasePage;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CalculatorBasePage.class)
public class CalculatorPage extends CalculatorBasePage{

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='plus']")
    private ExtendedWebElement plusBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='minus']")
    private ExtendedWebElement minusBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='multiply']")
    private ExtendedWebElement multiplyBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='divide']")
    private ExtendedWebElement divideBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='percent']")
    private ExtendedWebElement percentBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='left or right parenthesis']")
    private ExtendedWebElement parenthesisBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='clear']")
    private ExtendedWebElement clearBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='equals']")
    private ExtendedWebElement equalsBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='1']")
    private ExtendedWebElement oneBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='2']")
    private ExtendedWebElement twoBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='3']")
    private ExtendedWebElement threeBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='4']")
    private ExtendedWebElement fourBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='5']")
    private ExtendedWebElement fiveBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='6']")
    private ExtendedWebElement sixBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='7']")
    private ExtendedWebElement sevenBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='8']")
    private ExtendedWebElement eightBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='9']")
    private ExtendedWebElement nineBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='0']")
    private ExtendedWebElement zeroBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='point']")
    private ExtendedWebElement pointBtn;

    @FindBy(id = "com.google.android.calculator:id/formula")
    private ExtendedWebElement formulaField;

    @FindBy(id = "com.google.android.calculator:id/result_preview")
    private ExtendedWebElement resultField;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    
    public String readResult(){
        resultField.assertElementPresent();
        return resultField.getText();
    }

    public void insertFormula(String input){
        formulaField.type(input);
    }

    public void clickZero(){
        zeroBtn.click();
    }

    public void clickOne(){
        oneBtn.click();
    }

    public void clickTwo(){
        twoBtn.click();
    }

    public void clickThree(){
        threeBtn.click();
    }

    public void clickFour(){
        fourBtn.click();
    }

    public void clickFive(){
        fiveBtn.click();
    }

    public void clickSix(){
        sixBtn.click();
    }

    public void clickSeven(){
        sevenBtn.click();
    }

    public void clickEight(){
        eightBtn.click();
    }

    public void clickNine(){
        nineBtn.click();
    }

    public void clickPlus(){
        plusBtn.click();
    }

    public void clickMinus(){
        minusBtn.click();
    }

    public void clickMultiply(){
        multiplyBtn.click();
    }

    public void clickDivide(){
        divideBtn.click();
    }

    public void clickPercent(){
        percentBtn.click();
    }
    
    public void clickParenthesis(){
        parenthesisBtn.click();
    }

    public void clickClear(){
        clearBtn.click();
    }

    public void clickPoint(){
        pointBtn.click();
    }

    public void clickEquals(){
        equalsBtn.click();
    }
}
