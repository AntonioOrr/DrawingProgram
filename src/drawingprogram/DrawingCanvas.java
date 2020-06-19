/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drawingprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class creates a drawing canvas and extends JPanel
 * We do this so that we can override JPanel's paintComponent method,
 * so we can control what is drawn
 * @author clatulip, Antonio
 */
public class DrawingCanvas extends JPanel {

    private DrawingModel myModel;
   
    /**
     * Constructor
     * Set the background of the canvas to white
     */
    public DrawingCanvas () {
        this.setBackground(Color.WHITE);
    }
    
    /**
     * Need this so we can pass in the model
     * @param model 
     */
    public void setModel(DrawingModel model) {
        myModel = model;
    }
    
    
    protected void paintComponent(Graphics g) {
        // first, check to make sure we have a model, 
        // otherwise there is nothing to draw
        if (myModel != null) {
            super.paintComponent(g);
            // get the graphics context for drawing (don't change this)
            Graphics2D g2d = (Graphics2D) g.create();
        
            // get the Shape ArrayList from the model, and 
            // iterate through it, telling each Shape object to draw itself
            ArrayList<Shape> shapes = myModel.getShapes();
            for (Shape l : shapes) {
                l.draw(g2d);
            }
            
            
            // see if user's mouse is down and is currently drawing
            // this is to show a shape while the user is drawing
            // interactive feedback is important
            // you can comment this section out and see what happens if you 
            // don't believe how important this is...
            if (myModel.isMouseDown()) {
                
                switch (myModel.getCurrentShape()) {
                    case LINE:
                        Line.draw(g2d, 
                                myModel.getStartX(), 
                                myModel.getStartY(), 
                                myModel.getCurrentX(), 
                                myModel.getCurrentY(), 
                                myModel.getLineColor()
                        );
                        break;
                    case RECT:
                        Rectangle.draw(g2d,
                                myModel.getStartX(), 
                                myModel.getStartY(),  
                                myModel.getCurrentX(), 
                                myModel.getCurrentY(),
                                myModel.getLineColor(),
                                myModel.getFillColor()
                        );
                        
                        break;
                        
                    case SQUARE:
                        Square.draw(g2d,
                                myModel.getStartX(), 
                                myModel.getStartY(),  
                                myModel.getCurrentX(), 
                                myModel.getCurrentY(),
                                myModel.getLineColor(),
                                myModel.getFillColor());
                        
                        break;
                        
                    case OVAL:
                        Oval.draw(g2d,
                                myModel.getStartX(), 
                                myModel.getStartY(),  
                                myModel.getCurrentX(), 
                                myModel.getCurrentY(),
                                myModel.getLineColor(),
                                myModel.getFillColor());;
                }
            }
            // done with drawing, get rid of graphics context (don't change this)
            g2d.dispose();
        }
    }

    public void update() {
        // this calls the parent class repaint method, 
        // which in turn forces the paintComponent method to be called
        repaint();
    }
}
