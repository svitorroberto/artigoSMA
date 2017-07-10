package ufg.grupo3.entidade;

import jade.core.Agent;
import ufg.grupo3.behaviour.LimparAmbienteBehaviour;

/**
 * @author V�tor Roberto
 *
 */
public class AgenteLimpador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216313806774286L;
	private String descricao;
	
	public AgenteLimpador(){
		// TODO Auto-generated constructor stub
	}
	
	public AgenteLimpador(String id) {
		super();
		this.descricao = id;
	}
	
	@Override
	protected void setup() {
		System.out.println("Ol�, sou o agente limpador " + getAID().getName() + " e estou pronto para limpar.");
		
		addBehaviour(new LimparAmbienteBehaviour());

	}
	
	@Override
	protected void takeDown() {
		System.out.println("O agente limpador " + getAID().getName() + " n�o est� mais entre n�s.");
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
