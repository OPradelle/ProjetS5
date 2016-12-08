package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controllers.AgentControllerFactory;
import display.DisplaySimulation;
import display.GUIManager;

public class Application
{
	private GUIManager guiManager;
	private Random rand;
	private AgentControllerFactory factory;
	
	public Application(GUIManager guiManager)
	{
		this.guiManager = guiManager;
		this.rand = new Random();
		this.factory = new AgentControllerFactory();
	}

	public void start()
	{
		do
		{
			SimulationParameters simulation;
			simulation = this.guiManager.getDisplayMainMenu().waitForAction();
			
			if(simulation != null)
				startSimulation(simulation);
		} while(true);
	}
	
	public void startSimulation(SimulationParameters simulation)
	{
        List<Integer> results = new ArrayList<Integer>();
        for (int k = 0; k < 50; k++)
        {
            Map map = new Map();
            map.readFromFile(simulation.getFilePath());
            List<Agent> agents = new ArrayList<Agent>();
            for (int i = 0; i < simulation.getAgentNumber(); i++)
            {
                agents.add(new Agent());
                agents.get(i).setAgentController(factory.factoryMethod(simulation.getMovementType()));
                agents.get(i).setPosition(new Position(this.rand.nextInt(map.getWidth()), this.rand.nextInt(map.getHeight())));
            }

            this.guiManager.getSimulationWindow().startDisplaySimulation(new DisplaySimulation(map, agents));
            this.guiManager.showSimulationWindow();

            while (map.patchNumberLeft() > 0 && this.guiManager.getSimulationWindow().isVisible())
            {
                for (Agent agent : agents)
                {
                    agent.update(map);
                }

                this.guiManager.getSimulationWindow().repaint();

                try
                {
                    Thread.sleep(simulation.getSleepTime());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            if (map.patchNumberLeft() == 0)
            {
                int numberOfRound = 0;
                for (Agent agent : agents)
                {
                    numberOfRound += agent.getAgentController().getNumberOfMoves();
                }

                //this.guiManager.showResult(numberOfRound / agents.size());
                results.add(numberOfRound);
            }
        }
        
        for (Integer integer : results)
        {
            System.out.println(integer);
        }
        //this.guiManager.hideimulationWindow();
	}
}
