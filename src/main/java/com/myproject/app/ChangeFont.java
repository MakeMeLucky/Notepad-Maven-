package com.myproject.app;

import java.awt.Font;
import java.util.List;

class ChangeFont {
    private MyAreaText area;
    private int style;

    ChangeFont(MyAreaText area, List<String> l){
        this.area=area;

        if(l.get(1).equals("Bold")) style=1;
        if(l.get(1).equals("Italic")) style=2;
        if(l.get(1).equals("Plain")) style=0;

        area.setFont(new Font(l.get(0), style, Integer.parseInt(l.get(2))));
    }
}
