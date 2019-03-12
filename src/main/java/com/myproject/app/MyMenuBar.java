package com.myproject.app;

import com.myproject.listeners.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;

class MyMenuBar extends JMenuBar {

    MyMenuBar(NotepadWindow window, MyAreaText area){
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFile=new JMenuItem("New");
        JMenuItem openFile=new JMenuItem("Open");
        JMenuItem saveFile=new JMenuItem("Save");
        JMenuItem saveAsFile=new JMenuItem("Save as");
        JMenuItem exitFile=new JMenuItem("Exit");
        area.getDocument().addDocumentListener(new MyTextAreaListener(area));
        exitFile.addActionListener(new ExitMenuListener(window,area));
        openFile.addActionListener(new OpenFileListener(window,area));
        saveFile.addActionListener(new SaveFileListener(window,area));
        saveAsFile.addActionListener(new SaveAsFileListener(window,area));
        newFile.addActionListener(new NewFileListener(window,area));

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator();
        fileMenu.add(exitFile);
        fileMenu.add(Box.createHorizontalStrut(20));

        JMenu editMenu=new JMenu("Edit");
        JMenuItem  copyEdit=new JMenuItem("Copy    CTRL+C");
        JMenuItem  pasteEdit=new JMenuItem("Paste    CTRL+V");
        JMenuItem cancelEdit=new JMenuItem("Undo    CTRL+Z");
        JMenuItem  selectEdit=new JMenuItem("Select all    CTRL+A");

        editMenu.add(copyEdit);
        editMenu.add(pasteEdit);
        editMenu.add(cancelEdit);
        editMenu.add(selectEdit);

        copyEdit.addActionListener(new CopyListener(area));
        pasteEdit.addActionListener(new PasteListener(area));
        cancelEdit.addActionListener(new CancelListener(area));
        selectEdit.addActionListener(new SelectAllListener(area));

        JMenu formatMenu=new JMenu("Format");
        JMenuItem fontsFormat=new JMenuItem("Fonts");
        formatMenu.add(fontsFormat);
        fontsFormat.addActionListener(new FontsListener(window,area));

        add(fileMenu);
        add(editMenu);
        add(formatMenu);


    }
}
