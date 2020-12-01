package dev.mckeever.game.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import dev.mckeever.game.core.Game;
import dev.mckeever.game.entity.Enemy;
import dev.mckeever.game.menu.PlayButton;

public class MenuState extends State{
	
	public PlayButton button;
	public Rectangle menu;

	public MenuState(int id) {
		super(id);
		button = new PlayButton(Game.getWidth() / 2 - 200, Game.getHeight() / 2 - 50);
		menu = new Rectangle(640 - 38 * 4, 480 - 38, 38 * 4, 38);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setFont(g.getFont().deriveFont(38.0f));
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
		button.render(g);
		g.setColor(Color.BLACK);
		g.drawString("Score = " + Integer.toString(Game.score), Game.getWidth() / 2 - g.getFont().getSize() / 2 - g.getFont().getSize() * 6 / 2, 400);
		g.drawString("Highscore = " + Integer.toString(Game.highScore), Game.getWidth() / 2 - g.getFont().getSize() / 2 - g.getFont().getSize() * 10 / 2, 450);
		g.drawString("HELP", 640 - 38 * 3, 480 - 5);
	}
	
	public void tick() {
		button.tick();
		if(menu.contains(Game.lastClick)) {
			StateManager.state = 2;
			Game.lastClick = new Point(4530, 9857);
		}	
	}
	
	public void enter() {
		if(Game.score >= Game.highScore)
			Game.highScore = Game.score;
		Game.enemy = new LinkedList<Enemy>();
		Game.px = Game.world.xStart;
		Game.py = Game.world.yStart;
	}
}
