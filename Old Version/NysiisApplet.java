import java.applet.Applet;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.awt.SystemColor.scrollbar;

/**
 * Created by nealsanghvi on 6/26/16.
 */
public class NysiisApplet extends Applet implements AdjustmentListener{
    Counter parse = new Counter();
    Nysiis ny = new Nysiis();
    List list = new List();
    Scrollbar scrollbar;
    TextField textField;
//    ArrayList<String> arrname = new ArrayList<>();
//    ArrayList<Integer> arrnum = new ArrayList<>();
    public void init() {
        try {

            list.reader();
//        System.out.println(list.getAllNames().size());

            for (int i = 1; i < list.getAllNames().size(); i++) {
                parse.add(ny.sencode(list.getAllNames().get(i)).getEncoded(), ny.sencode(list.getAllNames().get(i)).getOG());

            }
        } catch(IOException e) {}

        scrollbar = new Scrollbar(Scrollbar.VERTICAL, 50, 0, 0, 100);
//        scrollbar.setOrientation(Scrollbar.VERTICAL);
//        scrollbar.setMinimum(0);
//        scrollbar.setMaximum(100);
        add(scrollbar);
        scrollbar.addAdjustmentListener(this);
        textField = new TextField(3);
        textField.setEditable(true);
//        textField.setText("Test\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\nTest\n");
//        textField.set
        add(textField);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        textField.setText(scrollbar.getValue()+"");
    }
    public void paint(Graphics g) {
        HashMap<String, HashMap<String, Integer>> temp = parse.getHasher();
//        for (int i = 1; i < list.getAllNames().size(); i++) {
//            arrname.add(ny.sencode(list.getAllNames().get(i)).getOG());
//        }
//        int i = 0;
        int i = 50;
        for (String key : temp.keySet()) {
            HashMap<String, Integer> x = temp.get(key);
//            arrnum.add((x.get(arrname.get(i))));
//            i++;
            for (String og : x.keySet()) {
                Integer y = x.get(og);
                g.drawString(og + " occurs " + y + " time(s) in the set", 25, i);
                i+=20;
            }

            i+=10;
        }



//        g.drawString("Hello World", 25, 50);


    }

}
