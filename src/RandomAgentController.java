import java.util.Random;

public class RandomAgentController extends AgentController
{
	private Position initialPosition;
	private Random rand;
	private float distance;

	public RandomAgentController()
	{
		this.rand = new Random();
		this.distance = 0;
		this.numberOfMoves = 0;
	}

	@Override
	public void init(Agent agent)
	{
		this.initialPosition = new Position(agent.getPosition());
	}

	@Override
	public void update(Agent agent, Map map)
	{
		// Si l'agent ne bouge pas, on le met a jour ( pas de paresseux chez les
		// agents ! )
		if (agent.isMoving() && agent.getPosition().getDistance(this.initialPosition) < distance)
			return;

		if (!agent.isMoving())
			agent.setMoving(true);
		
		map.removePatch(agent.getPosition());
		this.numberOfMoves += 1;

		this.initialPosition = new Position(agent.getPosition());
		do
		{
			agent.setRotation(rand.nextFloat() * 359);
			this.distance = rand.nextFloat()
					* distanceToMapBorder(new Position(agent.getPosition()), agent.getRotation(), map);

		} while (this.distance <= 1); // On bouge au moins de 1
	}

	/*
	 * Fait avancer une position temporaire jusqu'� la fin de la map et retourne
	 * la distance qu'elle a parcourue
	 */
	private float distanceToMapBorder(Position pos, float rotation, Map map)
	{
		Position tempPos = new Position(pos);

		while (tempPos.getX() >= 0 && tempPos.getX() < map.getWidth() && tempPos.getY() >= 0
				&& tempPos.getY() < map.getHeight())
		{
			float deltaX = (float) Math.cos(Math.toRadians(rotation));
			float deltaY = (float) Math.sin(Math.toRadians(rotation));
			tempPos.move(deltaX, deltaY);
		}

		return pos.getDistance(tempPos);
	}
}
