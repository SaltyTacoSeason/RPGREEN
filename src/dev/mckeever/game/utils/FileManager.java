/*    */ package dev.mckeever.game.utils;
/*    */ 
/*    */ import dev.mckeever.game.core.Game;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileManager
/*    */ {
/*    */   public static int[] readWorld(String path) {
/*    */     try {
/* 15 */       Scanner s = new Scanner(new File(path));
/* 16 */       int f = 0;
/* 17 */       Game.world.rowLength = s.nextInt();
/* 18 */       while (s.hasNext()) {
/* 19 */         System.out.println(String.valueOf(f) + "u got ded");
/* 20 */         if (s.hasNext()) {
/* 21 */           s.next();
/* 22 */           f++;
/*    */         } 
/*    */       } 
/* 25 */       s.close();
/* 26 */       s = new Scanner(new File(path));
/*    */       
/* 28 */       int[] array = new int[f];
/* 29 */       s.next();
/* 30 */       for (int i = 0; i < array.length; i++) {
/* 31 */         array[i] = s.nextInt();
/* 32 */         System.out.println(array[i]);
/*    */       } 
/* 34 */       s.close();
/* 35 */       return array;
/* 36 */     } catch (FileNotFoundException e) {
/* 37 */       e.printStackTrace();
/* 38 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/Bulk/programming-stuff/RPGREEEEN/!/dev/mckeever/game/utils/FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */