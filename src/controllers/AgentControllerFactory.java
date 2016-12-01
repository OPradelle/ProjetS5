package controllers;

public class AgentControllerFactory 
{
	public AgentController factoryMethod(int type)
	{
		switch(type)
		{
			case 0: return new RandomAgentController();
			case 1: return new LessRandomAgentController();
			case 2: return new LevyAgentController();
			case 3: return new OneByOneAgentController();
			case 4: return new BreadthFirstAgentContoller();
			case 5: return new CaseMarkerAgentController();
			case 6: return new SharedCaseMarkerAgentController();
			
			default : return null;
		}
	}

}
