package Lectures.lecture12072014.GUIApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame implements ActionListener {
    private JButton but = new JButton("Button");
    private Container container;

    public Win() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(10, 10, 500, 400);
        container = getContentPane();
        container.setLayout(null);
        container.add(but);
        but.setBounds(10, 50, 100, 30);
    }

    public static void main(String[] args) {
        Win window = new Win();
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
