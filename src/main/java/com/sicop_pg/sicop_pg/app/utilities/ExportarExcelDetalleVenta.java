/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.utilities;


import com.sicop_pg.sicop_pg.app.model.DetalleVenta;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 15-cw1004la
 */
public class ExportarExcelDetalleVenta {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DetalleVenta> ListDetalleVenta;
    
    public ExportarExcelDetalleVenta(List<DetalleVenta> listDetalleVentas){
        this.ListDetalleVenta=listDetalleVentas;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("ListDetalleVenta");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id Detalle", style);
        createCell(row, 1, "Usuario", style);
        createCell(row, 2, "Tipo Venta", style);
        createCell(row, 3, "Producto", style);
        createCell(row, 4, "Fecha", style);
        createCell(row, 5, "Precio Unitario", style);
        createCell(row, 6, "Cantidad", style);
        createCell(row, 7, "Precio Total", style);
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

        for (DetalleVenta dv : this.ListDetalleVenta) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, dv.getId_detalle(), style);
            createCell(row, columnCount++, dv.getFk_id_Usuario().getNombres(), style);
            createCell(row, columnCount++, dv.getFk_id_tipoVenta().getDescripcion(), style);
            createCell(row, columnCount++, dv.getFk_id_Catalogo().getProducto(), style);
            createCell(row, columnCount++, dv.getFecha(), style);
            createCell(row, columnCount++, dv.getPrecioUnitario(), style);
            createCell(row, columnCount++, dv.getCantidad(), style);
            createCell(row, columnCount++, dv.getPreciototal(), style);
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
