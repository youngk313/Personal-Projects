package q2;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * <p> This program draws a star based on the length that the user provides
 * by pressing and dragging the mouse across the interface. The star will
 * re-orient and resize based on a new drag event. </p>
 *
 * @author Young Kwon
 * @version 1.0
 */
public class DrawStar extends Application {
	/** The first line drawn by the user. */
    private Line thisLine = new Line();
    /** The contents of the application scene. */
    private Group root;

    /** circle to move to first mouse click location. */
    private Circle atCenter;
   
    /** Half-angle inside the point of a star (in degrees). */
    private final double angleDeg = 72.0;
    
    /** Size of the centre circle to be drawn. */
    private final int circleSize = 3;
	
    /** Width of the lines to be drawn. */
    private final int strokeWidth = 4;
    
    /** Constant of three. */
    private final int three = 3;
    
    /** Constant of four. */
    private final int four = 4;
    
    /** Constant of five. */
    private final int five = 5;
    
    /** First point of the star. */
    private Point2D localPoint1;
    
    /** Second point of the star. */
    private Point2D localPoint2;
    
    /** Third point of the star. */
    private Point2D localPoint3;
    
    /** Fourth point of the star. */
    private Point2D localPoint4;
    
    /** Fifth point of the star. */
    private Point2D localPoint5;
    /** The center dot of the star. */
    private Group pic;
    
    /**
     * Displays an initially empty scene, waiting for the user to draw lines
     * with the mouse.
     * 
     * @param primaryStage
     *            a Stage
     */
    public void start(Stage primaryStage) {
        root = new Group();
        
        final int appWidth = 1000;
        final int appHeight = 800;
        Scene scene = new Scene(root, appWidth, appHeight, Color.BLACK);
        scene.setOnMousePressed(this::processMousePress);
        scene.setOnMouseDragged(this::processMouseDrag);

        primaryStage.setTitle("Star");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /** Event with executable code when the mouse has been pressed. 
     * @event mouse click event will invoke this method 
     * @param event */
    
    public void processMousePress(MouseEvent event) {
    	pic = new Group();
        atCenter = new Circle(event.getX(), event.getY(), circleSize);
        atCenter.setFill(Color.WHITE);
        pic.getChildren().add(atCenter);
        thisLine.setStartX(atCenter.getCenterX());
        thisLine.setStartY(atCenter.getCenterY());
        thisLine.setStrokeWidth(strokeWidth);
    }

    /** Creates the five points needed to start drawing the star and
     * transforms the points around the center to start drawing. */
    private void createCircles() {
    	Circle firstPoint = new Circle(thisLine.getEndX(), thisLine.getEndY(),
          		circleSize);
        Circle secondPoint = new Circle(thisLine.getEndX(), thisLine.getEndY(), 
          		circleSize);
        Circle thirdPoint = new Circle(thisLine.getEndX(), thisLine.getEndY(), 
          		circleSize);
        Circle fourthPoint = new Circle(thisLine.getEndX(), thisLine.getEndY(), 
          		circleSize);
        Circle fifthPoint = new Circle(thisLine.getEndX(), thisLine.getEndY(), 
          		circleSize);
        firstPoint.setFill(Color.CYAN);
        secondPoint.setFill(Color.CYAN);
        thirdPoint.setFill(Color.CYAN);
        fourthPoint.setFill(Color.CYAN);
        fifthPoint.setFill(Color.CYAN);
          
        firstPoint.getTransforms().add(new Rotate(angleDeg, 
          atCenter.getCenterX(), atCenter.getCenterY()));
        localPoint1 = firstPoint.localToParent(thisLine.getEndX(), 
          thisLine.getEndY());
        secondPoint.getTransforms().add(new Rotate(2 * angleDeg, 
          atCenter.getCenterX(), atCenter.getCenterY()));
        localPoint2 = secondPoint.localToParent(thisLine.getEndX(), 
          thisLine.getEndY());
        thirdPoint.getTransforms().add(new Rotate(three * angleDeg, 
          atCenter.getCenterX(), atCenter.getCenterY()));
        localPoint3 = thirdPoint.localToParent(thisLine.getEndX(),
          thisLine.getEndY());
        fourthPoint.getTransforms().add(new Rotate(four * angleDeg, 
          atCenter.getCenterX(), atCenter.getCenterY()));
        localPoint4 = fourthPoint.localToParent(thisLine.getEndX(), 
          thisLine.getEndY());
        fifthPoint.getTransforms().add(new Rotate(five * angleDeg, 
          atCenter.getCenterX(), atCenter.getCenterY()));
        localPoint5 = fifthPoint.localToParent(thisLine.getEndX(), 
          thisLine.getEndY());
    }
    
    /**
     * Updates the end point of the current line as the mouse is dragged,
     * creating the rubber band effect.
     * 
     * @event event
     *            invoked this method
     * @param event 
     */
    
    public void processMouseDrag(MouseEvent event) {
        root.getChildren().clear();
        root.getChildren().add(pic);
        thisLine.setEndX(event.getX());
        thisLine.setEndY(event.getY());
        createCircles();
        Line line1 = new Line(localPoint1.getX(), localPoint1.getY(), 
        		localPoint3.getX(), localPoint3.getY());

        line1.setStroke(Color.BLUE);
        line1.setStrokeWidth(strokeWidth);
        root.getChildren().add(line1);
        Line line2 = new Line(localPoint1.getX(), localPoint1.getY(), 
        		localPoint4.getX(), localPoint4.getY());

        line2.setStroke(Color.RED);
        line2.setStrokeWidth(strokeWidth);
        root.getChildren().add(line2);
        Line line3 = new Line(localPoint2.getX(), localPoint2.getY(), 
        		localPoint4.getX(), localPoint4.getY());

        line3.setStroke(Color.GREEN);
        line3.setStrokeWidth(strokeWidth);
        root.getChildren().add(line3);
        Line line4 = new Line(localPoint2.getX(), localPoint2.getY(), 
        		localPoint5.getX(), localPoint5.getY());

        line4.setStroke(Color.CYAN);
        line4.setStrokeWidth(strokeWidth);
        root.getChildren().add(line4);
        Line line5 = new Line(localPoint3.getX(), localPoint3.getY(), 
        		localPoint5.getX(), localPoint5.getY());
        line5.setStroke(Color.YELLOW);
        line5.setStrokeWidth(strokeWidth);
        root.getChildren().add(line5);
    }
    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

