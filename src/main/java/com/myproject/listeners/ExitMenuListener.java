package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuListener implements ActionListener {
    private MyAreaText area;
    private NotepadWindow window;

    public ExitMenuListener(NotepadWindow window, MyAreaText area) {
        this.area = area;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(window, "Exit?") == JOptionPane.YES_OPTION) {
            saveFile();
        }
    }

    void saveFile() {
            if (!area.getSaved()) {
                int answer = JOptionPane.showConfirmDialog(window, "Save?");
                if (answer == 0) {
                    SaveAsFileListener saveA = new SaveAsFileListener(window, area);
                    saveA.saveAsFile("C:");

                } else if (answer == 1) {
                    System.exit(0);
                }
                else if(answer==2){
                    window.setDefaultCloseOperation(window.DO_NOTHING_ON_CLOSE);
                }
            } else System.exit(0);
    }
}