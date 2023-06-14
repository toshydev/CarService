package de.neuefische.carspring.panel;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public class WelcomePanel extends JPanel {
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static final int DELAY = 75;
    Random random;

    public WelcomePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int randInt = random.nextInt(1500);
                if(randInt == 1) {
                    g.drawOval(x, y, 1, 1);
                    g.setColor(Color.WHITE);
                }
            }
        }
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Snek Car", (WIDTH - metrics.stringWidth("Snek Car"))/2,(HEIGHT - g.getFont().getSize())/2);
    }
}
