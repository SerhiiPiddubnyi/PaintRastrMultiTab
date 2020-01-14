import javax.swing.JTabbedPane;

public class PTabbed extends JTabbedPane
{
	public PTabbed() 
	{
		setBounds(5, 65, 600, 500);
		addTab("Tab 1", new PPanel());
	}
}
