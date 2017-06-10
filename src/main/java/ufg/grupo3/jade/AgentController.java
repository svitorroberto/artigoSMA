package ufg.grupo3.jade;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

public class AgentController extends Agent{
	
	protected void setup() 
    {
        addBehaviour( new myBehaviour( this ) );
    }
    
    
    class myBehaviour extends SimpleBehaviour
    {   
        public myBehaviour(Agent a) { 
            super(a);  
        }
        
        public void action() 
        {
           //...this is where the real programming goes !!
        }
        
        private boolean finished = false;
        
        public boolean done() {  
            return finished;  
        }
        
    } // ----------- End myBehaviour
    
}//end class AgentController
