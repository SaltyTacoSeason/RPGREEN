package dev.mckeever.game.state;

import java.awt.Graphics2D;

import dev.mckeever.game.core.Game;
import dev.mckeever.game.entity.Enemy;

import static dev.mckeever.game.core.Game.*;

public class GameState extends State{

	public GameState(int id) {
		super(id);
		Game.enemy.add(new Enemy());
	}
	
	public void render(Graphics2D g) {
		world.drawWorldCentered(g);
		     player.render(g);
		     for (int i = 0; i < enemy.size(); i++) {
		      ((Enemy)enemy.get(i)).render(g);
		}
	}
	
	public void tick() {
		world.tick();
	     player.tick(px, py);
	     for (int i = 0; i < enemy.size(); i++)
	       ((Enemy)enemy.get(i)).tick();
	}
	
	public void enter() {
		Game.score = 0;
		Game.collectedChest = false;
		Game.world.generateMap();
		Game.enemy.add(new Enemy());
	}
}
