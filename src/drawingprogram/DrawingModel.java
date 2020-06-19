/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drawingprogram;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 * This model holds everything that the user has added to the canvas, 
 * and keeps track of the current state (i.e. selected color and shape, etc.)
 * @author clatulip, Antonio, for ITIS 1213 @ UNC Charlotte
 */
public class DrawingModel {
    // array to hold the shapes
    //private ArrayList<Line> lines = new ArrayList<>();
    //private ArrayList<Rectangle> rects = new ArrayList<>();
    private ArrayList<Shape> shapes = new ArrayList<>();
    // array to hold undo shapes
    private ArrayList<Shape> undoShapes = new ArrayList<>();
    
    // enumerated type that defines the different shapes that can be drawn
    public enum ShapeType {LINE, RECT, SQUARE, OVAL}
    
    // currently selected shape and color
    private ShapeType currentShape;
    private Color lineColor;
    private Color fillColor;
    
    // variables to make drawing real-time interactive
    private boolean mouseDown; // is the mouse pressed down?
    private int startX; // x coord where mouse pressed down
    private int startY; // y coord where mouse pressed down
    private int currentX; // currentX pos
    private int currentY; // currentY pos
    
    
    //constructor
    public DrawingModel() {
        currentShape = ShapeType.LINE;
        lineColor = Color.BLACK;
        fillColor = Color.WHITE;
        mouseDown = false;
        currentX = 0;
        currentY = 0;
    }
    
    //Removed methods that used Line and Rectangle ArrayLists
    //Method that adds new shape
    public void addNewShape(Shape shape){
        shapes.add(shape);
    }
    
    //Method that gives list of shapes in the model
    public ArrayList<Shape> getShapes(){
        return shapes;
    }
    
    /**
     * Removes all shapes the user has drawn
     */
    public void clearModel() {
        shapes.clear();
    }
    
    //adds shape object to undoShapes array before deleting the shape from shapes array list
    public void undo(){
        //undo method only works if there are elements in shapes array
        if (shapes.size() > 0){
        Shape undoShape;
        undoShape = shapes.get(shapes.size()-1);
        undoShapes.add(undoShape);
        shapes.remove(shapes.size() - 1);
        }
        
    }
    //adds duplicate of undoShape object to shapes array before removing an object from undoShapes array list
    public void redo(){
        //redo method only works if there are elements in undoShapes array
        if (undoShapes.size() > 0){
        Shape redoShape;
        redoShape = undoShapes.get(undoShapes.size()-1);
        shapes.add(redoShape);
        undoShapes.remove(undoShapes.size()-1);
        }

    }

    /**
     * Returns the currently selected shape type (what the user would draw if they 
     * clicked and dragged).
     * @return ShapeType
     */
    public ShapeType getCurrentShape() {
        return currentShape;
    }

    /**
     * Sets the current shape type (what the user will draw if they click and drag)
     * @param currentShape 
     */
    public void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }

    /**
     * Returns the current lineColor for drawing
     * @return Color
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Sets the current lineColor for drawing
     * @param lineColor Color
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /** 
     * Allows you to check whether user has their mouse pressed down
     * @return boolean true if mouse is down
     */
    public boolean isMouseDown() {
        return mouseDown;
    }

    /**
     * Sets the mouseDown to true or false
     * @param mouseDown boolean true if mouse button is pressed down
     */
    public void setMouseDown(boolean mouseDown) {
        this.mouseDown = mouseDown;
    }

    /**
     * Returns current x coordinate of cursor
     * @return int x coord
     */
    public int getCurrentX() {
        return currentX;
    }

    /**
     * Sets the current X coord of cursor
     * @param currentX int x coord
     */
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    /**
     * Returns current y coordinate of cursor
     * @return int y coord
     */
    public int getCurrentY() {
        return currentY;
    }

    /**
     * Sets the current y coordinate of cursor
     * @param currentY int y coord
     */
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    /**
     * Returns the x coordinate where the mouse was pressed down
     * @return int x coord
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Set the x coordinate of where the mouse was pressed down
     * @param startX int x coordinate
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Returns the y coordinate of where the mouse was pressed down
     * @return int y
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Set the y coordinate of where the mouse was pressed down
     * @param startY int y coord
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Returns the current fill color for drawing
     * @return Color fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Sets the current fill color for drawing
     * @param fillColor Color
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    
    
    
}
