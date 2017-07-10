package ufg.grupo3.entidade;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import ufg.grupo3.Interacao;
import ufg.grupo3.behaviour.ConvencerPoluidorBehaviour;

/**
 * @author Vítor Roberto
 *
 */
public class AgenteLimpador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216313806774286L;
	private String descricao;

	public AgenteLimpador() {
		// TODO Auto-generated constructor stub
	}

	public AgenteLimpador(String id) {
		super();
		this.descricao = id;
	}

	@Override
	protected void setup() {
		System.out.println("Olá, sou o agente limpador " + getAID().getName() + " e estou pronto para limpar.");
		setEnabledO2ACommunication(true, 0);
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				Interacao info = (Interacao) myAgent.getO2AObject();
				if (info != null) {
					if (info.getMensagem() == "convencer") {
						convencer();
					}
				} else {
					block();
				}
			}
			
		});

	}

	protected void convencer() {
		addBehaviour(new ConvencerPoluidorBehaviour());

	}

	@Override
	protected void takeDown() {
		System.out.println("O agente limpador " + getAID().getName() + " não está mais entre nós.");
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
