package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	String projectPath = System.getProperty("user.dir");
	
	@Test(dataProvider="test01")
	public void Test01(String username, String password) {
		System.out.println(username+"  |  "+password);
	}
	
	@DataProvider(name = "test01")
	public Object [][] getData() {
		String excelPath = projectPath+"/excel/data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				String cellData = excel.getCellStringData(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
}
