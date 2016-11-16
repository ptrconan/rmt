package org.vpk.rmt.serviceproviders.buienradar.server.api;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.BuienradarServerException;

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

    String PATH_GET_WEERGEGEVENS          = "/nl/weergegevens";
    String PATH_GET_VERWACHTING_MEERDAAGS = "/nl/weergegevens/verwachtingMeerdaags";
    String PATH_GET_VERWACHTING_VANDAAG   = "/nl/weergegevens/verwachtingVandaag";
    String PATH_GET_ACTUEEL_WEER          = "/nl/weergegevens/actueel_weer";
    String PATH_GET_BUIENINDEX            = "/nl/weergegevens/actueel_weer/buienindex";
    String PATH_GET_BUIENRADAR            = "/nl/weergegevens/actueel_weer/buienradar";
    String PATH_GET_WEERSTATIONS          = "/nl/weergegevens/actueel_weer/weerstations";
    String PATH_GET_WEERSTATION           = "/nl/weergegevens/actueel_weer/weerstations/weerstation";


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
    @Path(PATH_GET_WEERGEGEVENS)
    @Produces(BuienradarServer.apiProduces)
    Weergegevens getWeerGegevens(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_VERWACHTING_MEERDAAGS)
    @Produces(BuienradarServer.apiProduces)
    VerwachtingMeerdaags getVerwachtingMeerdaags(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_VERWACHTING_VANDAAG)
    @Produces(BuienradarServer.apiProduces)
    VerwachtingVandaag getVerwachtingVandaag(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_ACTUEEL_WEER)
    @Produces(BuienradarServer.apiProduces)
    ActueelWeer getActueelWeer(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_BUIENINDEX)
    @Produces(BuienradarServer.apiProduces)
    Buienindex getBuienIndex(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_BUIENRADAR)
    @Produces(BuienradarServer.apiProduces)
    Buienradar getBuienRadar(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATIONS)
    @Produces(BuienradarServer.apiProduces)
    Weerstations getWeerStations(@HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATION + "/{id}")
    @Produces(BuienradarServer.apiProduces)
    Weerstation getWeerStationPathParamId(
            @PathParam("id") String id,
            @HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATION)
    @Produces(BuienradarServer.apiProduces)
    Weerstation getWeerStationQueryParam(
            @QueryParam("id") String id1,
            @QueryParam("stationcode") String id2,
            @HeaderParam(paramDebug) String debug) throws BuienradarServerException;
}
