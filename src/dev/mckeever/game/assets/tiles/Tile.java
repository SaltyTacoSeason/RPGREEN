/*    */ package dev.mckeever.game.assets.tiles;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tile
/*    */ {
/* 13 */   public static Tile[] tiles = new Tile[256];
/* 14 */   public static Tile dirtTile = new DirtTile(0);
/* 15 */   public static Tile smoothStoneTile = new SmoothStoneTile(1);
/* 16 */   public static Tile imovableTile = new ImovableTIle(2);
/* 17 */   public static Tile doorTile = new DoorTile(3);
/* 18 */   public static Tile grassTile = new GrassTile(4);
/* 19 */   public static Tile stoneTile = new StoneTile(5);
/* 20 */   public static Tile chestTile = new ChestTile(6);
/*    */   
/*    */   public static final int TILEWIDTH = 16;
/*    */   
/*    */   public static final int TILEHEIGHT = 16;
/*    */   protected BufferedImage texture;
/*    */   protected final int id;
/*    */   protected boolean solid;
/*    */   protected int x;
/*    */   protected int y;
/*    */   
/*    */   public Tile(BufferedImage texture, int id, boolean solid) {
/* 32 */     this.texture = texture;
/* 33 */     this.id = id;
/* 34 */     this.solid = solid;
/*    */     
/* 36 */     tiles[id] = this;
/*    */   }
/*    */   
/*    */   public void tick(int x, int y) {
/* 40 */     this.x = x;
/* 41 */     this.y = y;
/*    */   }
/*    */   
/*    */   public void render(Graphics g, int x, int y) {
/* 45 */     this.x = x;
/* 46 */     this.y = y;
/* 47 */     g.drawImage(this.texture, x, y, 16, 16, null);
/*    */   }
/*    */   
/*    */   public int getX() {
/* 51 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(int x) {
/* 55 */     this.x = x;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 59 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(int y) {
/* 63 */     this.y = y;
/*    */   }
/*    */   
/*    */   public boolean isSolid() {
/* 67 */     return this.solid;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 71 */     return this.id;
/*    */   }
/*    */   
/*    */   public Rectangle getBounds() {
/* 75 */     return null;
/*    */   }
/*    */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/assets/tiles/Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */