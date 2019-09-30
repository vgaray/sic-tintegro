package pe.com.tintegro.services.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.processing.SupportedOptions;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import pe.com.tintegro.dominio.Mapeo;
import pe.com.tintegro.dto.response.ValidaExcelResponse;

public class ExcelUtil
{

	public static List<?> listarObjectos(String nombreClase, org.springframework.core.io.Resource csvResource, String excelBase64) throws Exception
	{
		Class<?> c;

		File fcsv;
		byte[] fexcel;

		FileReader fr;
		BufferedReader br;

		// InputStream isexcel = null;

		Map<String, String> mapeoCabeceraPropiedad;
		List<Object> objectosLista = new ArrayList<Object>();
		try
		{

			fcsv = UtilFile.leerResource(csvResource, "tempo", ".csv");
			fexcel = UtilFile.decodificar(excelBase64);
			InputStream myInputStream = new ByteArrayInputStream(fexcel);
			fr = new FileReader(fcsv);
			br = new BufferedReader(fr);

			// isexcel = new FileInputStream(fexcel);

			// Lectura de Archivo Excel Terminal .xls
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(myInputStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRow;
			String cellValue = null;
			Field variablex = null;
			mapeoCabeceraPropiedad = leerCabeceraPropiedadCSV(br);
			int rows = hssfSheet.getLastRowNum();
			Map<String, String> cabecera = new HashMap<String, String>();

			for (int r = 0; r <= rows; r++)
			{
				boolean statusRow = true;
				hssfRow = hssfSheet.getRow(r);
				if (hssfRow == null)
				{
					break;
				}
				else
				{
					c = Class.forName(nombreClase);
					Object objPersona = (Object) c.newInstance();
					HSSFCell cell;
					for (int column = 0; column < (hssfRow.getLastCellNum()); column++)
					{
						cell = hssfRow.getCell(column);

						if (cell == null)
						{
							cellValue = "";
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						{
							cellValue = cell.getStringCellValue();
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
						{
							double value = cell.getNumericCellValue();
							int difference = (int) (value * 10 - ((int) value) * 10);

							if (difference == 0)
								cellValue = String.format("%d", (int) value);
							else
								cellValue = Double.toString(value);
						}
						else if (cell.getBooleanCellValue())
						{
							cellValue = String.format("%s", cell.getBooleanCellValue());
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_BLANK)
						{
							cellValue = String.format("%s", cell.getStringCellValue());
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_ERROR)
						{
							cellValue = "ERROR";
						}

						String columna = "Column" + column;
						System.out.println(columna);
						if (r == 0)
						{
							cabecera.put(columna, cellValue);
						}

						if (r > 0)
						{
							if (!(column == 0 && cellValue.equals("")))
							{
								System.out.println(cabecera.get(columna) + "");
								variablex = c.getDeclaredField(mapeoCabeceraPropiedad.get(cabecera.get(columna)));
								variablex.setAccessible(true);
								variablex.set(objPersona, cellValue);

							}
							else
							{
								statusRow = false;
							}
						}

					}

					if (r > 0)
					{
						if (statusRow)
						{
							objectosLista.add(objPersona);
						}

					}

					System.out.println(cellValue);
					System.out.println();
				}
			}

		}
		catch (Exception e)
		{
			throw e;
		}

		return objectosLista;
	}

	public static Map<String, String> leerCabeceraPropiedadCSV(BufferedReader br) throws Exception
	{
		Map<String, String> cabeceraPropiedad = new HashMap<String, String>();
		String linea = "";
		while ((linea = br.readLine()) != null)
		{
			String[] cadenas = linea.split(",");
			cabeceraPropiedad.put(cadenas[0], cadenas[3]);

		}

		return cabeceraPropiedad;
	}

	public static String generarExcel(org.springframework.core.io.Resource csvResource, List<?> objectList) throws Exception
	{
		File fcsv;
		FileReader fr;
		BufferedReader br;
		OutputStream excelNewOutputStream = null;

		HSSFWorkbook hssfWorkbookNew = null;
		HSSFSheet hssfSheetNew;
		HSSFRow hssfRowNew;
		HSSFCell cellNew;
		String fileString = null;

		Map<String, Mapeo> maps;
		Map<Integer, Mapeo> cabecera;
		try
		{

			fcsv = UtilFile.leerResource(csvResource, "tempo", ".csv");
			fr = new FileReader(fcsv);
			br = new BufferedReader(fr);
			maps = leerCSV(br);
			cabecera = mapeoCabecera(maps);
			File excelNew = new File("temFile.xls");
			excelNewOutputStream = new FileOutputStream(excelNew);

			hssfWorkbookNew = new HSSFWorkbook();
			hssfSheetNew = hssfWorkbookNew.createSheet("EscrituraLista");

			HSSFCellStyle style = hssfWorkbookNew.createCellStyle();

			HSSFFont font = hssfWorkbookNew.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 10);
			font.setFontName("Arial");

			style.setFont(font);

			HSSFCellStyle datastyle = hssfWorkbookNew.createCellStyle();
			HSSFFont fontdata = hssfWorkbookNew.createFont();
			fontdata.setFontHeightInPoints((short) 10);
			fontdata.setFontName("Arial");

			datastyle.setFont(fontdata);

			int columnas = maps.size();

			for (int row = 0; row <= objectList.size(); row++)
			{
				hssfRowNew = hssfSheetNew.createRow(row);

				for (int columns = 0; columns < columnas; columns++)
				{
					hssfSheetNew.autoSizeColumn(columns, true);
					if (row == 0)
					{

						cellNew = hssfRowNew.createCell(columns);
						cellNew.setCellType(Cell.CELL_TYPE_STRING);
						cellNew.setCellStyle(style);

						cellNew.setCellValue(obtenerClavedeValor(maps, cabecera.get(columns)).toString());

					}

					else
					{

						cellNew = hssfRowNew.createCell(columns);

						Field variableString = objectList.get((row - 1)).getClass().getDeclaredField(cabecera.get(columns).getNombrePropiedad());
						variableString.setAccessible(true);
						String valor = "";
						if (variableString.get(objectList.get(row - 1)) != null)
						{
							valor = variableString.get(objectList.get(row - 1)).toString();
						}

						cellNew.setCellType(Cell.CELL_TYPE_STRING);
						cellNew.setCellStyle(datastyle);
						cellNew.setCellValue(valor);
					}

				}

			}

			hssfWorkbookNew.write(excelNewOutputStream);
			excelNewOutputStream.close();
			fileString = UtilFile.codificarToBase64(excelNew);

			System.out.println("Your excel file has been generated!(¡Se ha generado tu hoja excel!)");

		}
		catch (Exception e)
		{
			throw e;
		}
		return fileString;
	}

	public static Map<String, Mapeo> leerCSV(BufferedReader br) throws Exception
	{
		Map<String, Mapeo> cabeceraMapeo = new HashMap<String, Mapeo>();
		String linea = "";
		int i = 0;
		while ((linea = br.readLine()) != null)
		{
			String[] cadenas = linea.split(",");
			Mapeo mapeo = new Mapeo();
			mapeo.setNombreColumna(cadenas[0]);
			mapeo.setTipoDato(cadenas[1]);
			mapeo.setObligatorio(Integer.parseInt(cadenas[2]));
			mapeo.setNombrePropiedad(cadenas[3]);
			mapeo.setPosicion(i);
			cabeceraMapeo.put(cadenas[0], mapeo);
			i++;
		}

		return cabeceraMapeo;
	}

	public static Map<Integer, Mapeo> mapeoCabecera(Map<String, Mapeo> maps)
	{
		Map<Integer, Mapeo> mapas = new HashMap<Integer, Mapeo>();
		Iterator<String> it = maps.keySet().iterator();
		while (it.hasNext())
		{
			String key = (String) it.next();
			mapas.put(maps.get(key).getPosicion(), maps.get(key));
		}

		return mapas;
	}

	public static Object obtenerClavedeValor(Map<String, Mapeo> hm, Object value)
	{
		for (Object o : hm.keySet())
		{
			if (hm.get(o).equals(value))
			{
				return o;
			}
		}
		return null;
	}

	public static ValidaExcelResponse compararCSVconExcel(org.springframework.core.io.Resource csvResource, String excelBase64) throws Exception
	{
		ValidaExcelResponse response = new ValidaExcelResponse();
		Map<String, String> cabecera = new HashMap<String, String>();

		File fcsv;
		byte[] fexcel;

		FileReader fr;
		BufferedReader br;

		int valida = 0;

		List<String> listaErrores = new ArrayList<String>();
		listaErrores.clear();
		try
		{

			fcsv = UtilFile.leerResource(csvResource, "tempo", ".csv");
			fexcel = UtilFile.decodificar(excelBase64);
			InputStream myInputStream = new ByteArrayInputStream(fexcel);
			fr = new FileReader(fcsv);
			br = new BufferedReader(fr);
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(myInputStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRow;

			int rows = hssfSheet.getLastRowNum();
			String cellValue = "";

			Map<String, Mapeo> mapeoMap = leerCSV(br);
			Map<Integer, Mapeo> mapeoCab = mapeoCabecera(mapeoMap);

			int columnas = 0;
			int status = 0;
			for (int r = 0; r <= rows; r++)
			{

				hssfRow = hssfSheet.getRow(r);
				if (hssfRow == null)
				{
					break;
				}
				else
				{
					HSSFCell cell;

					for (int c = 0; c < (columnas = hssfRow.getLastCellNum()); c++)
					{
						cell = hssfRow.getCell(c);
						if (cell == null)
						{
							cellValue = "";
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						{
							cellValue = cell.getStringCellValue();
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
						{
							double value = cell.getNumericCellValue();
							int difference = (int) (value * 10 - ((int) value) * 10);

							if (difference == 0)
								cellValue = String.format("%d", (int) value);
							else
								cellValue = Double.toString(value);
						}
						else if (cell.getBooleanCellValue())
						{
							cellValue = String.format("%s", cell.getBooleanCellValue());
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_BLANK)
						{
							cellValue = String.format("%s", cell.getStringCellValue());
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_ERROR)
						{
							cellValue = "ERROR";
						}

						String columna = "Column" + c;
						if (r == 0)
						{

							cabecera.put(columna, cellValue);
							if (c == columnas - 1)
							{
								if (cabecera.size() != mapeoMap.size())
								{
									listaErrores.add("El numero de columnas del archivo excel no es igual al archivo csv");

								}

								for (int i = 0; i < mapeoMap.size(); i++)
								{
									if (!(cabecera.get("Column" + i).equals(mapeoCab.get(i).getNombreColumna())))
									{
										listaErrores.add("El nombre de cabecera del archivo excel de la columna " + (i + 1) + " no es el correcto");
									}
								}
								if (listaErrores.size() > 0)
								{

									// response.setListaErrores(listaErrores);
									status = 1;
									break;
								}
							}

						}

						else
						{

							if (mapeoMap.get(cabecera.get(columna)).getTipoDato().equals("integer"))
							{
								if (!Validadores.esNumero(cellValue))
								{
									if (mapeoMap.get(cabecera.get(columna)).getObligatorio() == 1 && cellValue.isEmpty())
									{
										listaErrores.add("En la columna " + cabecera.get(columna) + " de la fila [" + (r + 1) + "] no existe número");
									}
									if (!cellValue.isEmpty() && !Validadores.esNumero(cellValue))
									{
										listaErrores.add("En la columna " + cabecera.get(columna) + " de la fila [" + (r + 1) + "] no es un número ");
									}

								}

							}
							if (mapeoMap.get(cabecera.get(columna)).getTipoDato().equals("string"))
							{
								if (!Validadores.esLetra(cellValue))
								{
									if (mapeoMap.get(cabecera.get(columna)).getObligatorio() == 1)
									{

										listaErrores.add("En la columna " + cabecera.get(columna) + " de la fila [" + (r + 1) + "] no es una palabra");

									}

								}

							}
						}

					}
					if (status == 1)
					{

						break;
					}
				}

			}

			myInputStream.close();

			if (listaErrores.size() > 0)
			{
				valida = 0;
				response.setListaErrores(listaErrores);
			}

			else
			{
				valida = 1;
				response.setListaErrores(listaErrores);
			}
		}
		catch (Exception e)
		{

			// valida=0;

			throw e;

		}

		response.setEstado(valida);
		return response;

	}

	public String formatearCelda(HSSFCell cell)
	{
		String cellValue = "";
		if (cell == null)
		{
			cellValue = "";
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		{
			cellValue = cell.getStringCellValue();
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
		{
			double value = cell.getNumericCellValue();
			int difference = (int) (value * 10 - ((int) value) * 10);

			if (difference == 0)
				cellValue = String.format("%d", (int) value);
			else
				cellValue = Double.toString(value);
		}
		else if (cell.getBooleanCellValue())
		{
			cellValue = String.format("%s", cell.getBooleanCellValue());
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_BLANK)
		{
			cellValue = String.format("%s", cell.getStringCellValue());
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_ERROR)
		{
			cellValue = "ERROR";
		}
		return cellValue;
	}

}
