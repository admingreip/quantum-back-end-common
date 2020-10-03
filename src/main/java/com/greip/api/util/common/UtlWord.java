package com.greip.api.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class UtlWord {
	
	public static String FORMAT_NORMAL = "Normal";
	public static String FORMAT_TTULO1 = "Ttulo1";
	public static String FORMAT_TTULO2 = "Ttulo2";
	public static String FORMAT_TTULO3 = "Ttulo3";
	public static String FORMAT_TTULO4 = "Ttulo4";
	public static String FORMAT_TTULO5 = "Ttulo5";
	public static String FORMAT_TTULO6 = "Ttulo6";
	public static String FORMAT_TTULO7 = "Ttulo7";
	public static String FORMAT_TTULO8 = "Ttulo8";
	public static String FORMAT_TTULO9 = "Ttulo9";
	public static String FORMAT_FUENTEDEPRRAFOPREDETER = "Fuentedeprrafopredeter";
	public static String FORMAT_TABLANORMAL = "Tablanormal";
	public static String FORMAT_SINLISTA = "Sinlista";
	public static String FORMAT_TTULO = "Ttulo";
	public static String FORMAT_TTULOCAR = "TtuloCar";
	public static String FORMAT_TEXTODELMARCADORDEPOSICIN = "Textodelmarcadordeposicin";
	public static String FORMAT_LISTACONVIETAS = "Listaconvietas";
	public static String FORMAT_ENCABEZADO = "Encabezado";
	public static String FORMAT_ENCABEZADOCAR = "EncabezadoCar";
	public static String FORMAT_PIEDEPGINA = "Piedepgina";
	public static String FORMAT_PIEDEPGINACAR = "PiedepginaCar";
	public static String FORMAT_TTULO1CAR = "Ttulo1Car";
	public static String FORMAT_TTULO2CAR = "Ttulo2Car";
	public static String FORMAT_TTULOTDC = "TtuloTDC";
	public static String FORMAT_NFASISINTENSO = "nfasisintenso";
	public static String FORMAT_REFERENCIAINTENSA = "Referenciaintensa";
	public static String FORMAT_CITADESTACADA = "Citadestacada";
	public static String FORMAT_CITADESTACADACAR = "CitadestacadaCar";
	public static String FORMAT_LISTACONNMEROS = "Listaconnmeros";
	public static String FORMAT_HIPERVNCULOVISITADO = "Hipervnculovisitado";
	public static String FORMAT_HIPERVNCULO = "Hipervnculo";
	public static String FORMAT_TEXTOINDEPENDIENTE3 = "Textoindependiente3";
	public static String FORMAT_TEXTOINDEPENDIENTE3CAR = "Textoindependiente3Car";
	public static String FORMAT_TEXTODEBLOQUE = "Textodebloque";
	public static String FORMAT_SANGRA3DETINDEPENDIENTE = "Sangra3detindependiente";
	public static String FORMAT_SANGRA3DETINDEPENDIENTECAR = "Sangra3detindependienteCar";
	public static String FORMAT_REFDECOMENTARIO = "Refdecomentario";
	public static String FORMAT_MAPADELDOCUMENTO = "Mapadeldocumento";
	public static String FORMAT_MAPADELDOCUMENTOCAR = "MapadeldocumentoCar";
	public static String FORMAT_TTULO8CAR = "Ttulo8Car";
	public static String FORMAT_TTULO9CAR = "Ttulo9Car";
	public static String FORMAT_DESCRIPCIN = "Descripcin";
	public static String FORMAT_TEXTODEGLOBO = "Textodeglobo";
	public static String FORMAT_TEXTODEGLOBOCAR = "TextodegloboCar";
	public static String FORMAT_TEXTOCOMENTARIO = "Textocomentario";
	public static String FORMAT_TEXTOCOMENTARIOCAR = "TextocomentarioCar";
	public static String FORMAT_ASUNTODELCOMENTARIO = "Asuntodelcomentario";
	public static String FORMAT_ASUNTODELCOMENTARIOCAR = "AsuntodelcomentarioCar";
	public static String FORMAT_TEXTONOTAALFINAL = "Textonotaalfinal";
	public static String FORMAT_TEXTONOTAALFINALCAR = "TextonotaalfinalCar";
	public static String FORMAT_REMITEDESOBRE = "Remitedesobre";
	public static String FORMAT_TEXTONOTAPIE = "Textonotapie";
	public static String FORMAT_TEXTONOTAPIECAR = "TextonotapieCar";
	public static String FORMAT_CDIGOHTML = "CdigoHTML";
	public static String FORMAT_TECLADOHTML = "TecladoHTML";
	public static String FORMAT_HTMLCONFORMATOPREVIO = "HTMLconformatoprevio";
	public static String FORMAT_HTMLCONFORMATOPREVIOCAR = "HTMLconformatoprevioCar";
	public static String FORMAT_MQUINADEESCRIBIRHTML = "MquinadeescribirHTML";
	public static String FORMAT_TEXTOMACRO = "Textomacro";
	public static String FORMAT_TEXTOMACROCAR = "TextomacroCar";
	public static String FORMAT_TEXTOSINFORMATO = "Textosinformato";
	public static String FORMAT_TEXTOSINFORMATOCAR = "TextosinformatoCar";
	public static String FORMAT_TTULO3CAR = "Ttulo3Car";
	public static String FORMAT_TTULO4CAR = "Ttulo4Car";
	public static String FORMAT_TTULO5CAR = "Ttulo5Car";
	public static String FORMAT_TTULO6CAR = "Ttulo6Car";
	public static String FORMAT_TTULO7CAR = "Ttulo7Car";

	/**
	 * 
	 * @param document Document a generar su archivo fisico
	 * @param ruta     Ruta+Nombre de Archivo + Extension del archivo fisico a
	 *                 generar
	 */
	public static void generateArchivoFisico(XWPFDocument document, String archivo) {

		try {
			FileOutputStream out = new FileOutputStream(archivo);
			document.write(out);
			out.close();
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Archivo generarado >> " + archivo);
		}

	}
	
	
	/**
	 * 
	 * @param document Documento a agregar el parrafo
	 * @param formato  Formato predefinido del parrafo a agregar
	 * @param text     Texto del parrafo
	 * @return
	 */
	public static XWPFRun addParagraph(XWPFDocument document, String formato, String text) {
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setStyle(formato);
		XWPFRun run = paragraph.createRun();
		if (text==null)
			text = "";
		run.setText(text.replace("null", ""));

		return run;

	}
	
	/**
	 * 
	 * @param document Documento a agregar el parrafo
	 * @param formato  Formato predefinido del parrafo a agregar
	 * @param text     Texto del parrafo
	 * @return
	 */
	public static XWPFRun addParagraph(XWPFDocument document, String formato, String text, Boolean italic, int fontSize, Boolean bold) {
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setStyle(formato);
		XWPFRun run = paragraph.createRun();
		if (text==null)
			text = "";
		run.setText(text.replace("null", ""));
		if (italic != null)
		run.setItalic(italic);
		
		if (fontSize!=0) {
			run.setFontSize(fontSize);
		}
		if (bold != null)
		run.setBold(bold);
		return run;

	}


	/**
	 * 
	 * @param document Documento a agregar el salto a la siguiente pagina
	 */
	public static void addbreakPage(XWPFDocument document) {
		XWPFRun tFicticio = addParagraph(document, "", "");
		tFicticio.addBreak(BreakType.PAGE);
	}

	public static void addBreakLine(XWPFDocument document) {
		XWPFRun tFicticio = addParagraph(document, "", "");
		tFicticio.addBreak(BreakType.TEXT_WRAPPING);
	}

	/**
	 * 
	 * @param table    Tabla agregar una nueva fila
	 * @param row      fila agregada
	 * @param vertical True es cabecera vertical y False es cabecera horizontal
	 *                 (Pone en negrita)
	 * @param size     Tamaño del texto de la tabla
	 * @param data     Texto de las columnas
	 * @return
	 */
	public static XWPFTableRow addRowTable(XWPFTable table, int row, boolean vertical, int size, String... data) {
		XWPFTableRow rowTable = null;

		if (row == 0) {
			rowTable = table.getRow(row);
		} else {
			rowTable = table.createRow();
		}
		XWPFTableCell cell;
		XWPFRun run;
		for (int pos = 0; pos < data.length; pos++) {
			if (row == 0) {
				if (pos == 0) {
					cell = rowTable.getCell(pos);
					run = cell.addParagraph().createRun();
					if (vertical) {
						run.setBold(true);

					}
				} else {
					cell = rowTable.addNewTableCell();
					run = cell.addParagraph().createRun();
				}
				if (!vertical) {
					run.setBold(true);
				}

			} else {
				if (pos == 0) {
					cell = rowTable.getCell(pos);
					run = cell.addParagraph().createRun();
					if (vertical) {
						run.setBold(true);
					}
				} else {
					cell = rowTable.getCell(pos);
					run = cell.addParagraph().createRun();
				}
			}

			run.setText(data[pos]);
			run.setFontSize(size);
			// run.getParagraph().setAlignment(ParagraphAlignment.BOTH);

		}

		return rowTable;

	}

	/**
	 * 
	 * @param table        tabla a ajustar las columnas
	 * @param pointColumns puntos de cada columna. Tantos puntos como columnas tenga
	 *                     la tabla
	 */
	public static void setWithColumnsTable(XWPFTable table, int... pointColumns) {
		for (int x = 0; x < table.getNumberOfRows(); x++) {
			XWPFTableRow row = table.getRow(x);
			/*
			 * int numberOfCell = row.getTableCells().size(); for (int y = 0; y <
			 * numberOfCell; y++) { XWPFTableCell cell = row.getCell(y);
			 * cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000)); }
			 */

			for (int y = 0; y < pointColumns.length; y++) {
				XWPFTableCell cell = row.getCell(y);
				cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(pointColumns[y]));
			}

		}

	}

	/**
	 * 
	 * @param document Documento a agregar la imagen
	 * @param fileName Ruta+Nombre+Extension del archivo a agregar al documento
	 * @param w        puntos porcentual del ancho de la imagen
	 * @param h        puntos porcentual del alto de la imagen
	 * @return
	 */
	public static XWPFRun addImage(XWPFDocument document, String fileName, double w, double h) {
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titleRun = title.createRun();

		File f = new File(fileName);
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			titleRun.addPicture(targetStream, XWPFDocument.PICTURE_TYPE_JPEG, fileName, Units.doubleToFixedPoint(w),
					Units.doubleToFixedPoint(h));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return titleRun;
	}

}
