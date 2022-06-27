package com.solvd.api.alexisApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "alexisApi/_get/q/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    public class GetWeatherByQ extends AbstractApiMethodV2 {
        public GetWeatherByQ(){
            replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
            addUrlParameter("q", "Boston");
            addUrlParameter("appid", "5b344c6b2d82cee778953054fd277080");
        }
}
