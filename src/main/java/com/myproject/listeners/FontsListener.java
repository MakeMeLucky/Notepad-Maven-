package com.myproject.listeners;

import com.myproject.app.FontsSettDialog;
import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontsListener implements ActionListener {
    private NotepadWindow window;
    private MyAreaText area;

    public FontsListener(NotepadWindow window, MyAreaText area) {
        this.window = window;
        this.area=area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FontsSettDialog fonDialog=new FontsSettDialog(window,area);
    }
}
