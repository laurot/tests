package com.solvd.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url= "${base_url}/data/2.5/weather", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherMethod extends AbstractApiMethodV2 {

    public GetWeatherMethod () {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addUrlParameter("lat", "33.44");
        addUrlParameter("lon", "-94.84");
        addUrlParameter("appid", "ebcbce76c2e1c2539d1c46431a4455f6");
    }

}