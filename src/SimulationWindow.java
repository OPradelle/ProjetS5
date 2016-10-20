import javax.swing.JFrame;

public class SimulationWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	public SimulationWindow()
	{
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public void startDisplaySimulation(DisplaySimulation displaySimulation)
	{
		this.setContentPane(displaySimulation);
		this.revalidate();
		this.repaint();
	}
}
