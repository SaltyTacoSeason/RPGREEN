package dev.mckeever.game.state;

import java.awt.Graphics2D;

public class StateManager {
	
	public static int state;
	public int prevState = 453875;
	public State[] states = new State[16];
	
	public StateManager() {
		states[0] = new MenuState(0);
		states[1] = new GameState(1);
		states[2] = new HelpState(2);
	}
	
	public void render(Graphics2D g) {
		states[state].render(g);
	}
	
	public void tick() {
		states[state].tick();
		
		if(prevState != state)
			states[state].enter();
		prevState = state;
	}
}
