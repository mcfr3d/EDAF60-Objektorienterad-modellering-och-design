package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.SwingConstants;

import model.Cell;
import model.Sheet;
import model.expr.Adress;
import util.XLException;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private int index = 0;
    CurrentCell c;

    public SlotLabels(int rows, int cols, CurrentCell c, Sheet sh) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel();
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        addMouseListener(new Mouseclass());
        this.c = c;
        c.addObserver(this);
        sh.addObserver(this);

    }

    private class Mouseclass extends MouseAdapter {
        public void mouseClicked(MouseEvent w) {
            Object slot = w.getComponent().getComponentAt(getMousePosition());
            if (slot instanceof SlotLabel) {
                labelList.get(index).setBackground(Color.WHITE);
                ((SlotLabel) slot).setBackground(Color.YELLOW);
                index = labelList.indexOf(slot);
                c.setCurrentCell(new Adress(indexToAdress(index)));
            }
        }
        private String indexToAdress(int index){
            int rad = 1 + (index / 8);
            char column = (char) ('A' + index % 8);
            return  "" + column + rad;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CurrentCell) {
            // try{
            labelList.get(index).setText(c.getCellString());
            // }
            // catch(XLException e){
            // System.out.println("Hej från slotlabels");
            // labelList.get(index).setText(e.getMessage());
            //// c.clearEditorText();
            // }
        }

        else if (o instanceof Sheet) {
            for (SlotLabel s : labelList) {
                s.setText("");
            }
            Set<Entry<Adress, Cell>> set = ((Set<Entry<Adress, Cell>>) arg);
            if (set != null) {
                for (Entry<Adress, Cell> entry : set) {
                    int numberOfCell = adressToIndex(entry.getKey().toString());
                    SlotLabel curr = labelList.get(numberOfCell);
                    if (entry.getValue().toString().charAt(0) != '#') {
                        curr.setText("" + entry.getValue().value());
                    } else {
                        curr.setText(entry.getValue().toString().substring(1));
                    }
                }
            }
        }

    }

    private int adressToIndex(String string) {
        int b;
        int a = (string.charAt(0) - 'A');
        if (string.length() != 3) {
            b = (string.charAt(1) - '1') * 8;
        } else {
            b = 72;
        }
        return a + b;
    }
}
