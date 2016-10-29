package org.vpk.rmt.serviceproviders.buienradar.client.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;

/**
 * This interface is the endpoint to connect to the buienradar client services.
 */
@Path(BuienradarClient.PATH_ROOT)
@Api(
    value = BuienradarClient.PATH_ROOT,
    description = "Rest API providing Buienradar client services.",
    produces = BuienradarClient.CONTENT_TYPE_XML_UTF8
)
public interface BuienradarClient {
    String CONTENT_TYPE_XML_UTF8 = MediaType.TEXT_XML + "; charset=utf-8\"";

    // path constants
    String PATH_ROOT = "/";

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
    @ApiOperation(value = PATH_ROOT, httpMethod = "GET", notes = "This will return the weather information for a country.", response = Buienradarnl.class)
    Buienradarnl getWeatherInformation();

}
