package com.solvd.lautaro;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests implements IAbstractTest{
    
    @Test(description = "Checks if the sum of the numbers is right", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void testSum(HashMap<String, String> args){
        int sum = Integer.valueOf(args.get("a"))+Integer.valueOf(args.get("b"));
        Assert.assertEquals(sum, Integer.valueOf(args.get("sum")));
    }

    @Test(description = "Checks if the multiplication of the numbers is right", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void testMult(HashMap<String, String> args){
        int mult = Integer.valueOf(args.get("a"))*Integer.valueOf(args.get("b"));
        Assert.assertEquals(mult, Integer.valueOf(args.get("mult")));
    }

    @Test(description = "Checks if the square is correct", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void testsquare(HashMap<String, String> args){
        int a = Integer.valueOf(args.get("a"));
        int b = Integer.valueOf(args.get("b"));
        int srest = a*a-b*b;
        Assert.assertEquals(srest, Integer.valueOf(args.get("square")));
    }

    @Test(description = "Checks if a is bigger than b", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void TestAB(HashMap<String, String> args){
        int a = Integer.valueOf(args.get("a"));
        int b = Integer.valueOf(args.get("b"));
        Assert.assertTrue(a < b);
    }

    @Test(description = "Checks if the sum of the sumbers is right", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "secondsheet", dsUid = "TUID", testRailColumn = "a")
    public void test3(HashMap<String, String> args){
        int age = Integer.valueOf(args.get("age"));
        boolean isAdult = Boolean.parseBoolean(args.get("adult")) ;
        Assert.assertTrue((age >= 18) == isAdult);
    }
}
