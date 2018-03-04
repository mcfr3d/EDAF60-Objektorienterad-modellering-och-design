package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {

    public CurrentLabel(CurrentCell c) {
        super("A1", Color.WHITE);
        c.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        setText(((CurrentCell) o).toString());
    }
}