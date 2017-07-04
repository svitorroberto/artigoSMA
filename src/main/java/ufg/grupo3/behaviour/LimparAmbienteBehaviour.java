package ufg.grupo3.behaviour;

import jade.core.behaviours.Behaviour;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.lang.acl.ACLMessage;
import ufg.grupo3.StatusEnum;
import ufg.grupo3.jade.JadeAgenteController;

public class LimparAmbienteBehaviour extends Behaviour {
	private StatusEnum status = StatusEnum.ANDAR;

	@Override
	public void action() {
		switch (status) {
		case ANDAR:
			action();
			break;
		case LIMPAR:
			tentarConvencerPoluidor();
			break;

		default:
			break;
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

	public void fazerLimpeza() {
		status = StatusEnum.LIMPAR;
	}

	private void tentarConvencerPoluidor() {
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Para de sujar");
		JadeAgenteController.agentesPoluidores.forEach((id,agente)->{
			msg.addReceiver(agente.getAID());
		});
//	    send(msg);
		status = StatusEnum.ANDAR;
}}
