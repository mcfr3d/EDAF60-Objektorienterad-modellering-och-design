package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
import model.Sheet;
import model.expr.Adress;
import util.XLException;

public class Editor extends JTextField implements Observer {
    private Sheet sheet;
    private CurrentCell current;

    public Editor(Sheet sheet, CurrentCell current) {
        this.sheet = sheet;
        this.current = current;
        current.addObserver(this);
        setBackground(Color.WHITE);
        this.addActionListener(new ActionClass());
    }

    private class ActionClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = Editor.this.getText();
            Editor.this.current.addCellToSheet(s);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            sheet.add(((Adress) arg), Editor.this.getText());
            setText(((CurrentCell) o).getValue());
        } catch (XLException e) {
            setText(((CurrentCell) o).getValue());
        }
    }
}