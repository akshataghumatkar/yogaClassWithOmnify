package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getData (int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream f= new FileInputStream("C:\\Users\\Dell\\Desktop\\Ak\\yogaClass\\src\\test\\resources\\TestData\\TestData.xlsx");
		Sheet sht = WorkbookFactory.create(f).getSheet("Sheet1");
		String data = sht.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public static void captureScreenshot(WebDriver driver, int tcID) throws IOException {
		Date d = new Date();
		String str = d.toString().replace(":", "_");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Dell\\Desktop\\SC\\img"+tcID+str+".jpg");
		FileHandler.copy(src, dest);
		
	}

}
