/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greip.api.util.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;

public class UtlFile {
	public static void crearPath(String path) {
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
	}

	public static String obtenerExtensionArchivo(File file) {
		String nombreConExtension = file.getName();
		int tamanoCompleto = nombreConExtension.length();
		return "";
	}

	public static void renombrarArchivo(File archivoInicial, String nombreFinal) {
		File newFile = new File(archivoInicial.getParent() + nombreFinal);
		archivoInicial.renameTo(newFile);
	}

	public static void renombrarDirectorio(File directorioInicial, String nombreFinal) {

		File newDirectorio = new File(directorioInicial.getParent() + nombreFinal);
		directorioInicial.renameTo(newDirectorio);
	}

	public static File convertirStringToFile(String cadena) {
		File f = null;

		return f;
	}

	public static String convertirFileToString(File archivo) {

		String content = null;
		try {
			content = FileUtils.readFileToString(archivo, "ISO-8859-1");
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return content;
		}

	}

	public static void comprimirArchivo(String archivoDescomprimido) {
		try {
			File f = new File(archivoDescomprimido);
			ZipOutputStream os = new ZipOutputStream(new FileOutputStream(f.getParent() + f.getName() + ".zip"));
			os.setLevel(Deflater.DEFAULT_COMPRESSION);
			os.setMethod(Deflater.DEFLATED);

			ZipEntry entrada = new ZipEntry(new File(archivoDescomprimido).getName());
			os.putNextEntry(entrada);

			FileInputStream fis = new FileInputStream(archivoDescomprimido);
			byte[] buffer = new byte[1024];
			int leido = 0;
			while (0 < (leido = fis.read(buffer))) {
				os.write(buffer, 0, leido);
			}

			fis.close();
			os.closeEntry();

			os.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String obtenerUltimoNivel(String rutaInicial) {
		File f = new File(rutaInicial);
		File fN = new File(rutaInicial + "\\" + f.list()[0]);
		String salida = "";

		if (fN.isDirectory()) {
			salida = obtenerUltimoNivel(fN.getAbsolutePath());
		} else {
			return fN.getParent();
		}
		return salida;

	}

	public static String[] archivosAComprimir() {
		File f = new File("D:\\test\\");
		String[] sL = new String[f.list().length];
		for (int i = 0; i < f.list().length; i++) {
			sL[i] = "D:/test/" + f.list()[i];

		}
		comprimirArchivo("D:\\test\\tres.zip", sL);
		return f.list();

	}

	public static void comprimirArchivo(String salidaComprimido, String... archivosDescomprimidos) {
		try {
			File f = new File(salidaComprimido);
			ZipOutputStream os = new ZipOutputStream(new FileOutputStream(f.getParent() + f.getName()));
			os.setLevel(Deflater.DEFAULT_COMPRESSION);
			os.setMethod(Deflater.DEFLATED);

			for (String arc : archivosDescomprimidos) {
				ZipEntry entrada = new ZipEntry(new File(arc).getName());
				os.putNextEntry(entrada);

				FileInputStream fis = new FileInputStream(arc);
				byte[] buffer = new byte[1024];
				int leido = 0;
				while (0 < (leido = fis.read(buffer))) {
					os.write(buffer, 0, leido);
				}

				fis.close();
				os.closeEntry();
			}
			os.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public static void descomprimirArchivo(String archivoComprimido) {
		try {

			ZipInputStream zis = new ZipInputStream(new FileInputStream(archivoComprimido));
			ZipEntry entrada;
			while (null != (entrada = zis.getNextEntry())) {
				FileOutputStream fos = new FileOutputStream(
						new File(archivoComprimido).getParent() + entrada.getName());
				int leido;
				byte[] buffer = new byte[1024];
				while (0 < (leido = zis.read(buffer))) {
					fos.write(buffer, 0, leido);
				}
				fos.close();
				zis.closeEntry();
			}
			zis.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	/**
	 * @param archivoDestino Archivo donde copiar el Archivo Origen
	 * @param archivoOrigen  Archivo a copiar
	 * @throws IOException
	 */
	public static void copiarArchivoHD(File archivoDestino, File archivoOrigen) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(archivoDestino);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			FileInputStream isr = new FileInputStream(archivoOrigen);
			BufferedInputStream bis = new BufferedInputStream(isr);
			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			isr.close();
			bis.close();
			bos.close();
			bos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copiarArchivoHD(File archivoDestino, byte[] archivo) throws FileNotFoundException, IOException {
		FileOutputStream fos;
		BufferedOutputStream bos;

		fos = new FileOutputStream(archivoDestino);
		bos = new BufferedOutputStream(fos);
		fos.write(archivo);
		bos.close();
		bos.flush();

	}

	static public void comprimirCarpeta(String carpetaComprimir, String zipSalida) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(zipSalida);
		zip = new ZipOutputStream(fileWriter);

		addFolderToZip("", carpetaComprimir, zip);
		zip.flush();
		zip.close();
	}

	static private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
		}
	}

	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {
			if (path.equals("")) {
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}

	static public String generarCheckSumSha1(String filepath) {
		String checksum = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

			FileInputStream fileInput = new FileInputStream(filepath);
			byte[] dataBytes = new byte[1024];

			int bytesRead = 0;

			while ((bytesRead = fileInput.read(dataBytes)) != -1) {
				messageDigest.update(dataBytes, 0, bytesRead);
			}

			byte[] digestBytes = messageDigest.digest();

			StringBuffer sb = new StringBuffer("");

			for (int i = 0; i < digestBytes.length; i++) {
				sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			checksum = sb.toString();

			fileInput.close();
		} catch (Exception ex) {

		}
		return checksum;
	}

	/**
	 * Lee un archivo plano y carga las lineas en un Stringbuffer
	 * 
	 * @param file nombre del archivo con la ruta
	 * @return Stringbuffer
	 */
	static public StringBuffer leerArchivo(String file) {
		StringBuffer st = new StringBuffer();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(file);

			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				st.append(linea);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// System.out.println(st);
		return st;
	}

	static public char[] convertClobToCharArray(Clob pClob) {

		if (pClob == null) {
			return null;
		}

		char clobVal[] = null;
		try {
			clobVal = new char[(int) pClob.length()];
			Reader r = pClob.getCharacterStream();
			r.read(clobVal);
			StringWriter sw = new StringWriter();
			sw.write(clobVal);
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clobVal;
	}

	static public byte[] convertBlobToByteArray(Blob pBlob) {

		if (pBlob == null) {
			return null;
		}

		byte blobVal[] = null;
		try {
			blobVal = new byte[(int) pBlob.length()];
			InputStream blobIs = pBlob.getBinaryStream();
			blobIs.read(blobVal);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bos.write(blobVal);
			blobIs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blobVal;
	}

	/**
	 * Codificar un Arreglo de Bytes en Base64
	 * 
	 * @param bytesArray
	 * @return bytesArray codificado en Base64
	 */
	static public byte[] convertBytesArrayToBase64(byte[] bytesArray) {
		byte[] bytes = Base64.getEncoder().encode(bytesArray);
		return bytes;
	}

	/**
	 * Decodifica un Base64 en un arreglo de bytes (byte[])
	 * 
	 * @param encodeBytes arreglo de bytes codificado en Base64
	 * @return arreglo de bytes decodificado
	 */
	static public byte[] convertBase64ToBytesArray(byte[] base64) {
		byte[] bytes = Base64.getDecoder().decode(base64);
		return bytes;
	}

	/**
	 * Convertir un File en un arreglo de bytes (byte[])
	 * 
	 * @param file File inputFile = new File("D:\\Sysde
	 *             International\\imagen_test.png");
	 * @return Arreglo de Bytes (byte[])
	 */
	static public byte[] convertFileToBytesArray(File file) {
		byte[] bytes;
		try {
			bytes = convertBase64ToBytesArray(FileUtils.readFileToByteArray(file));
			return bytes;
		} catch (IOException e) {
			new Exception("UtlFile: Error al convertir un File en un Arreglo de Bytes", e);
			return null;
		}
	}

	/**
	 * Convierte un File en un byte[] codificado Base64
	 * 
	 * @param file
	 * @return Arreglo de bytes codificado en Base64
	 */
	static public byte[] convertFileToBase64(File file) {
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error al convertir un File en un Base64", e);
			return null;
		}
	}

	/**
	 * Escribe en el disco duro un byte[] codificado en Base64
	 * 
	 * @param outputFile
	 * @param encodeBytes
	 */
	static public void writeBase64ToHardDisc(File outputFile, byte[] encodeBytes) {
		try {
			FileUtils.writeByteArrayToFile(outputFile, encodeBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error al escribir el arreglo de bytes codificado en el disco duro", e);
		}
	}

	/**
	 * Escribe en el disco duro un byte[] sin descodificado
	 * 
	 * @param outputFile
	 * @param array      bytes
	 */
	static public void writeBytesArrayToHardDisc(File outputFile, byte[] arrayBytes) {
		try {
			FileUtils.writeByteArrayToFile(outputFile, arrayBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error al escribir el arreglo de bytes codificado en el disco duro", e);
		}
	}

	/**
	 * Escribe en el disco duro un byte[] sin descodificado
	 * 
	 * @param outputFile
	 * @param array      bytes
	 */
	static public void writeBlobToHardDisc(File outputFile, Blob blob) {
		try {
			FileUtils.writeByteArrayToFile(outputFile, convertBlobToByteArray(blob));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error al escribir el arreglo de bytes codificado en el disco duro", e);
		}
	}

	/**
	 * Convierte un arreglo de byte (byte[]) en un Blob
	 * 
	 * @param bytesArray
	 * @return blob
	 */
	static public Blob convertBytesArrayToBlob(byte[] bytesArray) {
		try {
			Blob blob = new SerialBlob(bytesArray);
			return blob;
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error convertir un arreglo de bytes en un blob", e);
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Exception("UtlFile: Error convertir un arreglo de bytes en un blob", e);
			return null;
		}
	}

	public static void copiarDirectorio(File dirBase, File dirFinal) {
		try {
			FileUtils.copyDirectory(dirBase, dirFinal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void replaceTextOnFile(File file, String oldText, String newText) {
		try {
			
			String totalStr = UtlFile.convertirFileToString(file);
			totalStr = totalStr.replaceAll(oldText, newText);
			FileWriterWithEncoding fw = new FileWriterWithEncoding(file,"ISO-8859-1");
			fw.write(totalStr);
			fw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] arg) { File inputFile = new
	 * File("D:\\Sysde International\\imagen_test.png"); byte[] b =
	 * convertFileToBytesArray(inputFile); System.out.println(b);
	 * System.out.println(convertBytesArrayToBase64(b)); }
	 */

}
