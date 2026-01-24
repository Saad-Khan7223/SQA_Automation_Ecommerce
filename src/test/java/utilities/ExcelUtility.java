package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    public  FileInputStream fi;
    public  FileOutputStream fo;
    public  XSSFWorkbook wb;
    public  XSSFSheet ws;
    public   XSSFRow row;
    public  XSSFCell col;
    String path;

    public ExcelUtility (String path){
        this.path=path;
    }

    public  int totalRowCount (String xlSheet) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlSheet);
        int rowCount=ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;

    }

    public  int totalColCount (String xlSheet,int rownum) throws IOException {
        fi=new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rownum);
        int colCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return colCount;
    }
        public  String getCellData(String xlSheet,int rownum,int cell) throws IOException {
            fi=new FileInputStream(path);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(xlSheet);
           row= ws.getRow(rownum);
           col=row.getCell(cell);

           String Data;
           try{

               DataFormatter formatter=new DataFormatter();
               Data=formatter.formatCellValue(col);
           } catch (Exception e) {
               Data="";
           }
            wb.close();
            fi.close();
            return Data;
    }
}
