package suite.utils;

	import java.io.File;
	import java.io.FileInputStream;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtils {
		

			static String systemPath;
			static XSSFWorkbook workbook;
			static XSSFSheet sheet;


			/**
		     * Input the excel path
		     *
		     * @param excelPath path of the excel file
		     */
		    public XSSFWorkbook ExcelDataConfig(String excelPath) {
		        try {
		            File filePath = new File(excelPath);
		            FileInputStream Inputfile = new FileInputStream(filePath);
		            workbook = new XSSFWorkbook(Inputfile);
		            return workbook;
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		        return workbook;
		    }

			public static int getRowCount()
			{
				int rowCount = sheet.getPhysicalNumberOfRows();
				System.out.println("no. of rows: "+rowCount);
				return rowCount;
			}
			
			public static int getColCount()
			{
				int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("no. of columns:" +colCount);
				return colCount;
			}

			public static String  getCellCountString(int rowNum, int colNum)
			{
				String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println(cellData);
				return cellData;
			}



			public static double getCellCountNumber(int rowNum, int colNum)
			{
				double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				//System.out.println(cellData);
				return cellData;
			}

		}