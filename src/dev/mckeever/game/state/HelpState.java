package dev.mckeever.game.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import dev.mckeever.game.core.Game;

public class HelpState extends State{
	
	public Rectangle exit;
	
	public HelpState(int id) {
		super(id);
		exit = new Rectangle(640 - 38 * 4, 480 - 38, 38 * 4, 38);
	}

	public void render(Graphics2D g) {
		g.setFont(g.getFont().deriveFont(38f));
		g.setColor(Color.cyan);
		g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
		g.setColor(Color.BLACK);
		g.drawString("MENU", 640 - 38 * 3, 480 - 5);
		g.drawString("Controls: W A S D", 0, Game.getHeight() - 225);
		g.drawString("Avoid the enemies", 0, Game.getHeight() - 180);
		g.drawString("Doors go to the next area", 0, Game.getHeight() - 135);
		g.drawString("Chests are worth 10 points", 0, Game.getHeight() - 90);
		g.drawString("Good Luck!", 0, Game.getHeight() - 45);
	}
	
	public void tick() {
		if(exit.contains(Game.lastClick)) {
			StateManager.state = 0;
			Game.lastClick = new Point(3453, 9048);
		}
	}
}
