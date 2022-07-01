package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Footer extends AbstractUIObject{

    @FindBy(xpath = "//*[@id='fotcont']/div[2]/div/div/p[1]")
    private ExtendedWebElement address;
    
    @FindBy(xpath = "//*[@id='fotcont']/div[2]/div/div/p[2]")
    private ExtendedWebElement phone;

    @FindBy(xpath = "//*[@id='fotcont']/div[2]/div/div/p[3]")
    private ExtendedWebElement email;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readAddress(){
        assertElementPresent(address);
        return address.getText();
    }

    public String readPhone(){
        assertElementPresent(phone);
        return phone.getText();
    }

    public String readEmail(){
        assertElementPresent(email);
        return email.getText();
    }

}
