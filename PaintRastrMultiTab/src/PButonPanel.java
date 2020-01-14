import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class PButonPanel  extends JPanel 
{

	PComand pComand = PComand.getInstance();
	JSlider slider;

	public PButonPanel()
	{
		setLayout(null);
		

		setBackground(Color.blue);
		setBounds(605, 0, 200, 565);

		JButton btnBlack, btnRed, btnGreen, btnOther, btn1px, btn5px, btn10px, btnSawe, btnLoad;
		
		JRadioButton radioCreve, radioLine, radioOval, radioRect;

		btnBlack = new JButton("Black");
		btnRed = new JButton("Red");
		btnGreen = new JButton("Green");
		btnOther = new JButton("Other");
		btn1px = new JButton("1px");
		btn5px = new JButton("5px");
		btn10px = new JButton("10px");
		btnSawe = new JButton("Sawe");
		btnLoad = new JButton("Load");
		
		slider = new JSlider(1, 10, 1);
		
		radioCreve = new JRadioButton("Creve");
		radioLine = new JRadioButton("Line");
		radioOval = new JRadioButton("Oval");
		radioRect = new JRadioButton("Rect");


		btnBlack.setBounds(50, 10, 100, 30);
		btnRed.setBounds(50, 45, 100, 30);
		btnGreen.setBounds(50, 80, 100, 30);
		btnOther.setBounds(50, 115, 100, 30);
		btn1px.setBounds(50, 155, 100, 30);
		btn5px.setBounds(50, 190, 100, 30);
		btn10px.setBounds(50, 225, 100, 30);
		btnSawe.setBounds(50, 260, 100, 30);
		btnLoad.setBounds(50, 295, 100, 30);

		slider.setBounds(10, 330, 180, 50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(3);
		slider.setMinorTickSpacing(1);
		slider.setFont(new Font("Arial", Font.PLAIN, 10));
		
		radioCreve.setBounds(50, 400, 70, 20);
		radioLine.setBounds(50, 435, 70, 20);
		radioOval.setBounds(50, 470, 70, 20);
		radioRect.setBounds(50, 505, 70, 20);
		
		radioCreve.setBackground(Color.BLUE);
		radioLine.setBackground(Color.BLUE);
		radioOval.setBackground(Color.BLUE);
		radioRect.setBackground(Color.BLUE);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioCreve);
		radioGroup.add(radioLine);
		radioGroup.add(radioOval);
		radioGroup.add(radioRect);
		
		
		btnBlack.setActionCommand("Black");
		btnRed.setActionCommand("Red");
		btnGreen.setActionCommand("Green");
		btnOther.setActionCommand("Other");
		btn1px.setActionCommand("1px");
		btn5px.setActionCommand("5px");
		btn10px.setActionCommand("10px");
		btnSawe.setActionCommand("Sawe");
		btnLoad.setActionCommand("Load");
		
		radioCreve.setActionCommand("Creve");
		radioLine.setActionCommand("Line");
		radioOval.setActionCommand("Oval");
		radioRect.setActionCommand("Rect");
		
		btnBlack.addActionListener(pComand.aColor);
		btnRed.addActionListener(pComand.aColor);
		btnGreen.addActionListener(pComand.aColor);
		btnOther.addActionListener(pComand.aColor);
		btn1px.addActionListener(pComand.aWidth);
		btn5px.addActionListener(pComand.aWidth);
		btn10px.addActionListener(pComand.aWidth);
		slider.addChangeListener(pComand.slider);
		radioCreve.addActionListener(pComand.aRadio);
		radioLine.addActionListener(pComand.aRadio);
		radioOval.addActionListener(pComand.aRadio);
		radioRect.addActionListener(pComand.aRadio);
		btnSawe.addActionListener(pComand.aSawe);
		btnLoad.addActionListener(pComand.aLoad);
		

		add(btnBlack);
		add(btnRed);
		add(btnGreen);
		add(btnOther);
		add(btn1px);
		add(btn5px);
		add(btn10px);
		add(slider);
		add(radioCreve);
		add(radioLine);
		add(radioOval);
		add(radioRect);
		add(btnSawe);
		add(btnLoad);
		
		pComand.getButonPanel(this);

	}
	
}