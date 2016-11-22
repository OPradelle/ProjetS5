import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DisplayMapGenerator extends JFrame implements ActionListener
{
	private JCheckBox chckbxFaireDesAmats;
	private JButton btnEnregistrer;
	private JSpinner spinnerSizeAmats;
	private JSpinner spinnerAmatsNumber;
	private JSpinner spinnerMapSize;
	
	private JSlider slider1;
	private JSlider slider2;
	
	private JLabel lblProportionDePatchs;
	private JLabel lblProportionDePatchs_1;
	private JLabel lblNombreDeGroupes;
	private JLabel lblDansChaqueGroupe;
	private JLabel lblNombreDePatchs;
	private JLabel lblPourcent2;
	private JLabel lblPourcent1;
	private JLabel lblMapSize;
	private JLabel lblGnrerUneCarte;
	
	private JFileChooser fileChooser;
	private String filePath;

	
	
	public DisplayMapGenerator() 
	{
		fileChooser = new JFileChooser();
		
		setBounds(100, 100, 430, 440);
		getContentPane().setLayout(null);
		
		labelCreation();
		
		this.chckbxFaireDesAmats = new JCheckBox("Faire des amats de patchs");
		this.chckbxFaireDesAmats.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.chckbxFaireDesAmats.setBounds(33, 166, 222, 23);
		this.chckbxFaireDesAmats.addActionListener(this);
		getContentPane().add(this.chckbxFaireDesAmats);
		
		this.spinnerAmatsNumber = new JSpinner();
		this.spinnerAmatsNumber.setBounds(160, 196, 83, 20);
		getContentPane().add(this.spinnerAmatsNumber);
		
		this.slider1 = new JSlider();
		this.slider1.setBounds(188, 107, 165, 26);
		this.slider1.addChangeListener(new ChangeListener() 
		{
	      public void stateChanged(ChangeEvent e) 
	      {
	    	  int value = slider1.getValue();
	    	  lblPourcent1.setText(value + " %");
	      }
	    });
		getContentPane().add(this.slider1);
		
		this.spinnerMapSize = new JSpinner();
		this.spinnerMapSize.setBounds(160, 63, 83, 20);
		getContentPane().add(this.spinnerMapSize);
		
		this.slider2 = new JSlider();
		this.slider2.setBounds(188, 305, 165, 26);
		this.slider2.addChangeListener(new ChangeListener() 
		{
	      public void stateChanged(ChangeEvent e) 
	      {
	    	  int value = slider2.getValue();
	    	  lblPourcent2.setText(value + " %");
	      }
	    });
		getContentPane().add(this.slider2);
		
		this.btnEnregistrer = new JButton("Enregistrer");
		this.btnEnregistrer.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.btnEnregistrer.setBounds(128, 357, 165, 23);
		this.btnEnregistrer.addActionListener(this);
		getContentPane().add(this.btnEnregistrer);
		
		this.spinnerSizeAmats = new JSpinner();
		this.spinnerSizeAmats.setBounds(160, 245, 83, 20);
		getContentPane().add(this.spinnerSizeAmats);
		
		this.lblGnrerUneCarte = new JLabel("G\u00E9n\u00E9rer une carte");
		this.lblGnrerUneCarte.setFont(new Font("Dialog", Font.BOLD, 20));
		this.lblGnrerUneCarte.setBounds(110, 11, 183, 28);
		getContentPane().add(this.lblGnrerUneCarte);
		
		this.lblPourcent1 = new JLabel("50 %");
		this.lblPourcent1.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblPourcent1.setBounds(363, 110, 51, 20);
		getContentPane().add(this.lblPourcent1);
		
		this.lblPourcent2 = new JLabel("50 %");
		this.lblPourcent2.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblPourcent2.setBounds(363, 305, 51, 20);
		getContentPane().add(this.lblPourcent2);
		
		hideComponents(true);
		
	}

	private void labelCreation()
	{
		this.lblMapSize = new JLabel("Taille de la carte :");
		this.lblMapSize.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblMapSize.setBounds(33, 61, 173, 20);
		getContentPane().add(this.lblMapSize);
		
		this.lblProportionDePatchs = new JLabel("Proportion de patchs :");
		this.lblProportionDePatchs.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblProportionDePatchs.setBounds(33, 110, 173, 23);
		getContentPane().add(this.lblProportionDePatchs);
		
		this.lblNombreDeGroupes = new JLabel("Nombre d'amats :");
		this.lblNombreDeGroupes.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblNombreDeGroupes.setBounds(33, 196, 147, 20);
		getContentPane().add(this.lblNombreDeGroupes);
		
		this.lblProportionDePatchs_1 = new JLabel("Proportion de patchs");
		this.lblProportionDePatchs_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblProportionDePatchs_1.setBounds(33, 284, 150, 31);
		getContentPane().add(this.lblProportionDePatchs_1);
		
		this.lblDansChaqueGroupe = new JLabel("dans chaque amat :");
		this.lblDansChaqueGroupe.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblDansChaqueGroupe.setBounds(33, 305, 150, 31);
		getContentPane().add(this.lblDansChaqueGroupe);
		
		this.lblNombreDePatchs = new JLabel("Taille de l'amat :");
		this.lblNombreDePatchs.setFont(new Font("Dialog", Font.PLAIN, 15));
		this.lblNombreDePatchs.setBounds(33, 242, 114, 23);
		getContentPane().add(this.lblNombreDePatchs);
		
	}
	
	private void hideComponents(boolean hideComponents)
	{
		this.lblNombreDeGroupes.setEnabled(!hideComponents);
		this.lblNombreDePatchs.setEnabled(!hideComponents);
		this.lblProportionDePatchs_1.setEnabled(!hideComponents);
		this.lblDansChaqueGroupe.setEnabled(!hideComponents);
		
		this.spinnerAmatsNumber.setEnabled(!hideComponents);
		this.spinnerSizeAmats.setEnabled(!hideComponents);
		this.slider2.setEnabled(!hideComponents);
		
		this.slider1.setEnabled(hideComponents);
		this.lblProportionDePatchs.setEnabled(hideComponents);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.chckbxFaireDesAmats)
		{			
			if (this.chckbxFaireDesAmats.isSelected())
				hideComponents(false);
			else
				hideComponents(true);
		}
		if (e.getSource() == this.btnEnregistrer)
		{
			MapGenerator mapGenerator = mapGeneratorCreation();
			this.fileChooser.setCurrentDirectory(new File("."));

			int returnVal = this.fileChooser.showDialog(this, "Enregistrer");

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = this.fileChooser.getSelectedFile();
				this.filePath = file.getAbsolutePath();
			}
			mapGenerator.generateMap(this.filePath);
			this.dispose();
		}
	}

	public MapGenerator mapGeneratorCreation()
	{
		MapGenerator mapGenerator;
		
		if (this.chckbxFaireDesAmats.isSelected())
		{
			mapGenerator = new MapGenerator((int)this.spinnerMapSize.getValue(), this.slider2.getValue(), (int)this.spinnerAmatsNumber.getValue(), (int)this.spinnerSizeAmats.getValue());
		}
		else
		{
			mapGenerator = new MapGenerator((int)this.spinnerMapSize.getValue(), this.slider1.getValue());
		}
		
		return mapGenerator;
	}
}
