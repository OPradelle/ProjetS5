import java.util.Random;

public class OneByOneAgentController extends AgentController 
{
	private Position initialPosition;
	private Random rand;

	public OneByOneAgentController()
	{
		this.numberOfMoves = 0;
		this.rand = new Random();
	}

	
	public void init(Agent agent)
	{
		this.initialPosition = new Position(agent.getPosition());
	}

	
	public void update(Agent agent, Map map)
	{
		if (agent.isMoving() && agent.getPosition().getDistance(this.initialPosition) < 1)
			return;

		if (!agent.isMoving())
			agent.setMoving(true);
		
		map.removePatch(agent.getPosition());
		this.numberOfMoves += 1;

		this.initialPosition = new Position(agent.getPosition());
		
		
		agent.setRotation(rand.nextInt(8)*45);
	}

}
