package com.myproject.app;

import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.UndoManager;
import javax.swing.undo.CannotUndoException;
import javax.swing.KeyStroke;

public class MyAreaText extends JTextArea {
   private Boolean isSaved;
   private String fullNameFile;
   private Boolean firstOpen;
   private UndoManager manager;

   MyAreaText(){
       isSaved=true;
       firstOpen=true;
   }

   public Boolean getSaved() {
       return isSaved;
   }

   public void setSaved(Boolean saved) {
       this.isSaved = saved;
   }

   public String getFullNameFile() {
        return fullNameFile;
    }
   public void setFullNameFile(String fullNameFile) {
       this.fullNameFile = fullNameFile;
   }

   public Boolean getFirstOpen() {
        return firstOpen;
    }

   public void setFirstOpen(Boolean firstOpen) {
        this.firstOpen = firstOpen;
   }

   public void cancelListener(){
       manager=new UndoManager();
       getDocument().addUndoableEditListener(manager);
       getActionMap().put("Undo",
               new AbstractAction("Undo") {
                   public void actionPerformed(ActionEvent evt) {
                        cancelActionText();
                    }
               });


       getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
   }

   public void cancelActionText(){
      try{
          if(manager.canUndo()) manager.undo();
      }catch (CannotUndoException e){e.printStackTrace();}
   }
}
