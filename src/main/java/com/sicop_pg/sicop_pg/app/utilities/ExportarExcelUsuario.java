/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.utilities;



import com.sicop_pg.sicop_pg.app.model.Usuario;
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
 * @author CACV
 */
public class ExportarExcelUsuario {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Usuario> Listusuario;
    
    public ExportarExcelUsuario(List<Usuario> listUsuario){
        this.Listusuario=listUsuario;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("ListUsuario");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id Usuario", style);
        createCell(row, 1, "Rol", style);
        createCell(row, 2, "Documento", style);
        createCell(row, 3, "Tipo Documento", style);
        createCell(row, 4, "Nombres", style);
        createCell(row, 5, "Apellidos", style);
        createCell(row, 6, "Edad", style);
        createCell(row, 7, "Direccion", style);
        createCell(row, 8, "Celular", style);
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

        for (Usuario u : this.Listusuario) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, u.getId_Usuario(), style);
            createCell(row, columnCount++, u.getFk_id_Roles().getRol(), style);
            createCell(row, columnCount++, u.getNumDocumento(), style);
            createCell(row, columnCount++, u.getFk_idTipoDocumento().getIdTipoDocumento(), style);
            createCell(row, columnCount++, u.getNombres(), style);
            createCell(row, columnCount++, u.getApellidos(), style);
            createCell(row, columnCount++, u.getEdad(), style);
            createCell(row, columnCount++, u.getDireccion(), style);
            createCell(row, columnCount++, u.getCelular(), style);
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