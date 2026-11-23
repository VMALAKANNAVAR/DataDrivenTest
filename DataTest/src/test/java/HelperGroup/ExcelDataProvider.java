package HelperGroup;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ExcelDataProvider {

    public static File path;
    public static FileInputStream fileInputStream;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;

    public File setExcelFilePath(String FileName)
    {
        path=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\"+FileName+".xlsx");
        return path;
    }


    //getColumnNumber of specific column
    public int getColumnNumber(String FileName,String SheetName, String CoulmnName) throws IOException {
        fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        book=new XSSFWorkbook(fileInputStream);
        sheet=book.getSheet(SheetName);
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

    //To Get cell value from spefici row followed by column
    public String getCellData(String FileName,String SheetName,int column,int row) throws IOException {
        fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        book=new XSSFWorkbook(fileInputStream);
        sheet=book.getSheet(SheetName);
        XSSFRow rowValues=sheet.getRow(row);
        String cellValue=rowValues.getCell(column).getStringCellValue();
        return cellValue;
    }

    public Object[] readExcelFile(String FileName,String SheetName) throws IOException {

        //Initiate File read
        fileInputStream=new FileInputStream( setExcelFilePath(FileName));
        book=new XSSFWorkbook(fileInputStream);
        sheet=book.getSheet(SheetName);
        XSSFRow row=sheet.getRow(0);
        int lastColumn =sheet.getRow(0).getLastCellNum();
        List<String> ColumnNames=new ArrayList<>();

        int rowCount=sheet.getLastRowNum();


        //Store Column Names:
        for(int i=0;i<lastColumn;i++)
        {
            Cell cell=row.getCell(i);
            DataFormatter formatter = new DataFormatter();
            String value = formatter.formatCellValue(cell);
            ColumnNames.add(i,value);

        }

        //Get Excutebale flag column number
        int execute=getColumnNumber(FileName,SheetName,"Execute");

        //Get number of executable scenario
        int excutableScenarioCount=0;
        for(int i=1;i<rowCount;i++) {
            if (getCellData(FileName, SheetName, execute, i).equalsIgnoreCase("Y") && getCellData(FileName, SheetName, execute, i) != null) {

                excutableScenarioCount++;
            }
        }

        //Creating array of object for n number of executable scenario
        Object[] datavalue=new Object[excutableScenarioCount+1];


        //Store each row with Y flag with header value in array of object
        int objindex=0;
        int ExecuteTableScenarios=0;
        for(int i=1;i<=rowCount;i++)
        {
            Hashtable<String, String> table=new Hashtable<String,String>();
            if(getCellData(FileName,SheetName,execute,i).equalsIgnoreCase("Y") && getCellData(FileName,SheetName,execute,i)!=null ) {
                for (int j = 0; j <lastColumn; j++) {

                    table.put(ColumnNames.get(j), getCellData(FileName, SheetName, j, i));

                }
                datavalue[objindex]=table;
                objindex++;
            }

        }

        return datavalue;
    }
}
