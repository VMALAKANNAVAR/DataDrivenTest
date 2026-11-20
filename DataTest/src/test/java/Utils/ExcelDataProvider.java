package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelDataProvider {

    public File setExcelFilePath(String FileName)
    {
        File path=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\"+FileName+".xlsx");
        return path;
    }

    public Object[] readExcelFile(String FileName,String SheetName) throws IOException {

        FileInputStream fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        XSSFWorkbook book=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=book.getSheet(SheetName);
        XSSFRow row=sheet.getRow(0);
        int lastColumn =sheet.getRow(0).getLastCellNum();
        Hashtable<String, String> table=new Hashtable<String,String>();
        int rowCount=sheet.getLastRowNum();
        Object[] datavalue=new Object[rowCount];
        for(int i=0;i<lastColumn;i++)
        {
            Cell cell=row.getCell(i);
            DataFormatter formatter = new DataFormatter();
            String value = formatter.formatCellValue(cell);
            table.put(value,"");

        }

        datavalue[1]=table;
        return datavalue;
    }
}
