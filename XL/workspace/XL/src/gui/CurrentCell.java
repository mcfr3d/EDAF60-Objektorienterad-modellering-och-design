package gui;

import java.util.Observable;

import model.Sheet;
import model.expr.Adress;
import util.XLException;

public class CurrentCell extends Observable {

    private Adress currAdr;
    private XL xl;
    private Sheet sheet;

    public CurrentCell(XL xl, Sheet sh) {
        this.currAdr = new Adress("A1");
        this.xl = xl;
        this.sheet = sh;
    }

    public void setCurrentCell(Adress nxtCurrAdr) {
        Adress prevAdress = currAdr;
        currAdr = nxtCurrAdr;
        update(prevAdress);
    }

    public String getValue() {
        return sheet.getFormula(currAdr);
    }

    public void addCellToSheet(String s) {
        xl.setStatusText("");
        try {
            sheet.add(currAdr, s);
        } catch (XLException e) {
            xl.setStatusText(e.getMessage() + " in " + currAdr.toString());
            // xl.clearEditorText();
            // sheet.addError(currAdr, e.getMessage());

        }
        update(currAdr);
    }

    public String toString() {
        return currAdr.toString();
    }

    public String getCellString() {
        return sheet.stringInCell(currAdr);
    }

    public void update(Adress adress) {
        setChanged();
        notifyObservers(adress);
    }

    public void clear() {
        sheet.clear(currAdr);
    }
}
