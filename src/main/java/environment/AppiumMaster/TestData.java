package environment.AppiumMaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataForEditBox() throws IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File namesDir = new File(classpathRoot, "/data");
		File file = new File(namesDir, "names.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Names");
		
		Object[][] names = new Object[2][1];

		for (int i = 1; i <= 2; i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell name = row.getCell(0);
			names[i-1][0] = name.getStringCellValue();
		}
		
		wb.close();
		fis.close();

		return names;
	}
}
