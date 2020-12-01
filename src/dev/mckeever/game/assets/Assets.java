/*    */ package dev.mckeever.game.assets;
/*    */ 
/*    */ import dev.mckeever.game.gfx.ImageManager;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class Assets
/*    */ {
/*  9 */   public static BufferedImage[] tileImgs = new BufferedImage[256];
/*    */   public static BufferedImage playerImg;
/*    */   public static BufferedImage enemyImg;
		   public static BufferedImage playButton;
		   public static BufferedImage playButtonHover;
/*    */   
/*    */   public static void init() {
/* 14 */     tileImgs[0] = ImageManager.loadImage("/textures/dirt.png");
/* 15 */     tileImgs[1] = ImageManager.loadImage("/textures/tile.png");
/* 16 */     tileImgs[2] = ImageManager.loadImage("/textures/imovable.png");
/* 17 */     tileImgs[3] = ImageManager.loadImage("/textures/door.png");
/* 18 */     tileImgs[4] = ImageManager.loadImage("/textures/grass.png");
/* 19 */     tileImgs[5] = ImageManager.loadImage("/textures/newer-stone.png");
/* 20 */     tileImgs[6] = ImageManager.loadImage("/textures/chest.png");
/*    */     
/* 22 */     playerImg = ImageManager.loadImage("/textures/player.png");
/* 23 */     enemyImg = ImageManager.loadImage("/textures/enemy.png");
             playButton = ImageManager.loadImage("/textures/play-button.png");
             playButtonHover = ImageManager.loadImage("/textures/play-button-hover.png");
/*    */   }
/*    */ }