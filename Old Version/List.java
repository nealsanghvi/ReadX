import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
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
            int numsheets = w.getNumberOfSheets();
            for (int k = 0; k < numsheets; k++) {

                Sheet sheet = w.getSheet(k);
                int nameint = 0;
                int altnameint = 0;

                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, 0);
                    CellType type = cell.getType();
                    if (cell.getContents().equals("NAME")) {
                        nameint = j;
                    }
                    else if (cell.getContents().equals("ALT_NAME")) {
                        altnameint = j;
                    }
                }

                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(nameint, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        allnames.add(cell.getContents());

                    }
                }

                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(altnameint, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        allnames.add(cell.getContents());
                    }

                }

            }


        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllNames() {
        return allnames;
    }

    public void reader() throws IOException {
        List test = new List();
        test.setInputFile("/Users/nealsanghvi/Desktop/ReadX/uploads/datasettest.xls");
        test.read();
    }

}


	
