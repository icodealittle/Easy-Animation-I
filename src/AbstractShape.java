import java.awt.Color;

/**
 * A Constructor method that represent AbstractShape in an abstract class.
 * Due to all shape tyoes being share common fields, which the include the getter method
 *     for these fields.
 */
public abstract class AbstractShape implements ShapeInterface {

  private String name;
  private ShapeTypes type;
  private Position coordinate;
  private double xWidth;
  private double yHeight;
  private Color color;
  private int appears;
  private int disappears;

  /**
   * A constructor method that {@code AbstractShape} objects.
   * @param name the name of the shapes being call – rectangle, oval, etc.
   * @param type the type of shapes – from enum method: RECTANGLE and OVAL.
   * @param coordinate the coordinate points of the shape.
   * @param xWidth the width length of the shape.
   * @param yHeight the height length of the shape.
   * @param color the color of the shape
   * @param appears the appearance time of the shape.
   * @param disappears the disappearance time of the shape.
   * @throws IllegalArgumentException if either both – apperance and disappearance time,
   *     being negative, if both width and height are negative, or if the disappearance time
   *     happens to be appear before the apperance time.
   */
  public AbstractShape(String name, ShapeTypes type, Position coordinate,
                       double xWidth, double yHeight, Color color, int appears,
                       int disappears) throws IllegalArgumentException {
    if (appears < 0 || disappears < 0) {
      throw new IllegalArgumentException("Appear or disappear time cannot be negative");
    }

    if (xWidth < 0 || yHeight < 0) {
      throw new IllegalArgumentException("Width or height cannot be negative");
    }

    if (appears > disappears) {
      throw new IllegalArgumentException("Appear time cannot be after disappear time");
    }

    if (appears == disappears) {
      throw new IllegalArgumentException("Appear time cannot be at the same "
              + "time as disappear time.");
    }

    if (xWidth == yHeight) {
      throw new IllegalArgumentException("We're calling rectangle and Oval. Not a square.");
    }

    this.name = name;
    this.type = type;
    this.coordinate = coordinate;
    this.xWidth = xWidth;
    this.yHeight = yHeight;
    this.color = color;
    this.appears = appears;
    this.disappears = disappears;
  }

  @Override
  public void setDim1(double dim1) {
    if (dim1 < 0) {
      throw new IllegalArgumentException("Dimension cannot be negative");
    }
    else {
      this.xWidth = dim1;
    }
  }

  @Override
  public void setDim2(double dim2) {
    if (dim2 < 0) {
      throw new IllegalArgumentException("Dimension cannot be negative");
    }
    else {
      this.yHeight = dim2;
    }
  }

  @Override
  public String getDimensions() {
    return this.dim1String() + this.xWidth + ", " + this.dim2String() + this.yHeight;
  }

  @Override
  public String getShapeDescription() {
    return "Name: " + this.name + "\n" + "Type: " + this.type.toString() + "\n"
            + this.getPositionString() + ", "
            + this.getDimensions() + ", "
            + getColorValues(this.color) + "\n"
            + "Appears at t=" + this.appears + "\n" + "Disappears at t=" + this.disappears + "\n";
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeTypes getShapeType() {
    return this.type;
  }

  @Override
  public int getAppearance() {
    return this.appears;
  }

  @Override
  public int getDisappearance() {
    return this.disappears;
  }

  @Override
  public Position getPosition() {
    return this.coordinate;
  }

  @Override
  public void setPosition(Position newPosition) {
    this.coordinate = newPosition;
  }

  @Override
  public double getWidth() {
    return this.xWidth;
  }

  @Override
  public double getHeight() {
    return this.yHeight;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * A helper method for color value.
   * @param x the color value.
   * @return new color value.
   */
  public static float getColorFloat(int x) {
    return (float) (x / 255);
  }

  /**
   * A helper method for position getter in a string format.
   * @param position the coodinate point
   * @return the shape coodinate point in a string format – (X, Y)
   */
  public static String getPositionString(Position position) {
    return "(" + position.getX() + "," + position.getY() + ")";
  }

  /**
   * A helper method for a appear time string getter.
   * @return appearance time in a string format.
   */
  public String getAppearTime() {
    return "t=" + this.getAppearance();
  }

  /**
   * A helper method for a disappear time string getter.
   * @return disappearance time in a string format.
   */
  public String getDisappearTime() {
    return "t=" + this.getDisappearance();
  }

  /**
   * A helper methods for color getter in a string form.
   * @param color an object of color.
   * @return the RGB value in a string format.
   */
  public static String getColorValues(Color color) {
    return "Color: " + "(" + getColorFloat(color.getRed()) + ","
            + getColorFloat(color.getGreen()) + ","
            + getColorFloat(color.getBlue()) + ")";
  }

  @Override
  public void setColor(Color newColor) {
    this.color = newColor;
  }
}
