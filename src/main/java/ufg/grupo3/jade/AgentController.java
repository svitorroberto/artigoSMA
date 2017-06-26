package ufg.grupo3.jade;

import java.util.ArrayList;

import jade.core.AID;
import jade.core.Agent;
import jade.core.AgentContainer;
import jade.core.ContainerMonitorAgent;
import jade.core.behaviours.SimpleBehaviour;
import jade.wrapper.ContainerController;
import jade.wrapper.ContainerProxy;
import ufg.grupo3.entidade.AgenteSujador;

public class AgentController extends ContainerMonitorAgent{
	public static ArrayList<AID> agentesPoluidores = new ArrayList<>();

	
/*	ContainerController cc = getContainerController();
	AgentController ac = cc.createNewAgent("TESTE", "AgenteSujador", null);
	ac.start();
    */
}