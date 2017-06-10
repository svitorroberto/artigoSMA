package ufg.grupo3.rest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ufg.grupo3.entidade.Agente;

@Path("/agentes")
public class AgenteRest {

	/**
	 * 
	 * @return Agente
	 */
	@GET
	@Path("/criarAgente")
	@Produces("application/json")
	public Agente criarAgente() {
		return new Agente("qwer1234zxcv5678");
	}
	
	/**
	 * 
	 * @return String
	 */
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public String destruirAgente(@PathParam("id") String idAgente) {
		return "Agente destruido com sucesso";
	}
	
	/**
	 * 
	 * @return Boolean
	 */
	@GET
	@Path("/decidirCooperacao")
	@Produces("application/json")
	public Boolean decidirCooperacao(@PathParam("id") String idAgente) {
		return Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE;
	}
}