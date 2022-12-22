/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.utilities;


import com.sicop_pg.sicop_pg.app.model.Compra;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 15-cw1004la
 */
public class ExportarExcelCompra {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Compra> Listcompra;
    
    public ExportarExcelCompra(List<Compra> listCompras){
        this.Listcompra=listCompras;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("listCompras");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id Compra", style);
        createCell(row, 1, "Producto", style);
        createCell(row, 2, "Cantidad", style);
        createCell(row, 3, "Valor Compra", style);
        createCell(row, 4, "Fecha Compra", style);
        createCell(row, 5, "Proveedor", style);
    }
    
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if(value instanceof Date){
            cell.setCellValue((Date) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Compra c : this.Listcompra) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, c.getId_Compra(), style);
            createCell(row, columnCount++, c.getProducto(), style);
            createCell(row, columnCount++, c.getCantidad(), style);
            createCell(row, columnCount++, c.getValorCompra(), style);
            createCell(row, columnCount++, c.getFechaCompra(), style);
            createCell(row, columnCount++, c.getFk_id_Proveedor().getNombres(), style);
        }
    }
    
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }    
}
