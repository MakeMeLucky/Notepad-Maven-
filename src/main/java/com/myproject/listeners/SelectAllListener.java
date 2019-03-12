package com.myproject.listeners;

import com.myproject.app.MyAreaText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAllListener implements ActionListener {
    MyAreaText area;

    public SelectAllListener(MyAreaText area){
        this.area=area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectAllAction();
    }

    private void selectAllAction(){
        area.grabFocus();
        area.selectAll();
    }
}
