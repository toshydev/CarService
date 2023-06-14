package de.neuefische.carspring.engine;

import de.neuefische.carspring.panel.Panel;
import de.neuefische.carspring.panel.WelcomePanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Frame extends JFrame implements ActionListener {
    JButton startButton;
    WelcomePanel welcomePanel;
    Panel panel;

    @Autowired
    public Frame() {
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setBackground(Color.RED);

        this.welcomePanel = new WelcomePanel();
        startButton.setLocation(600, 400);
        welcomePanel.add(startButton);
        this.add(welcomePanel);
        this.setTitle("Snek Car");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == startButton) {
            this.remove(welcomePanel);
            this.repaint();
            this.panel = new Panel();
            this.add(panel);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }
}
