package ufg.grupo3.behaviour;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ConvencerPoluidorBehaviour extends Behaviour {
	private static final long serialVersionUID = -4804661848356220501L;
	private MessageTemplate mt;
	private int step = 0;

	@Override
	public void action() {
		System.out.println("Olá, sou o agente limpador " + myAgent.getAID().getName() + " e vou convencer!");
		switch (step) {
		case 0:
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.addReceiver(new AID("poluidor01", AID.ISLOCALNAME));
			msg.setLanguage("Portuguese");
			msg.setPerformative(ACLMessage.PROPOSE);
			msg.setConversationId("meio-ambiente");
			msg.setContent("Quer cooperar com a limpeza do meio ambiente?");
			mt = MessageTemplate.MatchConversationId("meio-ambiente");
			myAgent.send(msg);
			
			step = 1;
			break;
		case 1:
			ACLMessage reply = myAgent.receive(mt);
			if (reply != null) {
				if(reply.getPerformative()==ACLMessage.ACCEPT_PROPOSAL){
					System.out.println("POLUIDOR FOI CONVENCIDO");
					step = 2;
				}else if (reply.getPerformative()==ACLMessage.REJECT_PROPOSAL){
					System.out.println("POLUIDOR NAO FOI CONVENCIDO");
					step = 2;
				}
			}else {
				block();
			}
			
		}

	}

	@Override
	public boolean done() {
		return step == 2;
	}

}
