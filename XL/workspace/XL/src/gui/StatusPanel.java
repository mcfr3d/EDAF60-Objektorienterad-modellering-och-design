package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel{
    protected StatusPanel(StatusLabel statusLabel, CurrentCell c) {
        add(WEST, new CurrentLabel(c));
        add(CENTER, statusLabel);
    }
}