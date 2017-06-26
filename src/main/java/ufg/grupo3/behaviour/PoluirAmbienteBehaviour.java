package ufg.grupo3.behaviour;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class PoluirAmbienteBehaviour extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4005915218843721406L;

	@Override
	public void action() {
		ACLMessage msg = receive();
		if (msg != null){
			System.out.println(" - " + myAgent.getLocalName() + " <- " + msg.getContent());
		}
		ACLMessage reply = msg.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent("Pong");
		reply.send();
	}

	block();

}
