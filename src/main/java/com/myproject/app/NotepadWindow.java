package com.myproject.app;

import com.myproject.listeners.MyWindowListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;

public class NotepadWindow extends JFrame {

   NotepadWindow(String title){
       super(title);
       setSize(800,400);
       setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

       MyAreaText area=new MyAreaText();
       area.cancelListener();
       addWindowListener(new MyWindowListener(this,area));
       area.setFullNameFile(title);

       NotePopup popMenu=new NotePopup(area);

       MyMenuBar menuBar = new MyMenuBar(this, area);
       area.setAutoscrolls(true);

       setContentPane(new JScrollPane(area));
       setJMenuBar(menuBar);

   }

}
