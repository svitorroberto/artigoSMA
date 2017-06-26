package ufg.grupo3.entidade;

import java.util.ArrayList;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import ufg.grupo3.jade.AgentController;

/**
 * @author Vítor Roberto
 *
 */
public class AgenteLimpador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450216313806774286L;
	private String id;
	
	AID aid = new AID("CAT", AID.ISLOCALNAME);
	
	@Override
	protected void setup() {
		System.out.println("Olá, sou o agente limpador " + getAID().getName() + " e estou pronto para limpar.");
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Para de sujar");
		AgentController.agentesPoluidores.forEach(item->{
			msg.addReceiver(item);
		});
	    send(msg);
	    
	    addBehaviour(new CyclicBehaviour(this) 
		{
			 public void action() {
				ACLMessage msg= receive();
				if (msg!=null){
					System.out.println( "== Answer" + " <- " +  msg.getContent() + " from " +  msg.getSender().getName() );
				}
				block();
			 }
		});
	}
	
	@Override
	protected void takeDown() {
		System.out.println("O agente limpador " + getAID().getName() + " não está mais entre nós.");
	}
	
	public AgenteLimpador(){
		// TODO Auto-generated constructor stub
	}

	public AID getAid() {
		return aid;
	}

	public void setAid(AID aid) {
		this.aid = aid;
	}
}
