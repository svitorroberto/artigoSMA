package ufg.grupo3.entidade;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgentePoluidor extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216311234574286L;
	private String descricao;
	private MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);

	@Override
	public void setup() {
		System.out.println("Olá, sou o agente poluidor " + getAID().getName() + " e estou pronto.");
		setEnabledO2ACommunication(true, 0);
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = myAgent.receive(mt);
				if (msg != null) {
					System.out.println(" - " + myAgent.getLocalName() + " <- " + msg.getContent());
					ACLMessage reply = msg.createReply();
					int acl = Math.random() > 0.3 ? ACLMessage.REJECT_PROPOSAL : ACLMessage.ACCEPT_PROPOSAL;
					reply.setPerformative(acl);
					reply.setConversationId("meio-ambiente");
					reply.setContent("Resposta");
					myAgent.send(reply);
				}
				 else {
					block();
				}
			}
			
		});

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