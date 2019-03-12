package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class SaveFileListener implements ActionListener {
    private NotepadWindow window;
    private MyAreaText area;
    private String charSet;

    public SaveFileListener(NotepadWindow window, MyAreaText area){
        this.area=area;
        this.window=window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveFile();
    }

    private void saveFile(){
        if(area.getFirstOpen()){
            SaveAsFileListener listener=new SaveAsFileListener(window,area);
            listener.saveAsFile("C:");
        }
        String nameOS=System.getProperty("os.name");
        if(nameOS.contains("Windows")) charSet="windows-1251";
        else if(nameOS.contains("Mac")) charSet="UNICODE";
        else if(nameOS.contains("Linux")) charSet="UTF-8";

        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(area.getFullNameFile()), charSet));
            area.write(writer);
            area.setSaved(true);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
