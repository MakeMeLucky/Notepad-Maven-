package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import javax.swing.JFileChooser;

public class OpenFileListener implements ActionListener {
    private NotepadWindow window;
    private MyAreaText area;
    private String charSet;


    public OpenFileListener(NotepadWindow window, MyAreaText area) {
        this.window = window;
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionAssist();

    }

    private void actionAssist() {

        if (!area.getSaved()) {

            SaveAsFileListener fileSave = new SaveAsFileListener(window, area);
            fileSave.saveAsFile("C:");
        }

        JFileChooser fileChooser = new JFileChooser("C:");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));

        if (fileChooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
            openFile(fileChooser.getSelectedFile());
        }
    }

    private void openFile(File f) {
        String nameOS=System.getProperty("os.name");
        if(nameOS.contains("Windows")) charSet="windows-1251";
        else if(nameOS.contains("Mac")) charSet="UNICODE";
        else if(nameOS.contains("Linux")) charSet="UTF-8";

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), charSet));
            window.setTitle(f.getName());
            area.read(reader, "area");
            area.setFullNameFile(f.getAbsolutePath());
            area.setFirstOpen(false);

            area.getDocument().addDocumentListener(new MyTextAreaListener(area));
            area.cancelListener();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
