package org.vpk.rmt.serviceproviders.buienradar.frontend.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * This interface is the endpoint to connect to the buienradar front end.
 */
@Path(BuienradarFrontEndApi.PATH_ROOT)
@Api(
    value = BuienradarFrontEndApi.PATH_ROOT,
    description = "Rest API providing Buienradar front end services.",
    produces = BuienradarFrontEndApi.CONTENT_TYPE_JSON_UTF8
)
public interface BuienradarFrontEndApi {
    String CONTENT_TYPE_JSON_UTF8 = MediaType.APPLICATION_JSON + "; charset=utf-8\"";

    // path constants
    String PATH_ROOT = "/";
    String PATH_WEATHER = "/weather/{country}";

    // parameter constants
    String PARAM_COUNTRY = "country";
    String PARAM_CITY = "city";
    String PARAM_DEBUG = "debug";

    /**
     * $/weather/{country}?{city}
     *
     * This method fetches the weather information for a country.
     *
     * @param debug
     *  Flag to indicate if debug information is to be provided.
     *
     * @return
     *  The weather information for a country.
     * @since
     *  1.0.0
     */
    @GET
    @Path(PATH_WEATHER)
    @Produces(CONTENT_TYPE_JSON_UTF8)
    @ApiOperation(value = PATH_WEATHER, httpMethod = "GET", notes = "This will return the weather information for a country.", response = String.class)
    String getWeatherInformation(
        @PathParam(PARAM_COUNTRY) String country,
        @QueryParam(PARAM_CITY) String city,
        @HeaderParam(PARAM_DEBUG) String debug
    );
}