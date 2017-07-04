package ufg.grupo3.controller;

import jade.core.Agent;
import ufg.grupo3.entidade.AgentePoluidor;
import ufg.grupo3.jade.JadeAgenteController;

public class AgenteController {
	
	JadeAgenteController jadeAgenteController = new JadeAgenteController();

	/**
	 * Comunica com o controlador de agentes solicitando que 
	 * crie um novo Agente.
	 * 
	 * @return {@link Agent}
	 */
	public Agent criarAgente(){
		return jadeAgenteController.criarAgente();
	}
	
	/**
	 * Comunica com o controlador de agentes solicitando que 
	 * destrua um Agente específico.
	 * 
	 * @param idAgente
	 * @return {@link Agent}
	 */
	public Agent destruirAgente(Long idAgente){
		return new AgentePoluidor("asdfasdfasd999999");
	}

	/**
	 * Comunica com o controlador de agentes solicitando que
	 * um certo AgentePoluidor envie uma mensagem para o 
	 * AgenteLimpador e ele responda um Boolean.
	 * 
	 * @param idAgente
	 * @return {@link Boolean}
	 */
	public Boolean comunicarAgente(Long idAgente){
		return jadeAgenteController.comunicarAgente(idAgente);
	}
}
