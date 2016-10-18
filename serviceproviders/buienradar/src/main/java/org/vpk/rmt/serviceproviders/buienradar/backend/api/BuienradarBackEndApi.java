package org.vpk.rmt.serviceproviders.buienradar.backend.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This interface is the endpoint to connect to the buienradar back end.
 */
@Path(BuienradarBackEndApi.PATH_ROOT)
@Api(
    value = BuienradarBackEndApi.PATH_ROOT,
    description = "Rest API providing Buienradar back end services.",
    produces = BuienradarBackEndApi.CONTENT_TYPE_XML_UTF8
)
public interface BuienradarBackEndApi {
    String CONTENT_TYPE_XML_UTF8 = MediaType.APPLICATION_XML + "; charset=utf-8\"";

    // path constants
    String PATH_ROOT = "/";

    // parameter constants
    String PARAM_DEBUG = "debug";

    /**
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
    @Path(PATH_ROOT)
    @Produces(CONTENT_TYPE_XML_UTF8)
    @ApiOperation(value = PATH_ROOT, httpMethod = "GET", notes = "This will return the weather information for a country.", response = String.class)
    String getWeatherInformation(
        @HeaderParam(PARAM_DEBUG) String debug
    );

}
