package ufg.grupo3.entidade;

import jade.core.AID;
import jade.core.Agent;
import ufg.grupo3.behaviour.PoluirAmbienteBehaviour;
import ufg.grupo3.jade.AgentController;

public class AgenteSujador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216311234574286L;
	private String id;

	AID aid = new AID("Vitor", AID.ISLOCALNAME);

	@Override
	public void setup() {
		System.out.println("Olá, sou o agente sujador " + getAID().getName() + " e estou pronto.");
		AgentController.agentesPoluidores.add(getAid());
		addBehaviour(new PoluirAmbienteBehaviour());
		
	}

	@Override
	public void takeDown(){
		System.out.println("O agente sujador " + getAID().getName() + " não está mais entre nós.");
	}
	
	
	
	
	
	public AgenteSujador() {
		// TODO Auto-generated constructor stub
	}

	public AgenteSujador(String id) {
		this.id = id;
	}

	public AID getAid() {
		return aid;
	}

	public void setAid(AID aid) {
		this.aid = aid;
	}

}