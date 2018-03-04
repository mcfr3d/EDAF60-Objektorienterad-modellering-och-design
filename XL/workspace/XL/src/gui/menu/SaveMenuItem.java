package gui.menu;

import gui.XL;
import model.Sheet;
import util.XLPrintStream;
import java.io.FileNotFoundException;


import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(Sheet sheet, XL xl) {
        super(sheet, xl, "Save");
    }

    protected void action(String path){
        try{
            XLPrintStream xlp = new XLPrintStream(path);
            xlp.save(sheet.getSheet());
            xl.setStatusText("Saved to: " + path);
            xlp.close();
        }catch(FileNotFoundException f){
            xl.setStatusText("File not found: " + path);
        }
        
//        statusLabel.setText("Saved to: " + path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}