package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ExcelDataProvider {

    public File setExcelFilePath(String FileName)
    {
        File path=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\"+FileName+".xlsx");
        return path;
    }


    //getColumnNumber
    public int getColumnNumber(String FileName,String SheetName, String CoulmnName) throws IOException {
        FileInputStream fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        XSSFWorkbook book=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=book.getSheet(SheetName);
        XSSFRow row=sheet.getRow(0);
        int lastColumn =sheet.getRow(0).getLastCellNum();
        int columnNum=0;
        for(int i=0;i<lastColumn;i++)
        {
            if(row.getCell(i).getStringCellValue().equalsIgnoreCase(CoulmnName))
            {
                columnNum= i;
                break;
            }
        }
        return columnNum;
    }

    public String getCellData(String FileName,String SheetName,int column,int row) throws IOException {
        FileInputStream fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        XSSFWorkbook book=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=book.getSheet(SheetName);
        XSSFRow rowValues=sheet.getRow(row);
        String cellValue=rowValues.getCell(column).getStringCellValue();
        return cellValue;
    }

    public Object[] readExcelFile(String FileName,String SheetName) throws IOException {

        FileInputStream fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        XSSFWorkbook book=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=book.getSheet(SheetName);
        XSSFRow row=sheet.getRow(0);
        int lastColumn =sheet.getRow(0).getLastCellNum();
        List<String> ColumnNames=new ArrayList<>();
        Hashtable<String, String> table=new Hashtable<String,String>();
        int rowCount=sheet.getLastRowNum();
        Object[] datavalue=new Object[rowCount];

        //Store Column Names:
        for(int i=0;i<lastColumn;i++)
        {
            Cell cell=row.getCell(i);
            DataFormatter formatter = new DataFormatter();
            String value = formatter.formatCellValue(cell);
            ColumnNames.add(i,value);

        }


        int execute=getColumnNumber(FileName,SheetName,"Execute");

        int ExecuteTableScenarios=0;
        for(int i=1;i<rowCount;i++)
        {
            if(getCellData(FileName,SheetName,execute,i).equalsIgnoreCase("Y") && getCellData(FileName,SheetName,execute,i)!=null ) {
                for (int j = 0; j < lastColumn; j++) {

                    table.put(ColumnNames.get(j), getCellData(FileName, SheetName, j, i));

                }
            }

        }
        datavalue[1]=table;
        return datavalue;
    }
}
