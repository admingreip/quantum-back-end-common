package com.greip.api.util.common;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressBase.CellPosition;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtlExcel {

	/**
	 * Crea un workbook para 2003 o mayor a 2007 (xml)
	 * 
	 * @param excelFilePath
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}
	
	/**
	 * Genera un Font
	 * @param sheet libro del excel
	 * @param fontName Tipo de letra
	 * @param bold es negrita o no
	 * @param size tamaño de letra
	 * @param color color de letra HSSFColor.HSSFColorPredefined.DARK_RED.getIndex()
	 * @return Font
	 */
	public static Font generateFont(Sheet sheet, String fontName, boolean bold, int size, int color) {
		Font font = sheet.getWorkbook().createFont();
		if (fontName != null) {
			font.setFontName(fontName);
		} else {
			font.setFontName("Arial");
		}
		font.setBold(bold);

		if (size != 0) {
			font.setFontHeightInPoints((short) size);
		} else {
			font.setFontHeightInPoints((short) 10);
		}

		if (color != 0) {
			font.setColor((short) color);
		}

		return font;

	}
	
	/**
	 * Crea un estilo para una celda
	 * @param sheet libro del excel
	 * @param aligment alineacion 1:Derecha, 0:Centrado, -1:Izquierda, 2: Justificado
	 * @param wrap Salta de linea al cubrir el ancho de la celda
	 * @param font Font de la Celda
	 * @param border tiene border o no
	 * @return CellStyle
	 */
	public static CellStyle generateCellStyle(Sheet sheet, int aligment, boolean wrap, Font font, boolean border) {
		CellStyle style = sheet.getWorkbook().createCellStyle();
		
		if (aligment == 1) {
			style.setAlignment(HorizontalAlignment.RIGHT);
		} else if (aligment == 0) {
			style.setAlignment(HorizontalAlignment.CENTER);
		} else if (aligment == -1) {
			style.setAlignment(HorizontalAlignment.LEFT);
		} else if (aligment == 2) {
			style.setAlignment(HorizontalAlignment.JUSTIFY);
		}
		if (border) {
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
		}
		style.setWrapText(wrap);
		style.setFont(font);
		return style;
	}
	
	/**
	 * Crea un estilo para una celda
	 * @param sheet libro del excel
	 * @param aligment alineacion 1:Derecha, 0:Centrado, -1:Izquierda, 2: Justificado
	 * @param wrap Salta de linea al cubrir el ancho de la celda
	 * @param fontName Tipo de letra
	 * @param bold es negrita o no
	 * @param size tamaño de letra
	 * @param color color de letra HSSFColor.HSSFColorPredefined.DARK_RED.getIndex()
	 * @param border tiene border o no
	 * @return CellStyle
	 */
	public static CellStyle generateCellStyle(Sheet sheet, int aligment, boolean wrap, String fontName, boolean bold, int size, int color, boolean border) {
		CellStyle style = sheet.getWorkbook().createCellStyle();
		
		if (aligment == 1) {
			style.setAlignment(HorizontalAlignment.RIGHT);
		} else if (aligment == 0) {
			style.setAlignment(HorizontalAlignment.CENTER);
		} else if (aligment == -1) {
			style.setAlignment(HorizontalAlignment.LEFT);
		} else if (aligment == 2) {
			style.setAlignment(HorizontalAlignment.JUSTIFY);
		}
		style.setWrapText(wrap);
		if (border) {
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
		}
		
		style.setFont(generateFont(sheet,fontName, bold, size, color));
		
		return style;
	}
	
	/**
	 * Crea un estilo para una celda
	 * @param sheet libro del excel
	 * @param aligment alineacion 1:Derecha, 0:Centrado, -1:Izquierda, 2: Justificado
	 * @param wrap Salta de linea al cubrir el ancho de la celda
	 * @param border tiene border o no
	 * @return CellStyle
	 */
	public static CellStyle generateCellStyle(Sheet sheet, int aligment, boolean wrap, boolean border) {
		CellStyle style = sheet.getWorkbook().createCellStyle();
		
		if (aligment == 1) {
			style.setAlignment(HorizontalAlignment.RIGHT);
		} else if (aligment == 0) {
			style.setAlignment(HorizontalAlignment.CENTER);
		} else if (aligment == -1) {
			style.setAlignment(HorizontalAlignment.LEFT);
		} else if (aligment == 2) {
			style.setAlignment(HorizontalAlignment.JUSTIFY);
		}
		style.setWrapText(wrap);
		if (border) {
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
		}
		
		style.setFont(generateFont(sheet,null, false, 10, 0));
		
		return style;
	}
	
	/**
	 * Permite escribir en la celda de un libro un valor de tipo String
	 * @param sheet libro de un excel
	 * @param rowNum fila
	 * @param colNum columna
	 * @param value valor en String
	 * @param style CellStyle
	 */
	public static void write(Sheet sheet, int rowNum, int colNum, String value, CellStyle style) {
		Row header = sheet.getRow(rowNum);

		if (header == null) {
			header = sheet.createRow(rowNum);
		}
		Cell cell = header.getCell(colNum);

		if (cell == null) {
			cell = header.createCell(colNum);
		}

		cell.setCellValue(value);

		if (style != null) {
			cell.setCellStyle(style);
		}

	}
	
	/**
	 * Permite escribir en la celda de un libro un valor de tipo entero
	 * @param sheet libro de un excel
	 * @param rowNum fila
	 * @param colNum columna
	 * @param value valor en entero
	 * @param style CellStyle
	 */
	public static void write(Sheet sheet, int rowNum, int colNum, int value, CellStyle style) {
		Row header = sheet.getRow(rowNum);

		if (header == null) {
			header = sheet.createRow(rowNum);
		}
		Cell cell = header.getCell(colNum);

		if (cell == null) {
			cell = header.createCell(colNum);
		}

		cell.setCellValue(value);

		if (style != null) {
			cell.setCellStyle(style);
		}

	}
	
	/**
	 * Permite escribir en la celda de un libro un valor de tipo double
	 * @param sheet libro de un excel
	 * @param rowNum fila
	 * @param colNum columna
	 * @param value valor en double
	 * @param style CellStyle
	 */
	public static void write(Sheet sheet, int rowNum, int colNum, double value, CellStyle style) {
		Row header = sheet.getRow(rowNum);

		if (header == null) {
			header = sheet.createRow(rowNum);
		}
		Cell cell = header.getCell(colNum);

		if (cell == null) {
			cell = header.createCell(colNum);
		}

		cell.setCellValue(value);

		if (style != null) {
			cell.setCellStyle(style);
		}

	}
	
	/**
	 * Permite escribir en la celda de un libro un valor de tipo date
	 * @param sheet libro de un excel
	 * @param rowNum fila
	 * @param colNum columna
	 * @param value valor en date
	 * @param style CellStyle
	 */
	public static void write(Sheet sheet, int rowNum, int colNum, Date value, CellStyle style) {
		Row header = sheet.getRow(rowNum);

		if (header == null) {
			header = sheet.createRow(rowNum);
		}
		Cell cell = header.getCell(colNum);

		if (cell == null) {
			cell = header.createCell(colNum);
		}

		cell.setCellValue(value);

		if (style != null) {
			cell.setCellStyle(style);
		}

	}

}
