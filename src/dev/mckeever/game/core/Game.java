/*     */ package dev.mckeever.game.core;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
import java.awt.Font;
/*     */ import java.awt.Graphics2D;
import java.awt.Point;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.util.LinkedList;

/*     */ import javax.swing.JFrame;

/*     */ 
/*     */ import dev.mckeever.game.assets.Assets;
/*     */ import dev.mckeever.game.entity.Enemy;
/*     */ import dev.mckeever.game.entity.Player;
import dev.mckeever.game.state.StateManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Game
/*     */ {
/*     */   private JFrame frame;
/*     */   private Canvas canvas;
/*     */   private BufferStrategy bs;
/*     */   private Graphics2D g;
/*     */   public static Player player;
/*     */   public static World world;
			public static StateManager m;
/*  28 */   public static int px = 0; public static int py = 0; public static int vx = 0; public static int vy = 0;
/*     */   
/*  30 */   private String title = "RPGREEN";
/*  31 */   private static int width = 640;
/*  32 */   private static int height = 480;
/*     */ 
			public static int score = 0;
			public static int highScore = 0;
/*     */    
/*  37 */   public static LinkedList<Enemy> enemy = new LinkedList<>();
/*     */ 
/*     */ 	public static Point lastClick = new Point(width, height);
			public static Point mousePos = new Point();
/*     */   
/*  41 */   public static boolean[] keys = new boolean[256];
		    public static boolean collectedChest = false;
/*     */   
/*     */   private boolean running;
/*     */   
/*  45 */   private KeyAdapter k = new KeyAdapter()
/*     */     {
/*     */       public void keyPressed(KeyEvent e) {
/*  48 */         Game.keys[e.getKeyCode()] = true;
/*     */       }
/*     */ 
/*     */       
/*     */       public void keyReleased(KeyEvent e) {
/*  53 */         Game.keys[e.getKeyCode()] = false;
/*     */       }
/*     */     };
/*     */   
/*  60 */   private MouseAdapter l = new MouseAdapter()
/*     */       {
/*     */       	@Override
				    public void mouseReleased(MouseEvent e) {
						super.mouseReleased(e);
						lastClick = e.getPoint();
			    }
				
				@Override
					public void mouseMoved(MouseEvent e) {
						super.mouseMoved(e);
						mousePos = e.getPoint();
					}
/*     */     };
/*     */   
/*     */   private void gameLoop() {
/*  66 */     long lastTime = System.nanoTime();
/*  67 */     double amountOfTicks = 60.0D;
/*  68 */     double ns = 1.0E9D / amountOfTicks;
/*  69 */     double delta = 0.0D;
/*  70 */     long timer = System.currentTimeMillis();
/*  71 */     int frames = 0;
/*  72 */     while (this.running) {
/*  73 */       long now = System.nanoTime();
/*  74 */       delta += (now - lastTime) / ns;
/*  75 */       lastTime = now;
/*  76 */       while (delta >= 1.0D) {
/*  77 */         tick();
/*     */         
/*  79 */         delta--;
/*     */       }
/*  81 */       render();
/*  82 */       frames++;
/*     */       
/*  84 */       if (System.currentTimeMillis() - timer > 1000L) {
/*  85 */         timer += 1000L;
/*  86 */         frames = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void tick() { 
			  m.tick();
/*     */   }
/*     */ 
/*     */   
/*     */   private void render() {
/* 107 */     this.bs = this.canvas.getBufferStrategy();
/* 108 */     if (this.bs == null) {
/* 109 */       this.canvas.createBufferStrategy(2);
/*     */       
/*     */       return;
/*     */     } 
/* 113 */     this.g = (Graphics2D)this.bs.getDrawGraphics();

			  g.setFont(g.getFont().deriveFont(Font.HANGING_BASELINE));
/*     */     
/* 115 */     this.g.clearRect(0, 0, width, height);
/* 116 */     this.g.fillRect(0, 0, width, height);
/*     */ 
/* 119 */     
/*     */     m.render(g);

/* 125 */     this.g.dispose();
/* 126 */     this.bs.show();
/*     */   }
/*     */   
/*     */   private void init() {
/* 130 */     this.frame = new JFrame(this.title);
/* 131 */     this.frame.setSize(width, height);
/* 132 */     this.frame.setDefaultCloseOperation(3);
/* 133 */     this.frame.setResizable(false);
/* 134 */     this.frame.setLocationRelativeTo((Component)null);
/* 135 */     this.frame.setVisible(true);
/*     */     
/* 137 */     this.canvas = new Canvas();
/* 138 */     this.canvas.setPreferredSize(new Dimension(width, height));
/* 139 */     this.canvas.setMaximumSize(new Dimension(width, height));
/* 140 */     this.canvas.setMinimumSize(new Dimension(width, height));
/*     */     
/* 142 */     this.frame.add(this.canvas);
/* 143 */     this.frame.pack();
/*     */     
/* 145 */     this.frame.addKeyListener(this.k);
/* 146 */     this.canvas.addKeyListener(this.k);
/*     */     
/* 148 */     this.canvas.addMouseListener(this.l);
/* 149 */     this.canvas.addMouseMotionListener(this.l);
/*     */     
/* 151 */     player = new Player(px, py, vx, vy);
/*     */     
/* 154 */     world = new World();
/* 155 */     Assets.init();
/* 156 */     world.init();
/* 157 */     world.generateMap();

			  m = new StateManager();

			  m.state = 0;
/*     */     
/* 159 */     px = world.xStart;
/* 160 */     py = world.yStart;
/*     */     
/* 162 */     this.running = true;
/*     */   }
/*     */   
/*     */   private void dispose() {
/* 166 */     this.running = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Game() {
/* 171 */     init();
/* 172 */     gameLoop();
/* 173 */     dispose();
/*     */   }
/*     */   
/*     */   public static int getWidth() {
/* 177 */     return width;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 181 */     Game.width = width;
/*     */   }
/*     */   
/*     */   public static int getHeight() {
/* 185 */     return height;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/* 189 */     Game.height = height;
/*     */   }
/*     */   
/*     */   public boolean isRunning() {
/* 193 */     return this.running;
/*     */   }
/*     */   
/*     */   public void setRunning(boolean running) {
/* 197 */     this.running = running;
/*     */   }
/*     */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/core/Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */