package ufg.grupo3.controller;

import java.io.IOException;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.domain.AMSService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.wrapper.StaleProxyException;
import ufg.grupo3.entidade.AgenteLimpador;
import ufg.grupo3.entidade.AgentePoluidor;
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
	 */
	public Agent destruirAgente(Long idAgente) throws FIPAException{
		AgenteLimpador a = new AgenteLimpador("asdfasdfasd999999");
		a.recuperarInformacoesDoContainer();
		return a;
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
	
	public void iniciarAplicacao() throws IOException{
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("java jade.Boot -gui -agents limpador:ufg.grupo3.entidade.AgenteLimpador -port 9999");
		System.out.println(pr.getOutputStream());
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
