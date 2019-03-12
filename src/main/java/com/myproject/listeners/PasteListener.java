package com.myproject.listeners;

import com.myproject.app.MyAreaText;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.SimpleAttributeSet;

public class PasteListener implements ActionListener {
    MyAreaText area;

    public PasteListener(MyAreaText area){
        this.area=area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textPasteAction();
    }

    private void textPasteAction(){
        try {
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            area.getDocument().insertString(area.getCaretPosition(), data, SimpleAttributeSet.EMPTY);
        }catch (Exception ex) {ex.printStackTrace();}
    }
}
