package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

public class SheetPanel extends BorderPanel{
    
    public SheetPanel(CurrentCell c, Sheet sheet, int rows, int columns) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, c, sheet));
    }
}