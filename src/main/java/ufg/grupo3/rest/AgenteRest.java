package ufg.grupo3.rest;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE;
import static javax.ws.rs.core.Response.Status.OK;

import java.io.IOException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import jade.core.Agent;
import jade.domain.FIPAException;
import jade.wrapper.StaleProxyException;
import ufg.grupo3.controller.AgenteController;

@Path("/agentes")
public class AgenteRest {
	AgenteController agenteController = new AgenteController();

	/**
	 * Cria um novo AgentePoluidor
	 * 
	 * @return {@link Response}
	 * @throws StaleProxyException
	 */
	@PUT
	@Path("/criacao")
	@Produces("application/json")
	public Response criacao() throws StaleProxyException {
		Agent a = agenteController.criarAgentePoluidor();
		return Response.status(CREATED).entity(a).build();
	}

	/**
	 * Destroi um AgentePoluidor pelo ID
	 * 
	 * @return {@link Response}
	 * @throws FIPAException
	 */
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response destroiAgente(@PathParam("id") Long idAgente) throws FIPAException {
		Agent destruido = agenteController.destruirAgente(idAgente);
		return (destruido == null) ? Response.status(NOT_ACCEPTABLE).build()
				: Response.status(OK).entity(destruido).build();
	}

	/**
	 * Faz a comunicação de um AgentePoluidor com o AgenteLimpador
	 * 
	 * @return {@link Boolean}
	 */
	@GET
	@Path("/cooperacao/{id}")
	@Produces("application/json")
	public Response cooperacao(@PathParam("id") Long idAgente) {
		agenteController.comunicarAgente(idAgente);
		return Response.status(OK).entity(agenteController.comunicarAgente(idAgente)).build();
	}

	/**
	 * Faz a criacao do container
	 * 
	 * @return {@link Boolean}
	 * @throws IOException
	 * @throws StaleProxyException
	 */
	@PUT
	@Path("/container/{ip}")
	@Produces("application/json")
	public Response container(@PathParam("ip") String ip) throws IOException, StaleProxyException {
		Boolean resultado = agenteController.criarContainer(ip);
		return resultado ? Response.status(CREATED).build() : Response.status(NOT_ACCEPTABLE).build();
	}
}