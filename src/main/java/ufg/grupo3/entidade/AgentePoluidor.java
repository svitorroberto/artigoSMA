package ufg.grupo3.entidade;

import jade.core.AID;
import jade.core.Agent;
import ufg.grupo3.behaviour.PoluirAmbienteBehaviour;
import ufg.grupo3.jade.JadeAgenteController;

public class AgentePoluidor extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216311234574286L;
	private String id;

	@Override
	public void setup() {
		System.out.println("Olá, sou o agente poluidor " + getAID().getName() + " e estou pronto.");
		addBehaviour(new PoluirAmbienteBehaviour());

	}

	@Override
	public void takeDown() {
		System.out.println("O agente poluidor " + getAID().getName() + " não está mais entre nós.");
	}

	public AgentePoluidor() {
		// TODO Auto-generated constructor stub
	}

	public AgentePoluidor(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}