/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private Ej7 game;
    private static final int DIAMETER = 30;

	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;


	public Ball(Ej7 game) {
		this.game= game;
	}

	void move() {
	    // Cambiar la direccion de la bola si colisiona con alguno de los bordes
		if (x + xa < 0)
			xa = game.speed;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		if (y + ya < 0)
			ya = game.speed;
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();

        // Cambiar la direccion de la bola si colisiona con la raqueta
		if (collision()){
			game.speed += 1;
			ya = -game.speed;
		}

		//Mover la bola
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
