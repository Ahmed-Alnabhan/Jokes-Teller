/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.elearnna.www.jokesteller.jokesbackend;

import com.example.JokesStore;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokesbackend.jokesteller.www.elearnna.com",
                ownerName = "jokesbackend.jokesteller.www.elearnna.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    private JokesStore jokesStore;
    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getAJoke")
    public MyBean getAJoke() {
        MyBean response = new MyBean();
        jokesStore = new JokesStore();
        String joke = jokesStore.tellMeAJoke();
        response.setData(joke);

        return response;
    }

}
