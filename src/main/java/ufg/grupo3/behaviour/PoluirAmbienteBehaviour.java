package ufg.grupo3.behaviour;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class PoluirAmbienteBehaviour extends CyclicBehaviour {

	private static final long serialVersionUID = -4005915218843721406L;
	private MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive(mt);
		if (msg != null) {
			System.out.println(" - " + myAgent.getLocalName() + " <- " + msg.getContent());
			ACLMessage reply = msg.createReply();
			int acl = Math.random() > 0.6 ? ACLMessage.REJECT_PROPOSAL : ACLMessage.ACCEPT_PROPOSAL;
			reply.setPerformative(acl);
			reply.setConversationId("meio-ambiente");
			reply.setContent("Resposta");
			myAgent.send(reply);
		}
	}

}
