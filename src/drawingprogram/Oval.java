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
public class Oval extends Shape{
    //creates an oval
    //like rectangles, requires starting point, width, height, and fillcolor
    private final int topLeftX;
    private final int topLeftY;
    private final int width;
    private final int height;
    private final Color fillColor;
    
    public Oval(int startX, int startY, int endX, int endY, Color color, Color fillColor){
        super(startX, startY, endX, endY, color);
        this.fillColor = fillColor;
        topLeftX = Math.min(startX, endX);
        topLeftY = Math.min(startY, endY);
        width = Math.abs(startX - endX);
        height = Math.abs(startY - endY);
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // draw solid oval first
        g2d.setColor(fillColor);
        g2d.fillOval(topLeftX, topLeftY, width, height);
        // draw outline oval on top
        g2d.setColor(lineColor);
        g2d.drawOval(topLeftX, topLeftY, width, height);
    }
    //This static method is used to draw an Oval before an actual Oval object is created
    //Outline works the same way as creating rectangles, but oval has its own methods
    public static void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color lc, Color fc) {
        // draw solid oval first
        g2d.setColor(fc);
        g2d.fillOval(
                Math.min(x1,x2), 
                Math.min(y1, y2), 
                Math.abs(x1 - x2), 
                Math.abs(y1 - y2));
        // draw outline on top
        g2d.setColor(lc);
        g2d.drawOval(
                Math.min(x1,x2), 
                Math.min(y1, y2), 
                Math.abs(x1 - x2), 
                Math.abs(y1 - y2));
        
    }
}
