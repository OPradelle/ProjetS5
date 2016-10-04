import java.util.Random;

public class LevyAgentController implements AgentController
{
	private static final int M_NUMBER = 100;
	private Position initialPosition;
	private Random rand;
	private float distance;

	public LevyAgentController()
	{
		this.rand = new Random();
		this.distance = 0;
	}

	@Override
	public void init(Agent agent)
	{
		this.initialPosition = new Position(agent.getPosition());
	}

	@Override
	public void update(Agent agent, Map map)
	{
		if (agent.isMoving() && agent.getPosition().getDistance(this.initialPosition) < distance)
			return;

		if (!agent.isMoving())
			agent.setMoving(true);

		this.initialPosition = new Position(agent.getPosition());
		do
		{
			agent.setRotation(rand.nextFloat() * 359);
			this.distance = Math.abs(generateNewDistance());

		} while (this.distance <= 1); // On bouge au moins de 1
	}

	private float generateNewDistance()
	{
		double sum = 0;
		double alpha = 1;

		for (int i = 0; i < M_NUMBER; i++)
		{
			double a = this.rand.nextGaussian();
			double b = this.rand.nextGaussian();

			sum += a / Math.pow(Math.abs(b), 1 / alpha);
		}

		return (float) ((1 / (Math.pow(M_NUMBER, 1 / alpha))) * sum);
	}
}
