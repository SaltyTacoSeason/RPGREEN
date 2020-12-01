/*     */ package dev.mckeever.game.core;
/*     */ 
/*     */ import dev.mckeever.game.assets.tiles.Tile;
/*     */ import dev.mckeever.game.utils.FileManager;
/*     */ import java.awt.Graphics2D;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ public class World
/*     */ {
/*  12 */   public double worldWidth = 40.0D;
/*     */   
/*  14 */   public double worldHeight = 30.0D;
/*     */ 
/*     */   
/*  17 */   public int[][] world = new int[40][30];
/*  18 */   public int rowLength = 6;
/*     */   
/*     */   public int doorX;
/*     */   
/*     */   public int doorY;
/*     */   
/*     */   public int chestX;
/*     */   
/*     */   public int chestY;
/*     */   private Random r;
/*     */   public int xStart;
/*     */   public int yStart;
/*     */   public int[] buffer;
/*  31 */   private final float FEATURE_SIZE = 2.5F;
/*     */   
/*  33 */   private float sChance = 0.4F;
/*     */   
/*  35 */   private int birthLimit = 4, deathLimit = 3;
/*     */   
/*     */   public void init() {
/*  38 */     this.r = new Random();
/*     */   }
/*     */   
/*     */   public void loadWorld(String path) {
/*  42 */     int cnt = 0;
/*  43 */     this.buffer = new int[(FileManager.readWorld(path)).length];
/*  44 */     this.buffer = FileManager.readWorld(path);
/*     */     
/*  46 */     for (int i = 0; i < this.rowLength; i++) {
/*  47 */       for (int u = 0; u < Math.floorDiv(this.buffer.length, this.rowLength); u++) {
/*  48 */         System.out.println("I have " + Math.floorDiv(this.buffer.length, this.rowLength) + " banana");
/*  49 */         this.world[i][u] = this.buffer[u * this.rowLength + i];
/*  50 */         System.out.println("u are a " + this.buffer[u * this.rowLength + i]);
/*  51 */         System.out.println(String.valueOf(this.world[i][u]) + " wakawask");
/*  52 */         System.out.println("Wheeeee " + cnt++);
/*     */       } 
/*  54 */     }  System.out.println(String.valueOf(this.world[0][0]) + "ring round the ahhh I want to die");
/*  55 */     initWorld(this.buffer.length);
/*     */   }
/*     */   
/*     */   
/*     */   public int countAliveNeighbours(int[][] world2, int x, int y) {
/*  83 */     int count = 0;
/*  84 */     for (int i = -1; i < 2; i++) {
/*  85 */       for (int j = -1; j < 2; j++) {
/*  86 */         int neighbour_x = x + i;
/*  87 */         int neighbour_y = y + j;
/*     */         
/*  89 */         if (i != 0 || j != 0)
/*     */         {
/*     */ 
/*     */           
/*  93 */           if (neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= world2.length || neighbour_y >= (world2[0]).length) {
/*  94 */             count++;
/*     */           
/*     */           }
/*  97 */           else if (world2[neighbour_x][neighbour_y] == 5) {
/*  98 */             count++;
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 102 */     return count;
/*     */   }
/*     */   
/*     */   public int[][] doSimulationStep(int[][] world2) {
/* 106 */     int[][] newMap = new int[(int)this.worldWidth + 1][(int)this.worldHeight + 1];
/*     */     
/* 108 */     for (int x = 1; x < world2.length - 1; x++) {
/* 109 */       for (int y = 1; y < (world2[0]).length - 1; y++) {
/* 110 */         int nbs = countAliveNeighbours(world2, x, y);
/*     */ 
/*     */         
/* 113 */         if (world2[x][y] == 5) {
/* 114 */           if (nbs < this.deathLimit) {
/* 115 */             newMap[x][y] = 0;
/*     */           } else {
/*     */             
/* 118 */             newMap[x][y] = 5;
/*     */           }
/*     */         
/*     */         }
/* 122 */         else if (nbs > this.birthLimit) {
/* 123 */           newMap[x][y] = 5;
/*     */         }
/* 125 */         else if (nbs == 0) {
/* 126 */           newMap[x][y] = 4;
/*     */         } else {
/*     */           
/* 129 */           newMap[x][y] = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     return newMap;
/*     */   }
/*     */   
/*     */   public void generateMap() {
/* 138 */     this.rowLength = 40;
			  world = new int[40][30];
/*     */     
/* 140 */     this.world = initialiseMap(this.world);
/*     */     
/* 142 */     for (int i = 0; i < 5; i++) {
/* 143 */       this.world = doSimulationStep(this.world);
/*     */     }
/* 145 */     initWorld(1200);
/* 146 */     System.out.println("It is here");
/*     */   }
/*     */   
/*     */   public int[][] initialiseMap(int[][] world2) {
/* 150 */     for (int y = 1; y < this.worldHeight / 16.0D; y++) {
/* 151 */       for (int x = 1; x < this.worldWidth / 16.0D; x++) {
/* 152 */         float tent = this.r.nextFloat();
/* 153 */         if (tent < this.sChance) {
/* 154 */           world2[x][y] = 5;
/*     */         }
/*     */       } 
/*     */     } 
/* 158 */     return world2;
/*     */   }
/*     */   
/*     */   public void initWorld(int length) {
/* 162 */     this.worldWidth = (this.rowLength * 16);
/* 163 */     System.out.println(String.valueOf(length / this.rowLength) + " wow");
/* 164 */     this.worldHeight = Math.floor((length / this.rowLength)) * 16.0D;
/* 165 */     System.out.println(String.valueOf(this.worldHeight) + " oh no");
/* 166 */     System.out.println(String.valueOf(this.worldWidth) + " there are no accidents -Master Oogway");
/* 167 */     this.xStart = (int)(320.0D - this.worldWidth / 2.0D);
/* 168 */     this.yStart = (int)(240.0D - this.worldHeight / 2.0D);
/*     */     
/* 170 */     placeDoor();
/* 171 */     placeChest();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 175 */     Tile.doorTile.tick(this.doorX * 16 + this.xStart, this.doorY * 16 + this.yStart);
/* 176 */     Tile.chestTile.tick(this.chestX * 16 + this.xStart, this.chestY * 16 + this.yStart);
/* 177 */     tickWorld();
/*     */   }
/*     */   
/*     */   public void drawWorldCentered(Graphics2D g) {
/* 181 */     int y = 0, x = 0;
/*     */     
/* 183 */     for (y = 0; y < this.worldHeight / 16.0D; y++) {
/* 184 */       for (x = 0; x < this.worldWidth / 16.0D; x++) {
/* 185 */         Tile.tiles[this.world[x][y]].render(g, x * 16 + this.xStart, y * 16 + this.yStart);
/*     */       }
/*     */     } 
/*     */     
/* 189 */     Tile.doorTile.render(g, this.doorX * 16 + this.xStart, this.doorY * 16 + this.yStart);
			if(!Game.collectedChest) {
/* 190 */     Tile.chestTile.render(g, this.chestX * 16 + this.xStart, this.chestY * 16 + this.yStart);
			}
/*     */   }
/*     */   
/*     */   public void tickWorld() {
/* 194 */     for (int y = 0; y < this.worldHeight / 16.0D; y++) {
/* 195 */       for (int x = 0; x < this.worldWidth / 16.0D; x++) {
/* 196 */         Tile.tiles[this.world[x][y]].tick(x * 16 + this.xStart, y * 16 + this.yStart);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void placeDoor() {
/* 202 */     this.doorX = (int)(this.worldWidth / 16.0D - 1.0D);
/* 203 */     this.doorY = this.r.nextInt((int)(this.worldHeight / 16.0D));
/*     */     
/* 205 */     if (Tile.tiles[this.world[this.doorX][this.doorY]].isSolid()) {
/* 206 */       placeDoor();
/*     */     }
/*     */     
/* 209 */     System.out.println(String.valueOf(this.doorX) + " on a big fat " + this.doorY);
/*     */   }
/*     */   
/*     */   public void placeChest() {
/* 213 */     this.chestX = this.r.nextInt((int)(this.worldWidth / 16.0D - 10)) + 5;
/* 214 */     this.chestY = this.r.nextInt((int)(this.worldHeight / 16.0D - 10)) + 5;

System.out.println(String.valueOf(this.chestX) + " on a very small " + this.chestY);
/*     */     
/* 216 */     if (Tile.tiles[this.world[this.chestX][this.chestY]].isSolid()) {
/* 217 */       placeChest();
/*     */     }
/*     */     
/* 220 */    
/*     */   }
/*     */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/core/World.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */