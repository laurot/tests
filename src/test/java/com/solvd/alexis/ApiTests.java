package com.solvd.alexis;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.api.alexisApi.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Alexis")
    public void testGetWeatherMap(){
        LOGGER.info("testing");
        GetWeatherMap api = new GetWeatherMap();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("alexisApi/_get/city/rs.schema");
    }

    @Test(description = "Pick some place by their zip code")
    @MethodOwner(owner = "Alexis")
    public void testGetWeatherByZip(){
        GetWeatherByZip api = new GetWeatherByZip();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("alexisApi/_get/zip/rs.schema");
    }

    @Test(description = "Attempt to get some place by name")
    @MethodOwner(owner = "Alexis")
    public void testGetWeatherByCityQ(){
        GetWeatherByQ api = new GetWeatherByQ();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("alexisApi/_get/q/rs.schema");
    }

    @Test(description = "Attempt to post new values")
    @MethodOwner(owner = "Alexis")
    public void testPostWeather(){
        PostWeather api = new PostWeather();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 5)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Alexis")
    public void testDeleteUser(){
        DeleteUser api = new DeleteUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
