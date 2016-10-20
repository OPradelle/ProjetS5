import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DisplayMainMenu extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;

	private JButton launchButton;
	private boolean choiceMade;
	private JPanel contentPane;
	
	public DisplayMainMenu()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApplication = new JLabel("Application Name");
		lblApplication.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApplication.setBounds(208, 11, 184, 25);
		contentPane.add(lblApplication);
		
		JLabel lblTypeDeDplacment = new JLabel("Nombre d'agents");
		lblTypeDeDplacment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeDeDplacment.setBounds(37, 167, 191, 25);
		contentPane.add(lblTypeDeDplacment);
		
		JLabel label = new JLabel("Type de d\u00E9placement");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(37, 107, 191, 25);
		contentPane.add(label);
		
		JLabel lblFichierTexteDe = new JLabel("Fichier texte de la carte");
		lblFichierTexteDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFichierTexteDe.setBounds(37, 259, 191, 25);
		contentPane.add(lblFichierTexteDe);
		
		JLabel lblTempsDattenteen = new JLabel("Temps d'attente (en ms)");
		lblTempsDattenteen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempsDattenteen.setBounds(37, 338, 191, 25);
		contentPane.add(lblTempsDattenteen);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(321, 171, 131, 20);
		contentPane.add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(321, 111, 131, 20);
		contentPane.add(comboBox);
		
		JButton btnParcourir = new JButton("Parcourir ...");
		btnParcourir.setBounds(321, 262, 89, 23);
		contentPane.add(btnParcourir);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(321, 342, 131, 20);
		contentPane.add(spinner_1);
		
		this.launchButton = new JButton("Lancer la simulation");
		this.launchButton.setBounds(209, 470, 164, 25);
		this.launchButton.addActionListener(this);
		contentPane.add(this.launchButton);
		
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

		while (!choiceMade)
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
	}
}
