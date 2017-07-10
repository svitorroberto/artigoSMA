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
import jade.wrapper.ControllerException;
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
	 * Destroi um AgentePoluidor pela descricao
	 * 
	 * @return {@link Response}
	 * @throws ControllerException 
	 * @throws FIPAException
	 */
	@DELETE
	@Path("/{descricao}")
	@Produces("application/json")
	public Response destroiAgente(@PathParam("descricao") String descricao) throws ControllerException{
		agenteController.destruirAgente(descricao);
		return Response.status(OK).build();
	}

	/**
	 * Faz a comunicação de um AgenteLimpador com o AgentePoluidor
	 * 
	 * @return {@link Boolean}
	 * @throws ControllerException 
	 * @throws InterruptedException 
	 */
	@GET
	@Path("/cooperacao/{descricao}")
	@Produces("application/json")
	public Response cooperacao(@PathParam("descricao") String descricaoAgente) throws ControllerException, InterruptedException {
		return Response.status(OK).entity(agenteController.comunicarAgente(descricaoAgente)).build();
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
	public Response container(@PathParam("ip") String ip) throws StaleProxyException {
		Boolean resultado = agenteController.criarContainer(ip);
		return resultado ? Response.status(CREATED).build() : Response.status(NOT_ACCEPTABLE).build();
	}
}