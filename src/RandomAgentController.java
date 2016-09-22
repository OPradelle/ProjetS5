import java.util.Random;

public class RandomAgentController implements AgentController
{
	private Position nextTarget;
	private Random rand;
	
	public RandomAgentController()
	{
		this.rand = new Random();
		
		this.nextTarget = new Position(0, 0);
	}

	@Override
	public void init(Agent agent)
	{
		agent.setMoving(true);
	}

	@Override
	public void update(Agent agent, Map map)
	{
		if (!(agent.getPosition().equals(this.nextTarget)))
			return;
		
		System.out.println("update");

		Position fictionPositionPoint;
		float angle, sideA, sideB, sideC, a2, b2, c2;

		setNewRandomTarget(map);
		System.out.println(this.nextTarget);

		fictionPositionPoint = new Position(agent.getPosition().getX() + 100, agent.getPosition().getY());

		// On calcule la dictance entre chacun des points pour déterminer
		// l'angle
		sideA = agent.getPosition().getDistance(fictionPositionPoint);
		sideB = agent.getPosition().getDistance(this.nextTarget);
		sideC = fictionPositionPoint.getDistance(this.nextTarget);

		// Calcul de l'angle
		a2 = (float) Math.pow(sideA, 2);
		b2 = (float) Math.pow(sideB, 2);
		c2 = (float) Math.pow(sideC, 2);

		angle = (float) Math.acos((a2 + b2 - c2) / (2 * sideA * sideB));
		
		agent.setRotation((float)Math.toDegrees(angle));
		System.out.println((float)Math.toDegrees(angle));
	}

	private void setNewRandomTarget(Map map)
	{
		int x, y;
		x = rand.nextInt(map.getWidth());
		y = rand.nextInt(map.getHeight());

		this.nextTarget = new Position(x, y);
	}
	
	
}
