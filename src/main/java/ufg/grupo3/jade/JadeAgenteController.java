package ufg.grupo3.jade;

import java.util.HashMap;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import ufg.grupo3.Interacao;
import ufg.grupo3.entidade.AgentePoluidor;

public class JadeAgenteController {
	public static HashMap<Integer, Agent> agentesPoluidores = new HashMap<>();
	private static String POLUIDOR_CLASS = "ufg.grupo3.entidade.AgentePoluidor";
	private static String LIMPADOR_CLASS = "ufg.grupo3.entidade.AgenteLimpador";
	private static String AGENTE_LIMPADOR = "limpador";
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
		String descricao = "poluidor0" + contador;

		if (isPoluidor) {
			ag = container.createNewAgent(descricao, POLUIDOR_CLASS, new Object[] {});
			contador++;
		} else {
			ag = container.createNewAgent("limpador", LIMPADOR_CLASS, new Object[] {});
		}

		ag.start();
		return new AgentePoluidor(descricao);
	}

	/**
	 * Comunica com o controlador de agentes solicitando que destrua um Agente
	 * específico.
	 * 
	 * @param idAgente
	 * @return {@link Agent}
	 * @throws ControllerException
	 */
	public void destruirAgente(String nomeAgente) throws ControllerException {
		AgentController agente = container.getAgent(nomeAgente);
		agente.kill();
	}

	/**
	 * Comunica com o controlador de agentes solicitando que um certo
	 * AgentePoluidor envie uma mensagem para o AgenteLimpador e ele responda um
	 * Boolean.
	 * 
	 * @param idAgente
	 * @return {@link Boolean}
	 * @throws ControllerException
	 * @throws InterruptedException 
	 */
	public Boolean comunicarAgente(String nomeAgente) throws ControllerException, InterruptedException {
		Boolean isCooperativo = Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE;
		AgentController agente = container.getAgent(AGENTE_LIMPADOR);
		agente.putO2AObject(new Interacao("convencer"), true);
//		AgenteLimpador al = agente.getO2AInterface(AgenteLimpador.class);
//		Interacao o = (Interacao) al.getO2AObject();
		return Boolean.FALSE;
	}

	/**
	 * Cria um container que vai ser usados pelos agentes sujadores.
	 * 
	 * @param ip (ip local da maquina)
	 * @return {@link Boolean}
	 */
	public Boolean criarContainer(String ip) {
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.CONTAINER_NAME, "Container-EcoCat");
		profile.setParameter(Profile.MAIN_HOST, ip);
		profile.setParameter(Profile.MAIN_PORT, "9999");
		// cria um container nao principal
		container = runtime.createAgentContainer(profile);

		return container != null ? Boolean.TRUE : Boolean.FALSE;
	}
}