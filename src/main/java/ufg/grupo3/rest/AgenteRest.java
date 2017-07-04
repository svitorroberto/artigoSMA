package ufg.grupo3.rest;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE;

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

import org.codehaus.jackson.map.annotate.JacksonInject;

import jade.core.Agent;
import ufg.grupo3.controller.AgenteController;
import ufg.grupo3.entidade.AgentePoluidor;

@Path("/agentes")
public class AgenteRest {
	AgenteController agenteController = new AgenteController();
	
	/**
	 * Cria um novo AgentePoluidor
	 * @return {@link Response}
	 */
	@PUT
	@Path("/criacao")
	@Produces("application/json")
	public Response criacao()  {
		Agent a = agenteController.criarAgente();
		return Response.status(CREATED).entity(a).build();
	}
	
	/**
	 * Destroi um AgentePoluidor pelo ID
	 * @return {@link Response}
	 */
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response destroiAgente(@PathParam("id") Long idAgente) {
		Agent destruido = agenteController.destruirAgente(idAgente);
		return (destruido == null) ? Response.status(NOT_ACCEPTABLE).build() : Response.status(OK).entity(destruido).build();
	}
	
	/**
	 * Faz a comunicação de um AgentePoluidor com o AgenteLimpador
	 * @return {@link Boolean}
	 */
	@GET
	@Path("/cooperacao/{id}")
	@Produces("application/json")
	public Response cooperacao(@PathParam("id") Long idAgente) {
		agenteController.comunicarAgente(idAgente);
		return Response.status(OK).entity(agenteController.comunicarAgente(idAgente)).build();
	}
}