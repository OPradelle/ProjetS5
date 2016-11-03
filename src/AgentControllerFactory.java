public class AgentControllerFactory 
{
	public AgentController factoryMethod(int type)
	{
		switch(type)
		{
			case 0: return new RandomAgentController();
			case 1: return new LessRandomAgentController();
			case 2: return new LevyAgentController();
			
			default : return null;
		}
	}

}
