package it.sp.job.inv.utils;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Vector;

import it.sp.job.inv.beans.Record;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelConvert {

	public void create(String inputFile, Object[] columnData, Object[] dati) throws IOException, WriteException {
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("it", "IT"));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Vendita", 0);
		workbook.createSheet("Rotture", 1);
		workbook.createSheet("Uso Interno", 2);
		workbook.createSheet("Svalorizzazione", 3);
		workbook.createSheet("Conto Vendita", 4);
		WritableSheet sheetVendita = workbook.getSheet(0);
		WritableSheet sheetRotture = workbook.getSheet(1);
		WritableSheet sheetUsoInterno = workbook.getSheet(2);
		WritableSheet sheetSvalorizzazione = workbook.getSheet(3);
		WritableSheet sheetContoVendita = workbook.getSheet(4);
		WritableSheet[] sheets = {sheetVendita, sheetRotture, sheetUsoInterno, sheetSvalorizzazione, sheetContoVendita};

		createLabel(sheets, columnData);
		createContent(sheets, dati);

		workbook.write();
		workbook.close();
	}

	private void createLabel(WritableSheet[] sheets, Object[] columnData) throws WriteException {
		CellView cv = new CellView();
		cv.setAutosize(true);
		for(int i=0; i<columnData.length; i++) {
			addCaption(sheets[0], i, 0, columnData[i]);
			addCaption(sheets[1], i, 0, columnData[i]);
			addCaption(sheets[2], i, 0, columnData[i]);
			addCaption(sheets[3], i, 0, columnData[i]);
			addCaption(sheets[4], i, 0, columnData[i]);
		}
	}

	private void addCaption(WritableSheet sheet, int column, int row, Object s) throws RowsExceededException, WriteException {
		String value = String.valueOf(s);
		Label label = new Label(column, row, value);
		sheet.addCell(label);
	}

	private void createContent(WritableSheet[] sheets, Object[] dati) throws WriteException, RowsExceededException {
		CellView cv = new CellView();
		cv.setAutosize(true);
		Vector<Record> vendita = (Vector<Record>) dati[0];
		Vector<Record> rotture = (Vector<Record>) dati[1];
		Vector<Record> usoInterno = (Vector<Record>) dati[2];
		Vector<Record> svalorizzazione = (Vector<Record>) dati[3];
		Vector<Record> contoVendita = (Vector<Record>) dati[4];

		//Riempie il foglio Vendita
		for (int i = 1; i <= vendita.size(); i++) {
			addCaption(sheets[0], 0, i, vendita.get(i-1).getEan());
			addCaption(sheets[0], 1, i, vendita.get(i-1).getArticolo());
			addCaption(sheets[0], 2, i, vendita.get(i-1).getDescrizione());
			addCaption(sheets[0], 3, i, vendita.get(i-1).getGiacenza());
			addCaption(sheets[0], 4, i, vendita.get(i-1).getUnita());
			addCaption(sheets[0], 5, i, vendita.get(i-1).getDeposito());
			addCaption(sheets[0], 6, i, vendita.get(i-1).getNuovo());
		}
		//Riempie il foglio Rotture
		for (int i = 1; i <= rotture.size(); i++) {
			addCaption(sheets[1], 0, i, rotture.get(i-1).getEan());
			addCaption(sheets[1], 1, i, rotture.get(i-1).getArticolo());
			addCaption(sheets[1], 2, i, rotture.get(i-1).getDescrizione());
			addCaption(sheets[1], 3, i, rotture.get(i-1).getGiacenza());
			addCaption(sheets[1], 4, i, rotture.get(i-1).getUnita());
			addCaption(sheets[1], 5, i, rotture.get(i-1).getDeposito());
			addCaption(sheets[1], 6, i, rotture.get(i-1).getNuovo());
		}
		//Riempie il foglio Uso Interno
		for (int i = 1; i <= usoInterno.size(); i++) {
			addCaption(sheets[2], 0, i, usoInterno.get(i-1).getEan());
			addCaption(sheets[2], 1, i, usoInterno.get(i-1).getArticolo());
			addCaption(sheets[2], 2, i, usoInterno.get(i-1).getDescrizione());
			addCaption(sheets[2], 3, i, usoInterno.get(i-1).getGiacenza());
			addCaption(sheets[2], 4, i, usoInterno.get(i-1).getUnita());
			addCaption(sheets[2], 5, i, usoInterno.get(i-1).getDeposito());
			addCaption(sheets[2], 6, i, usoInterno.get(i-1).getNuovo());
		}	
		//Riempie il foglio Svalorizzazioni
		for (int i = 1; i <= svalorizzazione.size(); i++) {
			addCaption(sheets[3], 0, i, svalorizzazione.get(i-1).getEan());
			addCaption(sheets[3], 1, i, svalorizzazione.get(i-1).getArticolo());
			addCaption(sheets[3], 2, i, svalorizzazione.get(i-1).getDescrizione());
			addCaption(sheets[3], 3, i, svalorizzazione.get(i-1).getGiacenza());
			addCaption(sheets[3], 4, i, svalorizzazione.get(i-1).getUnita());
			addCaption(sheets[3], 5, i, svalorizzazione.get(i-1).getDeposito());
			addCaption(sheets[3], 6, i, svalorizzazione.get(i-1).getNuovo());
		}	
		//Riempie il foglio Conto vendita
		for (int i = 1; i <= contoVendita.size(); i++) {
			addCaption(sheets[4], 0, i, contoVendita.get(i-1).getEan());
			addCaption(sheets[4], 1, i, contoVendita.get(i-1).getArticolo());
			addCaption(sheets[4], 2, i, contoVendita.get(i-1).getDescrizione());
			addCaption(sheets[4], 3, i, contoVendita.get(i-1).getGiacenza());
			addCaption(sheets[4], 4, i, contoVendita.get(i-1).getUnita());
			addCaption(sheets[4], 5, i, contoVendita.get(i-1).getDeposito());
			addCaption(sheets[4], 6, i, contoVendita.get(i-1).getNuovo());
		}	
	}
}