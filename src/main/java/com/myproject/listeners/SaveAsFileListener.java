package com.myproject.listeners;

import com.myproject.app.MyAreaText;
import com.myproject.app.NotepadWindow;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;


public class SaveAsFileListener implements ActionListener {
    private NotepadWindow window;
    private MyAreaText area;
    private String charSet;

    public SaveAsFileListener(NotepadWindow window, MyAreaText area){
        this.window=window;
        this.area=area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveAsFile("C:");
    }

    void saveAsFile(String directoryPath){
        JFileChooser fileChooser=new JFileChooser(directoryPath);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files","txt"));

        if(fileChooser.showSaveDialog(window)==JFileChooser.APPROVE_OPTION)
        {

            if(fileChooser.getSelectedFile().exists()){
                if(JOptionPane.showConfirmDialog(window,"Re-Write?")==JOptionPane.NO_OPTION){
                    directoryPath=fileChooser.getSelectedFile().getPath().replace(fileChooser.getSelectedFile().getName(),"");
                    saveAsFile(directoryPath);
                }
            }

            chooseDirect(fileChooser.getSelectedFile());
        }

    }

    private void chooseDirect(File f){
        String nameFile=f.getName();
        String pathFile=f.getAbsolutePath();
        String nameOS=System.getProperty("os.name");
        if(nameOS.contains("Windows")) charSet="windows-1251";
        else if(nameOS.contains("Mac")) charSet="UNICODE";
        else if(nameOS.contains("Linux")) charSet="UTF-8";

        if(!f.getName().contains(".txt")){
            nameFile=f.getName()+".txt";
            pathFile=pathFile+".txt";

        }

        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFile), charSet));
            area.write(writer);
            window.setTitle(nameFile);
            area.setSaved(true);
            area.setFirstOpen(false);


        }catch (Exception e){
            JOptionPane.showMessageDialog(window,"Save failed. Check disk access");
            e.printStackTrace();
        }
    }
}


