package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
  // Data Provider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		String path=".\\testData\\mcchAdmin_LoginData.xlsx"; //taking xl file from testData
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];//created for two dimension array which can 
			
		
		for(int i=1;i<=totalrows;i++) //1  //read the data from xl storing in two deminsional array
		{
			for(int j=0;j<totalcols;j++) //0    i is ropws j is col
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j); //1,0
			}
				
		}
		
		return loginData; //returning two dimensiopn array
	}
		
	
	
	
}
