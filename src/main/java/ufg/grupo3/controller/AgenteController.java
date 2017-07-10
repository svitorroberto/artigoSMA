package ufg.grupo3.controller;

import jade.core.Agent;
import jade.domain.FIPAException;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import ufg.grupo3.jade.JadeAgenteController;

public class AgenteController {
	
	JadeAgenteController jadeAgenteController = new JadeAgenteController();

	/**
	 * Comunica com o controlador de agentes solicitando que 
	 * crie um novo Agente.
	 * 
	 * @return {@link Agent}
	 * @throws StaleProxyException 
	 */
	public Agent criarAgentePoluidor() throws StaleProxyException{
		return jadeAgenteController.criarAgente(Boolean.TRUE);
	}
	
	/**
	 * Comunica com o controlador de agentes solicitando que 
	 * destrua um Agente específico.
	 * 
	 * @param idAgente
	 * @return {@link Agent}
	 * @throws FIPAException 
	 * @throws ControllerException 
	 */
	public void destruirAgente(String descricaoAgente) throws ControllerException{
		jadeAgenteController.destruirAgente(descricaoAgente);
	}

	/**
	 * Comunica com o controlador de agentes solicitando que
	 * um certo AgentePoluidor envie uma mensagem para o 
	 * AgenteLimpador e ele responda um Boolean.
	 * 
	 * @param idAgente
	 * @return {@link Boolean}
	 * @throws ControllerException 
	 * @throws InterruptedException 
	 */
	public Boolean comunicarAgente(String descricaoAgente) throws ControllerException, InterruptedException{
		return jadeAgenteController.comunicarAgente(descricaoAgente);
	}
	
	/**
	 * Cria um container que vai ser usados pelos agentes sujadores
	 * 
	 * @param ip
	 * @return {@link Boolean}
	 * @throws StaleProxyException 
	 */
	public Boolean criarContainer(String ip) throws StaleProxyException {
		Boolean resultado = jadeAgenteController.criarContainer(ip);
		jadeAgenteController.criarAgente(Boolean.FALSE);
		return resultado;
	}
	
}
