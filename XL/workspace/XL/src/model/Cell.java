package model;

import util.XLException;

public class Cell {
    private CellValue cv;
    private Sheet sheet;

    public Cell(String value, Sheet sheet) {
        this.sheet = sheet;
        setValue(value);
    }

    public double value() {
        return cv.value();
    }

    public void setValue(String value) throws XLException {
        CellValue oldValue = cv;
        cv = new Error("Circular expression");
        try {
            CellValue newCv = CellValueFactory.makeCellValue(value, sheet);
            newCv.value();
            cv = newCv;

        } catch (XLException xl) {
            if (oldValue != null) {
                cv = oldValue;
            }
            throw xl;

        }

    }

    public String toString() {
//        if (cv != null) {
            return cv.toString();
//        }
//        return "";
    }
}
