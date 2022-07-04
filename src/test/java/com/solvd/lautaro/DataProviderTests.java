package com.solvd.lautaro;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Parameters;
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

    @Test(description = "Checks if the square column is correct", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @Parameters({"a", "b", "square"})
    @TestRailCases(testCasesId = "1")
    public void testWithParameters(String a, String b, String square){
        int aa = Integer.valueOf(a);
        int bb = Integer.valueOf(b);
        int srest = aa*aa-bb*bb;
        Assert.assertEquals(srest, Integer.valueOf(square));
    }

    @Test(description = "Checks if the sum of the sumbers is right", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void test2(HashMap<String, String> args){
        int sum = Integer.valueOf(args.get("a"))+Integer.valueOf(args.get("b"));
        Assert.assertEquals(sum, Integer.valueOf(args.get("sum")));
    }

    @Test(description = "Checks if the sum of the sumbers is right", dataProvider = "DataProvider")
    @MethodOwner(owner = "Lautaro")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/tests.xlsx", sheet = "numbers", dsUid = "TUID", testRailColumn = "a")
    public void test3(HashMap<String, String> args){
        int sum = Integer.valueOf(args.get("a"))+Integer.valueOf(args.get("b"));
        Assert.assertEquals(sum, Integer.valueOf(args.get("sum")));
    }
}
