package GUI;

import operations.Operations;

import javax.swing.*;
import java.awt.*;

public class Viewing_window {

    private final JLabel lbl_txt;

    public Viewing_window(JPanel viewingWindow) {
        viewingWindow.setLayout(new BorderLayout());
        lbl_txt = new JLabel("");
        lbl_txt.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_txt.setFont(new Font("Arial", Font.BOLD, 40));

        viewingWindow.add(lbl_txt, BorderLayout.CENTER);

    }

    public void add_num(String num) {
        if (num.equalsIgnoreCase("=")){
            clear();
        } else {
            lbl_txt.setText(lbl_txt.getText() + num);

        }
    }

    public void clear() {
        lbl_txt.setText("");
    }

    public String getText() {
        return lbl_txt.getText();
    }
}
