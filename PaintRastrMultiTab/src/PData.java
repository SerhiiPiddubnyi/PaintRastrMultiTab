import java.awt.Color; // синглтон.

public class PData 
{
		int width;
		Color color;
		String figure;
		
		private static PData instance = null;
		
		private PData() 
		{
			width = 2;
			color = Color.black;
			figure = "Creve";
			
		}
		
		public static PData getInstance()
		{
			if (instance == null)
			{
				instance = new PData();
			}
			
			return instance;
			
		}
}
