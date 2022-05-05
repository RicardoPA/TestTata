package Page.Action;

import Page.BasePage;
import Page.Page.ResultPage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultAction extends BasePage {

    ResultPage resultPage;

    public ResultAction(WebDriver driver) {
        super(driver);

        resultPage = new ResultPage(driver);
    }

    public boolean validarResultado() throws InterruptedException {
        Thread.sleep(1000);
        scrollDownToElement(resultPage.getLabelSummary());
        Thread.sleep(2000);
        return resultPage.getListTableSummary().size() > 0;
    }

    public void exportarTablaSummaryExcel() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Summary");

        String[] headers = new String[]{"SUMMARY"};

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        String header = headers[0];
        HSSFCell cell = headerRow.createCell(0);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(header);

        for (int i = 0; i < resultPage.getListTableSummary().size(); i++) {
            HSSFRow dataRow = sheet.createRow(i + 1);
            dataRow.createCell(0).setCellValue(resultPage.getListTableSummary().get(i).findElement(By.tagName("th")).getText());
            for (int j = 1; j < 5 ; j++)
                dataRow.createCell(j).setCellValue(resultPage.getListTableSummary().get(i).findElement(By.xpath("td["+j+"]")).getText());
        }

        FileOutputStream file = new FileOutputStream("tablaSummary.xls");
        workbook.write(file);
        file.close();
    }
}
