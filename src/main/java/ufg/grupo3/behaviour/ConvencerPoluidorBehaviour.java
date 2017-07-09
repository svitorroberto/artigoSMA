package ufg.grupo3.behaviour;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ConvencerPoluidorBehaviour extends Behaviour{
	
	@Override
	public void action() {
		
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("sujador[1]", AID.ISLOCALNAME));
		msg.setLanguage("Portuguese");
		msg.setOntology("Weather-forecast-ontology");
		msg.setPerformative(ACLMessage.PROPOSE);
		msg.setContent("Para de sujar");
		myAgent.send(msg);
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
