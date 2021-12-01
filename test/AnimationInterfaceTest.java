import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test for AnimationInterface.
 */
public class AnimationInterfaceTest {
  AnimationInterface changeColorRec;
  AnimationInterface changeColorOval;

  AnimationInterface scaleRec;
  AnimationInterface scaleOval;

  AnimationInterface moveRec;
  AnimationInterface moveOval;

  ShapeInterface rectangle;
  ShapeInterface oval;

  Position rectPos;
  Position newRectPos;

  Position ovalPos;
  Position newOvalPos;

  @Before
  public void setUp() {
    rectPos = new Position(200.0,200.0);
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            50.0, 100.0, Color.RED,1, 100);

    ovalPos = new Position(500.0,100.0);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 60.0,
            30.0,Color.BLUE, 6,100);
  }

  /**
   * A test to check the move position works correctly.
   */
  @Test
  public void testMoving() {
    //RECTANGLE
    newRectPos = new Position(300.0,300.0);
    moveRec = new Moving(this.rectangle, rectPos, newRectPos, 10, 50);
    assertEquals("(200.0,200.0)",
            AbstractShape.getPositionString(this.moveRec.getShape().getPosition()));
    this.moveRec.animations(50);
    assertEquals("(300.0,300.0)",
            AbstractShape.getPositionString(this.moveRec.getShape().getPosition()));
    assertEquals("Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50",
            this.moveRec.getAnimationDescription());
    //OVAL
    newOvalPos = new Position(500.0,400.0);
    moveOval = new Moving(this.oval, ovalPos, newOvalPos, 20,70);
    assertEquals("(500.0,100.0)",
            AbstractShape.getPositionString(this.moveOval.getShape().getPosition()));
    this.moveOval.animations(70);
    assertEquals("(500.0,400.0)",
            AbstractShape.getPositionString(this.moveOval.getShape().getPosition()));

  }

  /**
   * A test to check if the ColorChange() work correctly.
   */
  @Test
  public void testColorChange() {
    //RECTANGLE
    changeColorRec = new ColorChange(this.rectangle, Color.RED,
            Color.BLUE, 80, 100);
    assertEquals("Color: (1.0,0.0,0.0)",
            AbstractShape.getColorValues(this.changeColorRec.getShape().getColor()));
    this.changeColorRec.animations(100);
    assertEquals("Color: (0.0,0.0,1.0)",
            AbstractShape.getColorValues(this.changeColorRec.getShape().getColor()));


    //OVAL
    changeColorOval = new ColorChange(this.oval, Color.BLUE, Color.GREEN,50,80);
    assertEquals("Color: (0.0,0.0,1.0)",
            AbstractShape.getColorValues(this.changeColorOval.getShape().getColor()));
    this.changeColorOval.animations(80);
    assertEquals("Color: (0.0,1.0,0.0)",
            AbstractShape.getColorValues(this.changeColorOval.getShape().getColor()));
  }

  /**
   * A test to check if the Scaling() work correctly.
   */
  @Test
  public void testScaling() {
    //RECTANGLE
    scaleRec = new Scaling(this.rectangle,51,70,50.0,
            100.0, 25.0,100.0);
    assertEquals("Width: 50.0, Height: 100.0", this.scaleRec.getShape().getDimensions());
    this.scaleRec.animations(70);
    assertEquals("Width: 25.0, Height: 100.0", this.scaleRec.getShape().getDimensions());

    //OVAL
    scaleOval = new Scaling(this.oval, 30,60,60.0,
            30.0,30.0,60.0);
    assertEquals("X radius: 60.0, Y radius: 30.0",
            this.scaleOval.getShape().getDimensions());
    this.scaleOval.animations(45);
    assertEquals("X radius: 45.0, Y radius: 45.0",
            this.scaleOval.getShape().getDimensions());
    this.scaleOval.animations(60);
    assertEquals("X radius: 30.0, Y radius: 60.0",
            this.scaleOval.getShape().getDimensions());
  }

  /**
   * A test for a disappearance getter method.
   */
  @Test
  public void testCheckGetDisappearance() {
    //Oval
    assertEquals(100, this.oval.getDisappearance());

    //Rectangle
    assertEquals(100, this.rectangle.getDisappearance());
  }

  /**
   * A test for an appearance getter method.
   */
  @Test
  public void testCheckGetAppearance() {
    //Rectangle
    assertEquals(1, rectangle.getAppearance());

    //Oval
    assertEquals(6, oval.getAppearance());
  }

  /**
   * A test for illegalArgument of end time with a negative number.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckNegEnd() {
    //Rectangle
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            50.0, 100.0, Color.RED,1, -100);
    //Oval
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 30.0,
            20.0,Color.BLUE, 6,-50);
  }


  /**
   * A test for illegalArgument of start time with a negative number.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckNegStart() {
    //Rectangle
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            50.0, 100.0, Color.RED,-5, 10);
    //Oval
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 30.0,
            20.0,Color.BLUE, -8,50);
  }

  /**
   * A test for IllegalArgument for the end time ends before the start time, which tested for
   *     ColorChange().
   * In this testing block, the test to see if an illegal exception throw when the end time is:
   *     Negative, Start with zero, end time is less than start time, and when both time is neg.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckChangeColorEndBeforeStart() {
    //Rectangle
    AnimationInterface rectangle = new ColorChange(this.rectangle, Color.BLUE, Color.RED,
            10, 5);
    AnimationInterface rectNegativeEndTimes = new ColorChange(this.rectangle, Color.BLACK,
            Color.PINK, 5, -1);
    AnimationInterface rectNegativeTimes = new ColorChange(this.rectangle, Color.RED, Color.BLACK,
            -10, -15);
    AnimationInterface rectNegativeZeroTimes = new ColorChange(this.rectangle, Color.BLUE,
            Color.YELLOW, 0, 0);

    //Oval
    AnimationInterface oval = new ColorChange(this.oval, Color.CYAN, Color.BLUE,
            10, 5);
    AnimationInterface ovalNegativeEndTimes = new ColorChange(this.oval, Color.PINK, Color.BLACK,
            10, -5);
    AnimationInterface ovalNegativeTimes = new ColorChange(this.oval, Color.RED, Color.BLUE,
            -1, -5);
    AnimationInterface ovalNegativeZeroTimes = new ColorChange(this.oval, Color.WHITE, Color.BLUE,
            0, 0);
  }

  /**
   * A test for IllegalArgument for the end time ends before the start time, which tested for
   *     Moving().
   * In this testing block, the test to see if an illegal exception throw when the end time is:
   *    Negative, Start with zero, end time is less than start time, and when both time is neg.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckMoveEndTimeBeforeStart() {
    //Rectangle
    newRectPos = new Position(100, 100);
    AnimationInterface rectangle = new Moving(this.rectangle, rectPos, newOvalPos,
            20, 15);
    AnimationInterface rectNegativeEndTimes = new Moving(this.rectangle, rectPos, newOvalPos,
            10, -20);
    AnimationInterface rectNegativeTimes = new Moving(this.rectangle, rectPos, newOvalPos,
            -3, -1);
    AnimationInterface rectNegativeZeroTimes = new Moving(this.rectangle, rectPos, newOvalPos,
            0, 0);

    //Oval
    newOvalPos = new Position(50, 50);
    AnimationInterface oval = new Moving(this.oval, ovalPos, newOvalPos,
            50, 35);
    AnimationInterface ovalNegativeTimes = new Moving(this.oval, ovalPos, newOvalPos,
            -1, -1);
    AnimationInterface ovalNegativeEndTimes = new Moving(this.oval, ovalPos, newOvalPos,
            0, -1);
    AnimationInterface ovalNegativeZeroTimes = new Moving(this.oval, ovalPos, newOvalPos,
            0, 0);
  }

  /**
   * A test for IllegalArgument for the end time ends before the start time, which tested for
   *     Scaling().
   * In this testing block, the test to see if an illegal exception throw when the end time is:
   *    Negative, Start with zero, end time is less than start time, and when both time is neg.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckScaleEndBeforeStart() {
    //Rectangle
    AnimationInterface rectangle = new Scaling(this.rectangle, 25, 10,
            30.5, 40, 25, 45);
    AnimationInterface rectNegativeTimes = new Scaling(this.rectangle, -5, -2,
            30.5, 40, 25, 45);
    AnimationInterface rectNegativeEndTimes = new Scaling(this.rectangle, 25,
            -10, 30.5, 40, 25, 45);
    AnimationInterface rectNegativeZeroTimes = new Scaling(this.rectangle, 0, 0,
            30.5, 40, 25, 45);

    //Oval
    AnimationInterface oval = new Scaling(this.oval, 10, 5,
            20, 15, 10, 5);
    AnimationInterface ovalNegativeTimes = new Scaling(this.oval, -1, -2,
            20, 15, 5, 10);
    AnimationInterface ovalNegativeEndTimes = new Scaling(this.oval, 0, -1,
            20, 15, 15, 13);
    AnimationInterface ovalNegativeZeroTimes = new Scaling(this.oval, 0, 0,
            20, 15, 20, 5);
  }
}