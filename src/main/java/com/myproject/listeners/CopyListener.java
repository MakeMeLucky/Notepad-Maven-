package com.myproject.listeners;

import com.myproject.app.MyAreaText;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class CopyListener implements ActionListener {
    MyAreaText area;

    public CopyListener(MyAreaText area) {
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textCopyAction();
    }

    private void textCopyAction(){
        StringSelection selection=new StringSelection(area.getSelectedText());
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection,selection);
    }
}
