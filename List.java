import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.text.Text;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class List {

    private String inputFile;
    private static ArrayList<String> allnames = new ArrayList<>();


    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            int numsheets = w.getNumberOfSheets();

            //RECORDS ALL THE DATA ON THE EXCEL SHEET
            for (int k = 0; k < numsheets; k++) {
                Sheet sheet = w.getSheet(k);
                int nameint = 0;
                int altnameint = 0;
                //System.out.println();

                //IDENTIFIES THE COLUMNS WITH THE NAMES AND ALTERNATE NAMES
                //System.out.println("CURRENTLY ON SLIDE: " + k);
                for (int j = 0; j < sheet.getColumns(); j++) {


                    Cell cell = sheet.getCell(j, 0);
                    CellType type = cell.getType();

                    if (cell.getContents().equals("NAME")) {
                        //System.out.println("NAME was found here: " + j);
                        nameint = j;
                    }

                    else if (cell.getContents().equals("ALT_NAME")) {
                        //System.out.println("ALT_NAME was found here: " + j);
                        altnameint = j;

                    }
                }


                //ADDS THE DATA IN THE COLUMNS TO THE ARRAYLIST

                //NAMES
                int counter = 0;
                //System.out.println("Here is the amount of names in the NAME column: " + sheet.getRows());
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(nameint, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        allnames.add(cell.getContents());
                        counter++;
                    }
                    /*
                  if (type == CellType.NUMBER) {
//                    System.out.println("Number " + cell.getContents());
//                }
                     */
//

                }
                //System.out.println("Amount of times there was actually a name in the list: " + counter);
                //System.out.println("ArrayList size has increased to " + allnames.size());


                //System.out.println();
                //System.out.println("DONE WITH THE NAMES... ON TO THE ALTERNATE NAMES NOW");
                //System.out.println("DONE WITH THE NAMES... ON TO THE ALTERNATE NAMES NOW");
                //System.out.println();

                //ALTERNATE NAMES
                counter = 0;
                //System.out.println("Here is the amount of names in the ALTERNATE NAMES column: " + sheet.getRows());
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(altnameint, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        counter++;
                        allnames.add(cell.getContents());
                    }
                }
                //System.out.println("Amount of times there was actually a name in the list: " + counter);
                //System.out.println("ArrayList size has increased to " + allnames.size());
            }
            //System.out.println();
            //System.out.println();
            //System.out.println("AMOUNT OF ALL NAMES: " + allnames.size());

            //System.out.println("This is the first name in the ArrayList: " + allnames.get(0));
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllNames() {
        return allnames;
    }


    //CHANGE DIRECTORY HERE FOR YOUR OWN EXCEL SHEET. YOUR SHEET SHOULD HAVE A COLUMN 'NAME' AND/OR 'ALT_NAME'
    public void  reader() throws IOException {
        List test = new List();
        test.setInputFile("C:\\Users\\Mekuanent\\Desktop\\ReadX-master\\datasettest.xls");
        test.read();
    }



























//    public static void main(String[] args) throws IOException {
//        List test = new List();
//        test.setInputFile("/Users/nealsanghvi/Desktop/Angelhack/dataset1.xls");
//
//        test.read();
//
////        System.out.println(allnames.get(1));
//
//
//    }
}


	
