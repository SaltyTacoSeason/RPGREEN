/*    */ package dev.mckeever.game.assets.tiles;
/*    */ 
/*    */ import dev.mckeever.game.assets.Assets;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class DoorTile
/*    */   extends Tile {
/*    */   private int x;
/*    */   private int y;
/*    */   public Rectangle r;
/*    */   
/*    */   public DoorTile(int id) {
/* 14 */     super(Assets.tileImgs[3], id, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g, int x, int y) {
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/* 22 */     g.drawImage(this.texture, x, y, 16, 16, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick(int x, int y) {
/* 27 */     this.r = new Rectangle(x, y, 16, 16);
/*    */   }
/*    */ 
/*    */   
/*    */   public Rectangle getBounds() {
/* 32 */     return this.r;
/*    */   }
/*    */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/assets/tiles/DoorTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */