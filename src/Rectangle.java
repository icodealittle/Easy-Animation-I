import java.awt.Color;

/**
 * A constructor method that represent the Rectangle shape, which consider as an
 *     extension from the Shape abstract class.
 */
public class Rectangle extends AbstractShape {

  /**
   * A method constructor for rectangle that take in objects.
   * Due to an extends implementaton for the class, the method constructor would have
   *     to use super() to call the objects from the abstract class.
   * @param name Name of the shape, which is Rectangle.
   * @param type The of shape that being call form enum class.
   * @param coordinate the Position coordinate points of the shape.
   * @param width the width of the shape.
   * @param height the height of the shape.
   * @param color the colour of the shape.
   * @param appears the time when the shape first appear.
   * @param disappears the time when the shape disappear.
   */
  public Rectangle(String name, ShapeTypes type, Position coordinate, double width,
                   double height, Color color, int appears, int disappears) {
    super(name, type, coordinate, width, height, color, appears, disappears);
  }

  public String getPositionString() {
    return "Min corner: " + getPositionString(this.getPosition());
  }

  public String getWidthString() {
    return "Width: " + this.getWidth();
  }

  public String getHeightString() {
    return "Height: " + this.getHeight();
  }

  @Override
  public String dim1String() {
    return "Width: ";
  }

  @Override
  public String dim2String() {
    return "Height: ";
  }

  @Override
  public String getColorValues() {
    return "Color: " + "(" + getColorFloat(this.getColor().getRed()) + ","
            + getColorFloat(this.getColor().getGreen()) + ","
            + getColorFloat(this.getColor().getBlue()) + ")";
  }

}
