/*    */ package dev.mckeever.game.assets.tiles;
/*    */ 
/*    */ import dev.mckeever.game.assets.Assets;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class ChestTile
/*    */   extends Tile
/*    */ {
/*    */   private Rectangle r;
/*    */   
/*    */   public ChestTile(int id) {
/* 13 */     super(Assets.tileImgs[id], id, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g, int x, int y) {
/* 18 */     this.x = x;
/* 19 */     this.y = y;
/* 20 */     g.drawImage(this.texture, x, y, 16, 16, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick(int x, int y) {
/* 25 */     this.r = new Rectangle(x, y, 16, 16);
/*    */   }
/*    */ 
/*    */   
/*    */   public Rectangle getBounds() {
/* 30 */     return this.r;
/*    */   }
/*    */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/assets/tiles/ChestTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */