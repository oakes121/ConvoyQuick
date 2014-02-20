/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdftest;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateConvoyPDF {
    
    /** The resulting PDF file. */
    public static final String RESULT
        = "test\\pdftest\\testOuput\\ConvoyPDF.pdf";
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        new CreateConvoyPDF().createPdf(RESULT);
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        
        document.setHtmlStyleClass("");
        // step 3
        document.open();
        
        
        // step 4
        
        PdfPTable misionInfoTable = CreateMisionInfoTable();        
        PdfPTable vehicleGridTopRowTable = CreateVehicleGridTopRowTable();
        PdfPTable vehicleGridBottomRowTable = CreateVehicleGridBottomRowTable();
        PdfPTable AdditionalInfoTable = CreateAdditionalInfoTable();        
        
        misionInfoTable.setSpacingBefore(10);
        
        vehicleGridTopRowTable.setSpacingBefore(5);
        
        AdditionalInfoTable.setSpacingBefore(5);
        AdditionalInfoTable.setSpacingAfter(10);
        
        document.add(misionInfoTable);
        document.add(vehicleGridTopRowTable);
        document.add(vehicleGridBottomRowTable);
        document.add(AdditionalInfoTable);
        
        // step 5
        document.close();
    }
 
    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable CreateMisionInfoTable() {
    	// a table with one columns
        PdfPTable misionInfoTable = new PdfPTable(2);
        // the cell object
        PdfPCell leftMissionInfoCell, rightMissionInfoCell;
        // we add a cell with colspan 
        leftMissionInfoCell = new PdfPCell(new Phrase("leftMissionInfoCell"));
        rightMissionInfoCell = new PdfPCell(new Phrase("leftMissionInfoCell"));
        //cell.setColspan(3);
        misionInfoTable.addCell(leftMissionInfoCell);
        misionInfoTable.addCell(rightMissionInfoCell);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //table.addCell("vehicle Grid");
        //table.addCell("additional Info");
        //table.addCell("row 2; cell 1");
        //table.addCell("row 2; cell 2");
        return misionInfoTable;
    }
    
    public static PdfPTable CreateVehicleGridTopRowTable() {
    	// a table with one columns
        PdfPTable VehicleGrid = new PdfPTable(4);
        // the cell object
        PdfPCell vehicleCell1, vehicleCell2, vehicleCell3, vehicleCell4;
        // we add a cell with colspan 
        vehicleCell1 = new PdfPCell(new Phrase("vehicle1"));
        vehicleCell2 = new PdfPCell(new Phrase("vehicle2"));
        vehicleCell3 = new PdfPCell(new Phrase("vehicle3"));
        vehicleCell4 = new PdfPCell(new Phrase("vehicle4"));
       
        //cell.setColspan(3);
        VehicleGrid.addCell(vehicleCell1);
        VehicleGrid.addCell(vehicleCell2);
        VehicleGrid.addCell(vehicleCell3);
        VehicleGrid.addCell(vehicleCell4);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //table.addCell("vehicle Grid");
        //table.addCell("additional Info");
        //table.addCell("row 2; cell 1");
        //table.addCell("row 2; cell 2");
        return VehicleGrid;
    }
    
    public static PdfPTable CreateVehicleGridBottomRowTable() {
    	// a table with one columns
        PdfPTable VehicleGrid = new PdfPTable(4);
        // the cell object
        PdfPCell vehicleCell1, vehicleCell2, vehicleCell3, vehicleCell4;
        // we add a cell with colspan 
        vehicleCell1 = new PdfPCell(new Phrase("vehicle5"));
        vehicleCell2 = new PdfPCell(new Phrase("vehicle6"));
        vehicleCell3 = new PdfPCell(new Phrase("vehicle7"));
        vehicleCell4 = new PdfPCell(new Phrase("vehicle8"));
        //cell.setColspan(3);
        VehicleGrid.addCell(vehicleCell1);
        VehicleGrid.addCell(vehicleCell2);
        VehicleGrid.addCell(vehicleCell3);
        VehicleGrid.addCell(vehicleCell4);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //table.addCell("vehicle Grid");
        //table.addCell("additional Info");
        //table.addCell("row 2; cell 1");
        //table.addCell("row 2; cell 2");
        return VehicleGrid;
    }
    
    public static PdfPTable CreateAdditionalInfoTable() {
    	// a table with one columns
        PdfPTable table = new PdfPTable(1);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 
        cell = new PdfPCell(new Phrase("Additional Information"));
        //cell.setColspan(3);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //table.addCell("vehicle Grid");
        //table.addCell("additional Info");
        //table.addCell("row 2; cell 1");
        //table.addCell("row 2; cell 2");
        return table;
    }
    
}
