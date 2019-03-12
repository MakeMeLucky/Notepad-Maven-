package com.myproject.listeners;

import com.myproject.app.MyAreaText;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyTextAreaListener implements DocumentListener{
    private MyAreaText area;

    public MyTextAreaListener(MyAreaText area){
        this.area=area;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        area.setSaved(false);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        area.setSaved(false);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        area.setSaved(false);
    }

}
