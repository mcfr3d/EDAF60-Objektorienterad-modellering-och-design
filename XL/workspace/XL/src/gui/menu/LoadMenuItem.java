package gui.menu;

import gui.XL;
import model.Sheet;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {

    public LoadMenuItem(Sheet sheet, XL xl) {
        super(sheet, xl, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        try {
            sheet.load(path);
            xl.setEditorText(xl.currentCellString());
            xl.setStatusText("Loaded file: " + path);
        } catch (FileNotFoundException f) {
            xl.setStatusText("File not found: " + path);
        } catch (IOException e) {
            xl.setStatusText(e.getMessage());
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}