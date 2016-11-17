package org.vpk.rmt.serviceproviders.buienradar.server.api;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataActualForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataExpectedNext;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataExpectedToday;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.BuienradarServerException;

import java.util.List;

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

    String PATH_GET_WEATHER_DATA_ACTUAL_FOR_REGION = "/nl/weatherdata/actual/region/{regionsCsv}";
    String PATH_GET_WEATHER_DATA_EXPECTED_TODAY    = "/nl/weatherdata/expected/today";
    String PATH_GET_WEATHER_DATA_EXPECTED_NEXT_N   = "/nl/weatherdata/expected/next/{nofDays}";

    @GET
    @Path("/nl/{station}")
    @Produces(BuienradarServer.apiProduces)
    WeatherInformation getWeatherInformation(
        @PathParam("station") String stationName,
        @HeaderParam(paramDebug) String debug) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEATHER_DATA_ACTUAL_FOR_REGION)
    @Produces(BuienradarServer.apiProduces)
    List<WeatherDataActualForRegion> getWeatherDataActualForRegion(@PathParam("regions") String regions) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEATHER_DATA_EXPECTED_TODAY)
    @Produces(BuienradarServer.apiProduces)
    WeatherDataExpectedToday getWeatherDataExpectedToday() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEATHER_DATA_EXPECTED_NEXT_N)
    @Produces(BuienradarServer.apiProduces)
    List<WeatherDataExpectedNext> getWeatherDataExpectedNext(@PathParam("nofDays") String nofDays) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERGEGEVENS)
    @Produces(BuienradarServer.apiProduces)
    Weergegevens getWeerGegevens() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_VERWACHTING_MEERDAAGS)
    @Produces(BuienradarServer.apiProduces)
    VerwachtingMeerdaags getVerwachtingMeerdaags() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_VERWACHTING_VANDAAG)
    @Produces(BuienradarServer.apiProduces)
    VerwachtingVandaag getVerwachtingVandaag() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_ACTUEEL_WEER)
    @Produces(BuienradarServer.apiProduces)
    ActueelWeer getActueelWeer() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_BUIENINDEX)
    @Produces(BuienradarServer.apiProduces)
    Buienindex getBuienIndex() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_BUIENRADAR)
    @Produces(BuienradarServer.apiProduces)
    Buienradar getBuienRadar() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATIONS)
    @Produces(BuienradarServer.apiProduces)
    Weerstations getWeerStations() throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATION + "/{id}")
    @Produces(BuienradarServer.apiProduces)
    Weerstation getWeerStationPathParamId(@PathParam("id") String id) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_WEERSTATION)
    @Produces(BuienradarServer.apiProduces)
    Weerstation getWeerStationQueryParam(
            @QueryParam("id") String id1,
            @QueryParam("stationcode") String id2) throws BuienradarServerException;
}
