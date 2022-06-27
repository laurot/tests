package com.solvd.api.alexisApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/users/3", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "alexisApi/_delete/rq.json")
@ResponseTemplatePath(path = "alexisApi/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteUser extends AbstractApiMethodV2 {

    public DeleteUser() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url1"));
    }
}
