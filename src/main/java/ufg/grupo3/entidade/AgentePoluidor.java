package ufg.grupo3.entidade;

import jade.core.Agent;
import ufg.grupo3.behaviour.PoluirAmbienteBehaviour;

public class AgentePoluidor extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216311234574286L;
	private String descricao;

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

	public AgentePoluidor(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}