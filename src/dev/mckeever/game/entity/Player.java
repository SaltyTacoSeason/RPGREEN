/*     */ package dev.mckeever.game.entity;
/*     */ 
/*     */ import dev.mckeever.game.assets.Assets;
/*     */ import dev.mckeever.game.assets.tiles.Tile;
/*     */ import dev.mckeever.game.core.Game;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Player
/*     */   extends Entity
/*     */ {
/*     */   private Rectangle playerRect;
/*     */   
/*     */   public Player(int px, int py, int vx, int vy) {
/*  19 */     Game.px = px;
/*  20 */     Game.py = py;
/*  21 */     Game.vx = vx;
/*  22 */     Game.vy = vy;
/*     */   }
/*     */   
/*     */   public void render(Graphics2D g) {
/*  26 */     g.drawImage(Assets.playerImg, Game.px, Game.py, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick(int px, int py) {
/*  31 */     if (Game.keys[87])
/*  32 */     { if (canMove(0))
/*  33 */       { Game.vy = -4; }
/*  34 */       else { Game.vy = 0; }  }
/*  35 */     else if (Game.keys[83])
/*  36 */     { if (canMove(1))
/*  37 */       { Game.vy = 4; }
/*  38 */       else { Game.vy = 0; }  }
/*  39 */     else { Game.vy = 0; }
/*     */     
/*  41 */     if (Game.keys[65])
/*  42 */     { if (canMove(2))
/*  43 */       { Game.vx = -4; }
/*  44 */       else { Game.vx = 0; }  }
/*  45 */     else if (Game.keys[68])
/*  46 */     { if (canMove(3))
/*  47 */       { Game.vx = 4; }
/*  48 */       else { Game.vx = 0; }  }
/*  49 */     else { Game.vx = 0; }
/*     */     
/*  51 */     px += Game.vx;
/*  52 */     py += Game.vy;
/*     */     
/*  54 */     if (px > Game.world.worldWidth - 16.0D + Game.world.xStart)
/*  55 */     { Game.px = (int)(Game.world.worldWidth - 16.0D + Game.world.xStart); }
/*  56 */     else if (px < Game.world.xStart)
/*  57 */     { Game.px = Game.world.xStart; }
/*  58 */     else { Game.px = px; }
/*     */     
/*  60 */     if (py > Game.world.worldHeight - 16.0D + Game.world.yStart)
/*  61 */     { Game.py = (int)(Game.world.worldHeight - 16.0D + Game.world.yStart); }
/*  62 */     else if (py < Game.world.yStart)
/*  63 */     { Game.py = Game.world.yStart; }
/*  64 */     else { Game.py = py; }
/*     */     
/*  66 */     this.playerRect = new Rectangle(px, py, 16, 16);
/*     */     
/*  68 */     collisionWithDoor();
/*  69 */     collisionWithChest();
/*     */   }
/*     */   
/*     */   public void collisionWithDoor() {
/*  73 */     if (this.playerRect.intersects(Tile.doorTile.getBounds())) {
				for(Enemy e : Game.enemy) {
					e.speed+=0.2;
				}
				Game.score++;
				Game.collectedChest = false;
/*  74 */       Game.world.world = new int[40][30];
/*  75 */       Game.world.generateMap();
/*  76 */       Game.px = Game.world.xStart;
/*  77 */       Game.py = (Tile.doorTile.getBounds()).y;
/*  78 */       Game.enemy.add(new Enemy());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void collisionWithChest() {
				if(!Game.collectedChest) {
/*  83 */     if (this.playerRect.intersects(Tile.chestTile.getBounds())) {
/*  84 */       Game.score+=10;
				Game.collectedChest = true;
/*     */     } 
	}
/*     */   }
/*     */   
/*     */   public boolean canMove(int dir) {
/*  92 */     Point[] points = { new Point(Game.px, Game.py), 
/*  93 */         new Point(Game.px + 15, Game.py), 
/*  94 */         new Point(Game.px + 15, Game.py + 15), 
/*  95 */         new Point(Game.px, Game.py + 15) };
/*     */ 
/*     */     
/*  98 */     switch (dir) {
/*     */       case 0:
/*     */         try {
/* 101 */           return (
/*     */             
/* 103 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[0]).x - Game.world.xStart, 16)][Math.floorDiv((points[0]).y - 4 - Game.world.yStart, 16)]].isSolid() && 
/*     */ 
/*     */             
/* 106 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[1]).x - Game.world.xStart, 16)][Math.floorDiv((points[1]).y - 4 - Game.world.yStart, 16)]].isSolid());
/* 107 */         } catch (ArrayIndexOutOfBoundsException e) {
/* 108 */           return false;
/*     */         } 
/*     */       case 1:
/*     */         try {
/* 112 */           return (
/*     */             
/* 114 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[2]).x - Game.world.xStart, 16)][Math.floorDiv((points[2]).y + 4 - Game.world.yStart, 16)]].isSolid() && 
/*     */ 
/*     */             
/* 117 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[3]).x - Game.world.xStart, 16)][Math.floorDiv((points[3]).y + 4 - Game.world.yStart, 16)]].isSolid());
/* 118 */         } catch (ArrayIndexOutOfBoundsException e) {
/* 119 */           return false;
/*     */         } 
/*     */       case 2:
/*     */         try {
/* 123 */           return (
/*     */             
/* 125 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[0]).x - 4 - Game.world.xStart, 16)][Math.floorDiv((points[0]).y - Game.world.yStart, 16)]].isSolid() && 
/*     */ 
/*     */             
/* 128 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[3]).x - 4 - Game.world.xStart, 16)][Math.floorDiv((points[3]).y - Game.world.yStart, 16)]].isSolid());
/* 129 */         } catch (ArrayIndexOutOfBoundsException e) {
/* 130 */           return false;
/*     */         } 
/*     */       case 3:
/*     */         try {
/* 134 */           return (
/*     */             
/* 136 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[1]).x + 4 - Game.world.xStart, 16)][Math.floorDiv((points[1]).y - Game.world.yStart, 16)]].isSolid() && 
/*     */ 
/*     */             
/* 139 */             !Tile.tiles[Game.world.world[Math.floorDiv((points[2]).x + 4 - Game.world.xStart, 16)][Math.floorDiv((points[2]).y - Game.world.yStart, 16)]].isSolid());
/* 140 */         } catch (ArrayIndexOutOfBoundsException e) {
/* 141 */           return false;
/*     */         } 
/* 143 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle getBounds() {
/* 148 */     return this.playerRect;
/*     */   }
/*     */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/entity/Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */