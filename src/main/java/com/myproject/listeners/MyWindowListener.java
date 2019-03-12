package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener {
    private NotepadWindow window;
    private MyAreaText area;

    public MyWindowListener(NotepadWindow window, MyAreaText area){
        this.window=window;
        this.area=area;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        ExitMenuListener el=new ExitMenuListener(window,area);
        el.saveFile();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
