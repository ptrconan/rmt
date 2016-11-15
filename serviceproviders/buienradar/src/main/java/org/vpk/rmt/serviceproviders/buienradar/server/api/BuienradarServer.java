package org.vpk.rmt.serviceproviders.buienradar.server.api;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.ActueelWeer;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weergegevens;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstations;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;

/**
 * This is the endpoint to connect to the Buienradar server API.
 */

/**
* This Java class with be hosted in the URI path defined by the @Path annotation. @Path annotations on the methods
* of this class always refer to a path relative to the path defined at the class level.
* <p/>
* For example, with 'http://localhost:8181/cxf' as the default CXF servlet path and '/rmt' as the JAX-RS server path,
* this class will be hosted in 'http://localhost:8181/cxf/rmt/buienradar'.
* A @Path("/{station}") annotation on
* one of the methods would result in 'http://localhost:8181/cxf/rmt/buienradar/country'.
*/
@Path("/buienradar/")
@Api(
    value = "/",
    description = "The Buienradar server API"
)
public interface BuienradarServer {

    String apiProduces = MediaType.APPLICATION_JSON + "; charset=utf-8\"";
    String paramDebug = "debug";

    @GET
    @Path("/nl/{station}")
    @Produces(BuienradarServer.apiProduces)
//    @ApiOperation(value = "Get weather information", httpMethod = "GET", notes = "This will return the weather information for a country.", response = String.class)
//    @ApiResponses(value = { @ApiResponse(code = 500, message = "Invalid id supplied") })
    WeatherInformation getWeatherInformation(
//        @ApiParam(value = "The name of the weather station from which to fetch weather information.", required = true) @PathParam("station") String stationName,
        @PathParam("station") String stationName,
        @HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path("/nl/weergegevens")
    @Produces(BuienradarServer.apiProduces)
    Weergegevens getWeerGegevens(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path("/nl/weergegevens/actueel_weer")
    @Produces(BuienradarServer.apiProduces)
    ActueelWeer getActueelWeer(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path("/nl/weergegevens/actueel_weer/weerstations")
    @Produces(BuienradarServer.apiProduces)
    Weerstations getWeerStations(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path("/nl/weergegevens/actueel_weer/weerstations/weerstation/{id}")
    @Produces(BuienradarServer.apiProduces)
    Weerstation getWeerStation(
            @PathParam("id") String id,
            @HeaderParam(paramDebug) String debug) throws BuienradarServerException;
}
