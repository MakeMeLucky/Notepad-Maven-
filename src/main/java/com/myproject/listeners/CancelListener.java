package com.myproject.listeners;

import com.myproject.app.MyAreaText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    MyAreaText area;

    public CancelListener(MyAreaText area){
        this.area=area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        area.cancelActionText();
    }
}
