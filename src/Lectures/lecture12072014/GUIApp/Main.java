package Lectures.lecture12072014.GUIApp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sania_000 on 7/12/2014.
 */
public class Main extends JFrame {
    private JButton but = new JButton("Button");
    private Container container;

    public Main() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(10, 10, 500, 400);
        container = getContentPane();
        container.setLayout(null);
        container.add(but);
        but.setBounds(10, 50, 100, 30);
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.setVisible(true);
    }
}
