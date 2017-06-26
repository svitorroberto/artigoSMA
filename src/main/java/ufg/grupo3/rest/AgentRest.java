package ufg.grupo3.rest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ufg.grupo3.entidade.AgenteSujador;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("/agentes")
public class AgentRest {

	/**
	 *
	 * @return TrasherAgent
	 */
	@GET
	@Path("/criarAgente")
	@Produces("application/json")
	public Response criaAgente() {
		return Response.status(CREATED).entity( new AgenteSujador("asdfasdfasd999999") ).build();
	}
	
	/**
	 *
	 * @return Boolean
	 */
	@GET
	@Path("/cooperacao")
	@Produces("application/json")
	public Response cooperacao() {
		Boolean isCooperativo = Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE;
		return Response.status(CREATED).entity(isCooperativo).build();
	}

	/**
	 *
	 * @return String
	 */
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response destroiAgente(@PathParam("id") String idAgente) {

	    return Response.status(Response.Status.OK).build();
	}


	/**
	 *
	 * @return Boolean
	 */
	@PUT
	@Path("/criacao")
	@Produces("application/json")
	public Response criacao()  {
        return Response.status(200).entity(new AgenteSujador("asdfasdfasd999999")).build();
	}

	/**
	 *
	 * @return Boolean
	 */
	@POST
	@Path("/alteracao")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response alteracao(AgenteSujador agent)  {
        return Response.status(CREATED).entity( new AgenteSujador("qwer1234zxcv5678") ).build();
	}
}