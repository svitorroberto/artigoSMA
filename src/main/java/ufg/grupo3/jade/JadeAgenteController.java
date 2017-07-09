package ufg.grupo3.jade;

import java.util.HashMap;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import ufg.grupo3.controller.AgenteController;
import ufg.grupo3.entidade.AgentePoluidor;

public class JadeAgenteController {
	public static HashMap<Integer, Agent> agentesPoluidores = new HashMap<>();
	private static String IP_LOCALHOST = "192.168.1.8";
	private static String POLUIDOR_CLASS = "ufg.grupo3.entidade.AgentePoluidor";
	private static String LIMPADOR_CLASS = "ufg.grupo3.entidade.AgenteLimpador";
	static private Integer contador = 1;
	Runtime runtime = Runtime.instance();
	static ContainerController container;

	/**
	 * Instancia um novo AgentePoluidor e adiciona ele em um
	 * {@link java.util.Map} de agentes
	 * 
	 * @return {@link Agent}
	 * @throws StaleProxyException
	 */
	public Agent criarAgente(Boolean isPoluidor) throws StaleProxyException {
		AgentController ag;
		String nome = "sujador[" + contador + "]";
		
		if(isPoluidor){
			ag = container.createNewAgent(nome, POLUIDOR_CLASS, new Object[] {});
			contador++;
		} else {
			ag = container.createNewAgent("limpador", LIMPADOR_CLASS, new Object[] {});
		}

		ag.start();
		return new AgentePoluidor(nome);
	}

	/**
	 * Comunica com o controlador de agentes solicitando que destrua um Agente
	 * específico.
	 * 
	 * @param idAgente
	 * @return {@link Agent}
	 */
	public Agent destruirAgente(Long idAgente) {
		// TODO implementar a morte do agente
		return new AgentePoluidor("asdfasdfasd999999");
	}

	/**
	 * Comunica com o controlador de agentes solicitando que um certo
	 * AgentePoluidor envie uma mensagem para o AgenteLimpador e ele responda um
	 * Boolean.
	 * 
	 * @param idAgente
	 * @return {@link Boolean}
	 */
	public Boolean comunicarAgente(Long idAgente) {
		// TODO implementar a comunicação entre agentes
		Boolean isCooperativo = Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE;
		return isCooperativo;
	}

	/**
	 * Cria um container que vai ser usados pelos agentes sujadores
	 * 
	 * @param ip
	 * @return {@link Boolean}
	 */
	public Boolean criarContainer(String ip) {
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.CONTAINER_NAME, "Container-EcoCat");
		profile.setParameter(Profile.MAIN_HOST, ip);
		profile.setParameter(Profile.MAIN_PORT, "9999");
		// create a non-main agent container
		container = runtime.createAgentContainer(profile);
		return container != null ? Boolean.TRUE : Boolean.FALSE;
	}
}