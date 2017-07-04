package ufg.grupo3.jade;

import java.util.HashMap;

import jade.core.Agent;
import ufg.grupo3.controller.AgenteController;
import ufg.grupo3.entidade.AgentePoluidor;

public class JadeAgenteController{
	public static HashMap<Integer, Agent> agentesPoluidores = new HashMap<>();
	private Integer contador = 1;

	/**
	 * Instancia um novo AgentePoluidor e adiciona ele 
	 * em um {@link java.util.Map} de agentes
	 * 
	 * @return {@link Agent}
	 */
	public Agent criarAgente(){
		Agent novoAgente = new AgentePoluidor("Agente sujador ["+contador+"]");
		agentesPoluidores.put(contador, novoAgente);
		contador++;
		return novoAgente;
	}
	
	/**
	 * Comunica com o controlador de agentes solicitando que 
	 * destrua um Agente específico.
	 * 
	 * @param idAgente
	 * @return {@link Agent}
	 */
	public Agent destruirAgente(Long idAgente){
		//TODO implementar a morte do agente
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
		//TODO implementar a comunicação entre agentes
		Boolean isCooperativo = Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE;
		return isCooperativo;
	}
}