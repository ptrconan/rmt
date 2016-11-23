package org.vpk.rmt.serviceproviders.buienradar.server.api;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.BuienradarServerException;

import java.util.List;

@Path("/buienradar/")
@Api(
    value = "/",
    description = "The Buienradar server API"
)
public interface BuienradarServer {

    String apiProduces = MediaType.APPLICATION_JSON + "; charset=utf-8\"";

    String PATH_GET_ACTUAL_WEATHER_DATA_FOR_REGION = "/nl/weatherdata/actual/region/{regionsCsv}";
    String PATH_GET_TODAYS_EXPECTED_WEATHER_DATA = "/nl/weatherdata/expected/today";
    String PATH_GET_NEXT_N_EXPECTED_WEATHER_DATA = "/nl/weatherdata/expected/next/{nofDays}";

    @GET
    @Path(PATH_GET_ACTUAL_WEATHER_DATA_FOR_REGION)
    @Produces(BuienradarServer.apiProduces)
    List<ActualWeatherDataForRegion> getActualWeatherDataForRegion(@PathParam("regionsCsv") String regionsCsv) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_NEXT_N_EXPECTED_WEATHER_DATA)
    @Produces(BuienradarServer.apiProduces)
    List<NextExpectedWeatherData> getNextExpectedWeatherData(@PathParam("nofDays") String nofDays) throws BuienradarServerException;

    @GET
    @Path(PATH_GET_TODAYS_EXPECTED_WEATHER_DATA)
    @Produces(BuienradarServer.apiProduces)
    TodaysExpectedWeatherData getTodaysExpectedWeatherData() throws BuienradarServerException;
}
