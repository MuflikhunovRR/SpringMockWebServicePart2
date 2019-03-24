package ru.gotoqa.sp2.controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gotoqa.sp2.models.PhonesByCardNumberRq;
import ru.gotoqa.sp2.service.RequestManager;

/**
 * @author Muflikhunov Roman
 */
@Path("messages")
@Component
public class CardNumResource {
    private final RequestManager requestManager;

    @Autowired
    public CardNumResource(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRequest(PhonesByCardNumberRq cardNumberRq) {
        PhonesByCardNumberRq newMsg = requestManager.createRequest(cardNumberRq);
        return Response.status(Status.CREATED).entity(newMsg).build();
    }

    @PUT
    @Path("/{rqUid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRequest(@PathParam("rqUid") String rqUid, PhonesByCardNumberRq msg) {
        if (msg.getRqUid() != rqUid) {
            throw new IllegalArgumentException("Object id cannot be different than the parameter id");
        }
        if (requestManager.updateRequest(msg)) {
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{rqUid}")
    public Response deleteRequest(@PathParam("rqUid") String rqUid) {
        if (requestManager.deleteRequest(rqUid)) {
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{rqUid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRequest(@PathParam("rqUid") String rqUid) {
        PhonesByCardNumberRq msg = requestManager.getRequest(rqUid);
        if (msg != null) {
            return Response.status(Status.OK).entity(msg).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRequest() {
        Collection<PhonesByCardNumberRq> msgs = requestManager.getRequest();
        return Response.status(Status.OK).entity(msgs.toArray(new PhonesByCardNumberRq[msgs.size()])).build();
    }
}
