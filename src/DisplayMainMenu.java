import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DisplayMainMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JButton launchButton;
	private volatile boolean choiceMade;

	public DisplayMainMenu()
	{
		this.launchButton = new JButton("Lancer");
		this.add(this.launchButton);
		this.launchButton.addActionListener(this);
		
		this.choiceMade = false;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.launchButton)
		{
			this.choiceMade = true;
		}
	}
	
	public void waitForAction()
	{
		this.choiceMade = false;
		
		while(!choiceMade)
		{
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		//return;
	}
}
