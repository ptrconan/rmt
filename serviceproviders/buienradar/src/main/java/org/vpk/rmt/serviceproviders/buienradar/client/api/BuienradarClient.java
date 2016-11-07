package org.vpk.rmt.serviceproviders.buienradar.client.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;

/**
 * This is the endpoint to connect to the Buienradar client API.
 */
@Path(BuienradarClient.apiRootPath)
@Api(
    value = "Buienradar client API",
    description = "The Buienradar client API"
)
public interface BuienradarClient {

	final String apiRootPath = "/";
	
	/**
     *
     * Get the weather information as present in the XML feed from http://xml.buienradar.nl and transform it into a POJO.
     *
     * @param debug
     *  Flag to indicate if debug information is to be provided.
     *
     * @return
     *  The POJO representation of the weather information as present in the XML feed.
     *  
     * @since
     *  1.0.0
     */
    @GET
    @Path(BuienradarClient.apiRootPath)
    @ApiOperation(value = "Weather Information for NL", httpMethod = "GET", notes = "Get weather information for NL from http://xml.buienradar.nl", response = Buienradarnl.class)
    Buienradarnl getWeatherInformationNl();

}
