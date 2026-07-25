package GUI;

import javax.swing.*;
import java.awt.*;

public class KeyBoard {

    public KeyBoard(
            JPanel centralKeyboard,
            Viewing_window viewingWindow
    ) {
        centralKeyboard.setLayout(new GridLayout(5, 4, 5, 5));
        centralKeyboard.setBackground(new Color(242, 242, 242));

        String[] buttons = {
                "", "","", "AC",
                "9", "8", "7", " / ",
                "6", "5", "4", " * ",
                "3", "2", "1", " + ",
                ",", "0", " = ", " - "
        };

        for (String text : buttons) {
            centralKeyboard.add(createButton(text, viewingWindow));
        }
    }

    private JButton createButton(
            String text,
            Viewing_window viewingWindow
    ) {
        JButton button = new JButton(text);

        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(255, 254, 254));

        button.addActionListener(e -> {
            viewingWindow.add_num(button.getText());

            System.out.println(viewingWindow.getText());
        });

        return button;
    }
}