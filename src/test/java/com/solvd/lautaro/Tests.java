package com.solvd.lautaro;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.api.GetWeatherMethod;
import com.solvd.api.PostWeatherMethod;

public class Tests implements IAbstractTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testGetWeather() throws Exception{
            LOGGER.info("test");
            GetWeatherMethod api = new GetWeatherMethod();
            api.callAPIExpectSuccess();
            api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testCreateWeather() throws Exception{

        PostWeatherMethod api = new PostWeatherMethod();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(3, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testTexarkana() throws Exception {
        GetWeatherMethod api = new GetWeatherMethod();
        api.callAPIExpectSuccess()
                .asString()
                .contains("Texarkana");
    }

    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testSomethingElse() throws Exception{
        GetWeatherMethod api = new GetWeatherMethod();
        api.callAPIExpectSuccess();
    }

    @Test(description = "")
    @MethodOwner(owner = "Lautaro")
    public void testSomething() throws Exception{
        GetWeatherMethod api = new GetWeatherMethod();
        api.callAPIExpectSuccess();
    }
}
