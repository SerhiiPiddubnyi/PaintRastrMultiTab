
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class PFrame extends JFrame 
{
	
	public PFrame()
	{
		setLayout(null);
		setTitle("Paint");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 820, 601);
		
		add (new PMenu());
		add (new PToolBar());
		add (new PButonPanel());
		
		PTabbed tabbedPane = new PTabbed();
		add (tabbedPane);
		
		PComand pComand = PComand.getInstance();
		
		pComand.setTabbedPane(tabbedPane);
		
		setVisible(true);
		
	}

}
