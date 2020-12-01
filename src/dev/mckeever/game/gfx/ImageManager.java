/*    */ package dev.mckeever.game.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ public class ImageManager
/*    */ {
/*    */   public static BufferedImage loadImage(String path) {
/* 12 */     try {
				return ImageIO.read(ImageManager.class.getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
}


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/gfx/ImageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */