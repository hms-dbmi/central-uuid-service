package edu.harvard.childrens.rc.uuid.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.childrens.rc.uuid.data.UUIDMappingRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

/**
 * <p>REST Service for retrieving UUIDs</p>
 */
@Api
@Path("/")
public class UUIDMappingService {

    Logger logger = LoggerFactory.getLogger(UUIDMappingService.class);

    @Context
    SecurityContext securityContext;

    @Inject
    UUIDMappingRepository userRepo;

    public UUIDMappingService() {
		logger.info("UUID Mapping Service Intialized");
    }

    @ApiOperation(value = "GET a random UUID")
    @GET
    @Path("/random")
    public Response getRandomUUID(
            @ApiParam(required = true, value="Some id you want mapped, not that we remember at this point.")
            @PathParam("someId") String someId) {
        return Response.ok(UUID.randomUUID().toString()).build();
    }

}
