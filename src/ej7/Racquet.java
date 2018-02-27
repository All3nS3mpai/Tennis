/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
    private Ej7 game;

    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static final int SPEED = 4;

    int x = 0;
    int xa = 0;
    int key = 0;

    public Racquet(Ej7 game) {
        this.game = game;
    }

    public void move() {
        if(key == KeyEvent.VK_LEFT)
            xa = -SPEED;
        if(key == KeyEvent.VK_RIGHT )
            xa = SPEED;
        if(key == 0)
            xa = 0;

        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        if(key == e.getKeyCode())
            key = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            key = KeyEvent.VK_LEFT;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            key = KeyEvent.VK_RIGHT;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }
}