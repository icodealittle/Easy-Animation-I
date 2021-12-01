import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test for the methods.
 */
public class ShapeInterfaceTest {

  ShapeInterface rectangle;
  Position rectPos;
  ShapeInterface oval;
  Position ovalPos;

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
   * A test to check if the getName() work and call properly.
   */
  @Test
  public void testName() {
    assertEquals("C", oval.getName());
    assertEquals("R", rectangle.getName());
  }

  /**
   * A test to check if the getShapeType() work and call properly.
   */
  @Test
  public void testType() {
    assertEquals(ShapeTypes.OVAL, oval.getShapeType());
    assertEquals(ShapeTypes.RECTANGLE, rectangle.getShapeType());
  }

  /**
   * A test to check if the getWidthString() work and call properly.
   */
  @Test
  public void testWidth() {
    assertEquals("Width: 50.0", rectangle.getWidthString());
    assertEquals("X radius: 60.0", oval.getWidthString());
  }

  /**
   * A test to check if the getHeightString() work and call properly.
   */
  @Test
  public void testHeight() {
    assertEquals("Height: 100.0", rectangle.getHeightString());
    assertEquals("Y radius: 30.0", oval.getHeightString());
  }

  /**
   * A test to check if the getColorValue() work and call properly.
   */
  @Test
  public void testColor() {
    assertEquals("Color: (1.0,0.0,0.0)", rectangle.getColorValues());
    assertEquals("Color: (0.0,0.0,1.0)", oval.getColorValues());
  }

  /**
   * A test to check if the getPositionString() work and call properly.
   */
  @Test
  public void testStartingPositions() {
    assertEquals("Min corner: (200.0,200.0)", rectangle.getPositionString());
    assertEquals("Center: (500.0,100.0)", oval.getPositionString());
  }

  /**
   * A test to check if the getAppearTime() work and call properly.
   */
  @Test
  public void testAppearTime() {
    assertEquals("t=6", oval.getAppearTime());
    assertEquals("t=1", rectangle.getAppearTime());
  }

  /**
   * A test to check if the getDisappearTime() work and call properly.
   */
  @Test
  public void testDisappearTime() {
    assertEquals("t=100", oval.getDisappearTime());
    assertEquals("t=100", rectangle.getDisappearTime());
  }

  /**
   * A test to check for an illegalArgurmentException function.
   * This test is to check if the appear and disappear time throw in IllegalArgumentException
   *     if the non-positive number implmented.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAppearDisappear() {
    rectPos = new Position(200.0,200.0);
    ovalPos = new Position(500.0,100.0);

    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            50.0, 100.0, Color.RED,1, -4);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 60.0,
            30.0,Color.BLUE, -2,100);
  }

  /**
   * A test to check for an illegalArgurmentException function.
   * This test is to check if the radius, width and height time throw in IllegalArgumentException
   *     if the non-positive number implmented.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeHeightWidthRadius() {
    rectPos = new Position(200.0,200.0);
    ovalPos = new Position(500.0,100.0);

    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            -50.0, 100.0, Color.RED,1, 60);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 60.0,
            -30.0,Color.BLUE, 2,100);
  }

  /**
   * A test to check for an illegalArgumentException function.
   * This test is to check if the appear and disappear greater time
   *     throw in IllegalArgumentException if the non-positive number implemented.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAppearGreaterDisappear() {
    rectPos = new Position(200.0,200.0);
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE,rectPos,
            50.0, 100.0, Color.RED,80, 1);
    ovalPos = new Position(500.0,100.0);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 60.0,
            30.0,Color.BLUE, 100,1);
  }

  /**
   * A test to check for an illegalArgumentException function.
   * This test is to check if when the appear and disappear time display at the same time, then
   *     the command will throw in IllegalArgumentException if the display is at the same time.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckSameTime() {
    rectPos = new Position(200, 200);
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE, rectPos, 10, 20,
            Color.CYAN, 50, 50);
    ovalPos = new Position(1.2, 0.5);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 1, 1.2,
            Color.red, 5, 5);
  }

  /**
   * A test to check for an illegalArgumentException function.
   * This test is to check if when the width and height are the same length. If they both are, then
   *     the command will throw in IllegalArgumentException for having a the same length.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCheckSameWidthAndHeight() {
    rectPos = new Position(50, 50);
    rectangle = new Rectangle("R", ShapeTypes.RECTANGLE, rectPos, 10, 10,
            Color.CYAN, 50, 55);
    ovalPos = new Position(1.2, 0.5);
    oval = new Oval("C", ShapeTypes.OVAL, ovalPos, 1.2, 1.2,
            Color.red, 5, 10);
  }

  /**
   * A test to check if the shape details are printing in its correct format.
   */
  @Test
  public void testShapeDetails() {
    assertEquals("Name: R\n" +
            "Type: RECTANGLE\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n", rectangle.getShapeDescription());
    assertEquals("Name: C\n" +
            "Type: OVAL\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n", oval.getShapeDescription());
  }



}