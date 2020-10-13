package OPDEMR.utils;

/* import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream; */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.opencsv.CSVReader;
//import com.sun.jna.platform.FileUtils;

/**
 * The Class DataUtils.
 *
 * @author Chandan Kumar
 */
public class DataUtils {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(DataUtils.class.getName());

	public DataUtils() {
		Log.info("Initialized Datautils Class");
	}

	private static String testdatafilepath1 = System.getProperty("user.dir") + "/" + "resources" + "/"
			+ "TestData1.xlsx";

	private static String testdatafilepath = System.getProperty("user.dir") + "/" + "resources" + "/" + "TestData.xlsx";

	/**
	 * Gets the test data.
	 *
	 * @param sheetname the sheetname
	 * @param id        the id
	 * @param field     the field
	 * @return the test data
	 */
	public static String getTestData1(String sheetname, String id, String field) {
		String value = null;
		try {

			Fillo fillo = new Fillo();
			Log.info("fillo filepath is:" + testdatafilepath1);
			Connection connection = fillo.getConnection(testdatafilepath1);
			String strQuery = "Select * from " + sheetname + " " + "where ID='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				value = recordset.getField(field);
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.getMessage();
			Log.error("unable to read data from file");
		}
		return value;
	}

	public static String generateRandomNumber() {
		int c;
		Random t = new Random();

		// random integers in [0, 100]

		for (c = 1; c <= 10; c++) {
			System.out.println(t.nextInt(100));
		}

		String str = Integer.toString(t.nextInt(100));
		return str;
	}

	public static String getTestData(String sheetname, String id, String field) {
		String value = null;
		try {

			Fillo fillo = new Fillo();
			Log.info("fillo filepath is:" + testdatafilepath);
			Connection connection = fillo.getConnection(testdatafilepath);
			String strQuery = "Select * from " + sheetname + " " + "where ID='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				value = recordset.getField(field);
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.getMessage();
			Log.error("unable to read data from file");
		}
		return value;
	}

	/*
	 * public static String getValueofColumnFromExcel(String sheetname, String
	 * columnname, int rownum) throws Exception { String excelFilePath =
	 * BaseTest.getPath() + "//resources//TestData.xlsx"; FileInputStream fis = new
	 * FileInputStream(excelFilePath);
	 * 
	 * @SuppressWarnings("resource") XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 * XSSFSheet sheet = workbook.getSheet(sheetname); XSSFRow row =
	 * sheet.getRow(0);
	 * 
	 * int col_num = -1;
	 * 
	 * for(int i=0; i < row.getLastCellNum(); i++) {
	 * if(row.getCell(i).getStringCellValue().trim().equals(columnname)) col_num =
	 * i; }
	 * 
	 * row = sheet.getRow(1); XSSFCell cell = row.getCell(col_num);
	 * 
	 * String value = cell.getStringCellValue();
	 * System.out.println("Value of the Excel Cell is - "+ value);
	 * 
	 * return value; }
	 * 
	 * 
	 */

	public static List<Double> getDataFromXLS(String filpath, String id, String field) {
		List<Double> list = new ArrayList<Double>();
		try {

			Fillo fillo = new Fillo();
			Log.info("fillo filepath is:" + filpath);
			Connection connection = fillo.getConnection(filpath);
			String strQuery = "Select * from sheet where productname='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				list.add(Double.parseDouble(recordset.getField(field)));
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.getMessage();
			Log.error("unable to read data from file");
		}
		return list;
	}

	public static List<Double> getDataFromXLSWithQuery(String filpath, String query, String field) {
		List<Double> list = new ArrayList<Double>();
		try {

			Fillo fillo = new Fillo();
			Log.info("fillo filepath is:" + filpath);
			Connection connection = fillo.getConnection(filpath);
			String strQuery = query;
			// String strQuery = "Select * from sheet where productname='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				list.add(Double.parseDouble(recordset.getField(field)));
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			e.getMessage();
			Log.error("unable to read data from file");
		}
		return list;
	}

