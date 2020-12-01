/*    */ package dev.mckeever.game.entity;
/*    */ 
/*    */ import dev.mckeever.game.assets.Assets;
/*    */ import dev.mckeever.game.core.Game;
import dev.mckeever.game.state.StateManager;

/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Point;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Enemy
/*    */   extends Entity
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public int tx;
/*    */   public int ty;
/*    */   public Rectangle bounds;
/*    */   float speed;
/*    */   
/*    */   public Enemy() {
/* 23 */     Random rand = new Random();
/* 24 */     this.x = (int)(System.nanoTime() % (Game.getWidth() - 100) + 100L);
/* 25 */     this.y = (int)(System.nanoTime() % (Game.getHeight() - 100) + 100L);
/* 26 */     this.bounds = new Rectangle(this.x, this.y, 16, 16);
/* 27 */     this.speed = 2;
/*    */   }
/*    */   
/*    */   public void render(Graphics2D g) {
/* 31 */     g.drawImage(Assets.enemyImg, this.x, this.y, null);
/*    */   }
/*    */   
/*    */   public void tick() {
/* 35 */     move();
/* 36 */     this.bounds.x = this.x;
/* 37 */     this.bounds.y = this.y;
/* 38 */     collision();
/*    */   }
/*    */   
/*    */   private void move() {
/* 42 */     Point v = new Point(Game.px + Game.vx * 16 - this.x, Game.py + Game.vy * 16 - this.y);
/* 43 */     float length = (float)Math.sqrt((v.x * v.x + v.y * v.y));
/* 44 */     if (length > this.speed) {
/* 45 */       this.x = (int)(this.x + this.speed * v.x / length);
/* 46 */       this.y = (int)(this.y + this.speed * v.y / length);
/*    */     } 

			  if (x > Game.world.worldWidth - 16.0D + Game.world.xStart)
/*  55 */     { x = (int)(Game.world.worldWidth - 16.0D + Game.world.xStart); }
/*  56 */     else if (x < Game.world.xStart)
/*  57 */     { x = Game.world.xStart; }
/*     */     
/*  60 */     if (y > Game.world.worldHeight - 16.0D + Game.world.yStart)
/*  61 */     { y = (int)(Game.world.worldHeight - 16.0D + Game.world.yStart); }
/*  62 */     else if (y < Game.world.yStart)
/*  63 */     { y = Game.world.yStart; }
/*    */   }
/*    */   
/*    */   public void collision() {
/* 51 */     Rectangle pr = Game.player.getBounds();
/*    */     
/* 53 */     if (pr.intersects(this.bounds))
/* 54 */       StateManager.state = 0;
/*    */   }
/*    */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/entity/Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */