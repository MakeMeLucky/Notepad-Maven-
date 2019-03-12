package com.myproject.app;

import com.myproject.listeners.CancelListener;
import com.myproject.listeners.CopyListener;
import com.myproject.listeners.PasteListener;
import com.myproject.listeners.SelectAllListener;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class NotePopup extends JPopupMenu {
    NotePopup(final MyAreaText area){
        JMenuItem  copyEdit=new JMenuItem("Copy");
        JMenuItem  pasteEdit=new JMenuItem("Paste");
        JMenuItem cancelEdit=new JMenuItem("Undo");
        JMenuItem  selectEdit=new JMenuItem("Select all");
        selectEdit.addActionListener(new SelectAllListener(area));
        copyEdit.addActionListener(new CopyListener(area));
        pasteEdit.addActionListener(new PasteListener(area));
        cancelEdit.addActionListener(new CancelListener(area));


        add(copyEdit);
        add(pasteEdit);
        add(cancelEdit);
        add(selectEdit);

        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) show(area,e.getX(),e.getY());
            }
        });
    }
}