	public static void unzip(String zipFilePath, String outputPath) {

		if (outputPath == null)
			outputPath = "";
		else
			outputPath += File.separator;
		System.out.println(outputPath += File.separator);
		// 1.0 Create output directory
		File outputDirectory = new File(outputPath);
		if (outputDirectory.exists())
			outputDirectory.delete();
		outputDirectory.mkdir();
		// 2.0 Unzip (create folders & copy files)
		try {
			// 2.1 Get zip input stream
			ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry = null;
			int len;
			byte[] buffer = new byte[1024];
			// 2.2 Go over each entry "file/folder" in zip file
			while ((entry = zip.getNextEntry()) != null) {
				if (!entry.isDirectory()) {
					System.out.println("-" + entry.getName());
					// create a new file
					File file = new File(outputPath + entry.getName());
					// create file parent directory if does not exist
					if (!new File(file.getParent()).exists())
						new File(file.getParent()).mkdirs();
					// get new file output stream
					FileOutputStream fos = new FileOutputStream(file);
					// copy bytes
					while ((len = zip.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
				}
				zip.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String convertCsvToXls(String xlsFileLocation, String csvFilePath) {
		final char FILE_DELIMITER = ',';
		final String FILE_EXTN = ".xlsx";
		final String FILE_NAME = "EXCEL_DATA";

		SXSSFSheet sheet = null;
		CSVReader reader = null;
		Workbook workBook = null;
		String generatedXlsFilePath = "";
		FileOutputStream fileOutputStream = null;

		try {

			/**** Get the CSVReader Instance & Specify The Delimiter To Be Used ****/
			String[] nextLine;
			reader = new CSVReader(new FileReader(csvFilePath), FILE_DELIMITER);

			workBook = new SXSSFWorkbook();
			sheet = (SXSSFSheet) workBook.createSheet("Sheet");

			int rowNum = 0;
			Log.info("Creating New .Xls File From The Already Generated .Csv File");
			while ((nextLine = reader.readNext()) != null) {
				Row currentRow = sheet.createRow(rowNum++);
				for (int i = 0; i < nextLine.length; i++) {

					currentRow.createCell(i).setCellValue(nextLine[i]);

				}
			}

			generatedXlsFilePath = xlsFileLocation + "/" + FILE_NAME + FILE_EXTN;
			Log.info("The File Is Generated At The Following Location?= " + generatedXlsFilePath);

			fileOutputStream = new FileOutputStream(generatedXlsFilePath.trim());
			workBook.write(fileOutputStream);
		} catch (Exception exObj) {
			Log.error("Exception In convertCsvToXls() Method?=  " + exObj);
		} finally {
			try {

				/**** Closing The Excel Workbook Object ****/
				workBook.close();

				/**** Closing The File-Writer Object ****/
				fileOutputStream.close();

				/**** Closing The CSV File-ReaderObject ****/
				reader.close();
			} catch (IOException ioExObj) {
				Log.error("Exception While Closing I/O Objects In convertCsvToXls() Method?=  " + ioExObj);
			}
		}
		return generatedXlsFilePath;
	}

	public static Double getSumOfItemsInTheList(List<Double> list) {
		Double sum = 0.0;
		for (double num : list) {
			sum = sum + num;
		}
		return sum;

	}

	public static void downloadFileFromURL(String url, String fileName) {
		BufferedInputStream in = null;
		FileOutputStream fout = null;

		try {
			in = new BufferedInputStream(new URL(url).openStream());
			fout = new FileOutputStream(fileName);

			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void writeExcel(String fileName,String sheetName,String[] dataToWrite) throws IOException{

        //Create an object of File class to open xlsx file

		
        File file =    new File(testdatafilepath);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook Workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            Workbook = new HSSFWorkbook(inputStream);

        }    

    //Read excel sheet by sheet name    

    Sheet sheet = Workbook.getSheet(sheetName);

    //Get the current count of rows in excel file

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Get the first row from the sheet

    Row row = sheet.getRow(0);

    //Create a new row and append it at last of sheet

    Row newRow = sheet.createRow(rowCount+1);

    //Create a loop over the cell of newly created Row

    for(int j = 0; j < row.getLastCellNum(); j++){

        //Fill data in row

        Cell cell = newRow.createCell(j);

        
        cell.setCellValue(dataToWrite[j]);

        System.out.println("cell value --------------->>> "+cell);
    }

    //Close input stream

    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file

    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file

    Workbook.write(outputStream);

    //close output stream

    outputStream.close();
	
    }
	
	
	
	
	public static void writeDataToExcel(String[] dataToWrite,int rownumber) throws IOException {
		
		String path = testdatafilepath;
		
		FileInputStream fis = new FileInputStream(path);
		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		//System.out.println("no of worksheet in excel is "+workbook.getNumberOfSheets());
		//System.out.println("name of the sheet is "+workbook.getSheetName(0));
		
		Row row = sheet.getRow(rownumber);
		for(int j=0;j<=dataToWrite.length-1;j++)
		{
		Cell cell = row.createCell(j);
		
		cell.setCellValue(dataToWrite[j]);
		System.out.println("Array values are "+dataToWrite[j]);
		//System.out.println("---------------------->"+cell);
		}
		FileOutputStream fos = new FileOutputStream(path);
		
		workbook.write(fos);
		
		fos.close();
 
	}
	
	
public static void writeDataToExcelInDesiredRowAndColumn(String str,int rownumber,int columnnumber) throws IOException {
		
		String path = testdatafilepath;
		
		FileInputStream fis = new FileInputStream(path);
		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		//System.out.println("no of worksheet in excel is "+workbook.getNumberOfSheets());
		//System.out.println("name of the sheet is "+workbook.getSheetName(0));
		
		Row row = sheet.getRow(rownumber);
		
		Cell cell = row.createCell(columnnumber);
		
		cell.setCellValue(str);
		System.out.println("Value is "+str);
		//System.out.println("---------------------->"+cell);
		
		FileOutputStream fos = new FileOutputStream(path);
		
		workbook.write(fos);
		
		fos.close();
 
	}
	
public static String FetchDataFromExcelIn5thColumn(int rownumber) throws IOException {
	
	String path = testdatafilepath;
	
	FileInputStream fis = new FileInputStream(path);
	
	Workbook workbook = new XSSFWorkbook(fis);
	
	Sheet sheet1 = workbook.getSheetAt(0);     // first sheet
	Row row     = sheet1.getRow(rownumber);        // first row
	Cell cell   = row.getCell(4);
	String value = cell.getStringCellValue();// use a loop to read all the cells in the rows.

	return value;


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
