package ufg.grupo3.entidade;

import java.util.ArrayList;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;
import ufg.grupo3.jade.JadeAgenteController;

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
	
	public AgenteLimpador(String id) {
		super();
		this.id = id;
	}
	
	@Override
	protected void setup() {
		System.out.println("Olá, sou o agente limpador " + getAID().getName() + " e estou pronto para limpar.");
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Para de sujar");
		/*
		JadeAgenteController.agentesPoluidores.forEach(item->{
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
	    */
	}
	
	@Override
	protected void takeDown() {
		System.out.println("O agente limpador " + getAID().getName() + " não está mais entre nós.");
	}
	
	public AgenteLimpador(){
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void recuperarInformacoesDoContainer() throws FIPAException{
		AMSAgentDescription [] agents = null;
		SearchConstraints c = new SearchConstraints();
        c.setMaxResults ( new Long(-1) );
        AID a = getAMS();
        agents = AMSService.search( this, new AMSAgentDescription (), c );
	}
}
