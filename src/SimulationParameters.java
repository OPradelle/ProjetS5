public class SimulationParameters
{

	private int agentNumber;
	private int sleepTime;
	private int movementType;
	private String filePath;

	public int getAgentNumber()
	{
		return agentNumber;
	}

	public void setAgentNumber(int agentNumber)
	{
		this.agentNumber = agentNumber;
	}

	public int getSleepTime()
	{
		return sleepTime;
	}

	public void setSleepTime(int sleepTime)
	{
		this.sleepTime = sleepTime;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public int getMovementType()
	{
		return movementType;
	}

	public void setMovementType(int movementType)
	{
		this.movementType = movementType;
	}

}
