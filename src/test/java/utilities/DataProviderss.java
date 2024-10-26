package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderss {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\opencartLoginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		int rowCount=xlutil.getRowCount("Sheet1");
		int colCount=xlutil.getCellCount("Sheet1", 1);
		String loginData[][]=new String [rowCount][colCount];
		for(int r=1;r<=rowCount;r++)
		{
			for(int c=0;c<colCount;c++)
			{
				loginData[r-1][c]=xlutil.getCellData("Sheet1", r, c);
			}
		}
		return loginData;
	}
}
