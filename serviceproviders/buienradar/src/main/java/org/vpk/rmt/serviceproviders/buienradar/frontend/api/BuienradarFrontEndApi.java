package org.vpk.rmt.serviceproviders.buienradar.frontend.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This interface is the endpoint to connect to the buienradar front end.
 */

/**
* This Java class with be hosted in the URI path defined by the @Path annotation. @Path annotations on the methods
* of this class always refer to a path relative to the path defined at the class level.
* <p/>
* For example, with 'http://localhost:8181/cxf' as the default CXF servlet path and '/rmt' as the JAX-RS server path,
* this class will be hosted in 'http://localhost:8181/cxf/rmt/buienradar'.  An @Path("/country") annotation on
* one of the methods would result in 'http://localhost:8181/cxf/rmt/buienradar/country'.
*/
@Path("/buienradar/")
@Api(value = "/buienradar", description = "Operations about buienradar")
public interface BuienradarFrontEndApi {
  final String CONTENT_TYPE_XML_UTF8 = MediaType.APPLICATION_XML + "; charset=utf-8\"";

  // path constants
  final String PATH_ROOT = "<blueprint2/>";

  // parameter constants
  final String PARAM_DEBUG = "debug";


  @GET
  @Path("/country/{id}")
  @Produces(CONTENT_TYPE_XML_UTF8)
  @ApiOperation(value = "Get weather information", httpMethod = "GET", notes = "This will return the weather information for a country.", response = String.class)
  @ApiResponses(value = {
  		@ApiResponse(code = 500, message = "Invalid id supplied")
  		})
  public String getWeatherInformation(@ApiParam(value = "ID of country to fetch", required = true) @PathParam("id") String id, @HeaderParam(PARAM_DEBUG) String debug);
	
}
