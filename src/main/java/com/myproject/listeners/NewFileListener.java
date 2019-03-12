package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class NewFileListener implements ActionListener {

    private NotepadWindow window;
    private MyAreaText area;

    public NewFileListener(NotepadWindow window, MyAreaText area){
        this.window=window;
        this.area=area;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        newFileOpen();
    }

    private void newFileOpen(){
        if(!area.getSaved()){
            if(JOptionPane.showConfirmDialog(window,"Save?")==JOptionPane.YES_OPTION){
                SaveAsFileListener saveA = new SaveAsFileListener(window, area);
                saveA.saveAsFile("C:");
            }
        }

        window.setTitle("New.txt");
        area.setText("");
        area.setSaved(true);
    }
}
