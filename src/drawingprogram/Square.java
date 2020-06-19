/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingprogram;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Antonio
 */
public class Square extends Shape{
    //creates a square
    //like rectangles, require starting points but height and width are the same
    private final int topLeftX;
    private final int topLeftY;
    private final int width;
    private final int height;
    private final Color fillColor;

    
  public Square(int startX, int startY, int endX, int endY, Color color, Color fillColor){
      super(startX, startY, endX, endY, color);
      this.fillColor = fillColor;
      // calculations for the square, since it needs to know top left and width/height
        topLeftX = Math.min(startX, endX);
        topLeftY = Math.min(startY, endY);
        width = Math.abs(startX - endX);
        height = width;
        
  }
   @Override
    public void draw(Graphics2D g2d) {
        // draw solid square first
        g2d.setColor(fillColor);
        g2d.fillRect(topLeftX, topLeftY, width, height);
        // draw outline square on top
        g2d.setColor(lineColor);
        g2d.drawRect(topLeftX, topLeftY, width, height);
    } 
    
  //This static method is used to draw a rectangle before an actual square object is created
  //Outline works the same way as creating rectangles, only the height will always be equal to width
  public static void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color lc, Color fc) {
        // draw solid triangle first
        g2d.setColor(fc);
        g2d.fillRect(
                Math.min(x1,x2), 
                Math.min(y1, y2), 
                Math.abs(x1 - x2), 
                Math.abs(y1 - y2));
        // draw outline on top
        g2d.setColor(lc);
        g2d.drawRect(
                Math.min(x1,x2), 
                Math.min(y1, y2), 
                Math.abs(x1 - x2), 
                Math.abs(y1 - y2));
    }
}
