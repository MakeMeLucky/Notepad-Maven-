package com.myproject.app;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.List;


public class FontsSettDialog extends JDialog {
    private NotepadWindow window;

    public FontsSettDialog(NotepadWindow window, MyAreaText area){
        super(window,"Fonts");
        this.window=window;
        setLocation(window.getX()+100,window.getY()+70);
        setVisible(true);
        window.setEnabled(false);
        setSize(400,300);
        setResizable(false);


        String[] font={"Monospaced","SansSerif","Serif"};
        String[] fontStyle={"Plain","Italic","Bold"};
        String[] size={"8","10","12","14","16","20","24","30"};

        JComboBox<String> comboBoxFont=new JComboBox<>(font);
        JComboBox<String> comboBoxStyle=new JComboBox<>(fontStyle);
        JComboBox<String> comboBoxSize=new JComboBox<>(size);

        JPanel panel=new JPanel();
        panel.setLayout(null);

        comboBoxFont.setSize(90,20);
        comboBoxFont.setLocation(30,30);
        comboBoxStyle.setSize(90,20);
        comboBoxStyle.setLocation(150,30);
        comboBoxSize.setSize(90,20);
        comboBoxSize.setLocation(270,30);

        JButton okButton=new JButton("Ok");
        JButton cancelButton=new JButton("Cancel");

        okButton.setSize(60,25);
        okButton.setLocation(210,220);

        okButton.addActionListener((e)->{
            List<String> fontKeys=new ArrayList<>();
            fontKeys.add(comboBoxFont.getSelectedItem().toString());
            fontKeys.add(comboBoxStyle.getSelectedItem().toString());
            fontKeys.add(comboBoxSize.getSelectedItem().toString());
            ChangeFont fontIt=new ChangeFont(area,fontKeys);
            setVisible(false);
        });

        cancelButton.setSize(80,25);
        cancelButton.setLocation(280,220);

        cancelButton.addActionListener((e)->setVisible(false));

        panel.add(comboBoxFont);
        panel.add(comboBoxStyle);
        panel.add(comboBoxSize);
        panel.add(okButton);
        panel.add(cancelButton);
        setContentPane(panel);



        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                window.setEnabled(false);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                window.setEnabled(true);
                window.toFront();
            }
        });



    }

}
