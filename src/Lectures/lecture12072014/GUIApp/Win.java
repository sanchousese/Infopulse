package Lectures.lecture12072014.GUIApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Win extends JFrame {
    private JButton but = new JButton("Button");
    private Container container;

    public Win() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(10, 10, 500, 400);
        container = getContentPane();
        container.setLayout(null);
        container.add(but);
        but.setBounds(10, 50, 100, 30);

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.setBackground(Color.orange);
            }
        });

        JButton button2 = new JButton("Button2");
        container.add(button2);
        button2.setBounds(but.getX(), but.getY() + but.getHeight(), but.getWidth(), but.getHeight());
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                but.setBounds(but.getX() + 10, 50, 100, 30);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                but.setBounds(10, 50, 100, 30);
            }
        });
    }

    public static void main(String[] args) {
        Win window = new Win();
        window.setVisible(true);
    }
}
