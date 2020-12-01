package dev.mckeever.game.menu;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.mckeever.game.assets.Assets;
import dev.mckeever.game.core.Game;
import dev.mckeever.game.state.StateManager;

public class PlayButton {
	
	public int x, y;
	public int width = 400, height = 100;
	public Rectangle bounds;
	private BufferedImage costume;
	
	public PlayButton(int x, int y) {
		costume = Assets.playButton;
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, width, height);
	}
	
	public void render(Graphics2D g) {
		g.drawImage(costume, x, y, null);
	}
	
	public void tick() {
		if(bounds.contains(Game.lastClick)) {
			Game.lastClick = new Point();
			StateManager.state = 1;
		}
		
		if(bounds.contains(Game.mousePos))costume = Assets.playButtonHover;else {costume = Assets.playButton; Game.mousePos = new Point();}
	}
	
	public void init() {
		
	}
}
