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
public abstract class Shape {
    //protected fields so they can be used by other Shape classes
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected Color lineColor;
    public Shape(int startX, int startY, int endX, int endY, Color color){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lineColor = color;
    }
    //method that brings lines/shapes into form once overridden
    abstract void draw(Graphics2D g2d);
}
