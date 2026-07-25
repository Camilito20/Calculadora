package GUI;

import variables.Variables;

import javax.swing.*;
import java.awt.*;

public class Main_GUI extends JFrame {

    Variables variables = new Variables();

    JPanel central_panel;
    JPanel north_panel;

    public Main_GUI() {
        setTitle("Calculator");
        setSize(variables.getSize_window());

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Pantalla de la calculadora
        north_panel = new JPanel();
        north_panel.setBackground(new Color(255, 255, 255));
        north_panel.setPreferredSize(new Dimension(500, 400));


        Viewing_window viewingWindow = new Viewing_window(north_panel);

        // Teclado
        central_panel = new JPanel();
        central_panel.setForeground(new Color(232, 231, 231));

        new KeyBoard(central_panel, viewingWindow);

        add(north_panel, BorderLayout.NORTH);
        add(central_panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_GUI::new);
    }
}
