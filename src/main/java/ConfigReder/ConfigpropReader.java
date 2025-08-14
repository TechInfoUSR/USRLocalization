package ConfigReder;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigpropReader {
	
	
		private Properties prop;
		private FileInputStream ip;

		public Properties initFlow(String Flow) 
		{
			
			System.out.println("Flow name  is : " + Flow);
			prop = new Properties();
			try 
			{
				switch (Flow.toLowerCase()) 
				{
				case "directmgrprop":
					ip = new FileInputStream("./properties/DirectMGRFlow.properties");
					System.out.println(ip);
					break;
					
				case "360degree_flow":
					ip = new FileInputStream("./properties/360Degree_Flow.properties");
					System.out.println(ip);
					break;
					
				case "normalflowtest":
					ip = new FileInputStream("./properties/NormalFlowTest.properties");
					System.out.println(ip);
					
				default:
					System.out.println("Flow not found..." + Flow);
					break;
				}
				prop.load(ip);
			} 
			catch (Exception e) 
			{
				
				System.out.println(Flow + " : properties file not found");
			}
			return prop;
		}
	}


