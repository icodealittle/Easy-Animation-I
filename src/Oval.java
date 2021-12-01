import java.awt.Color;

/**
 * A constructor method that represent the Oval shape, which consider as an
 *     extension from the Shape abstract class.
 */
public class Oval extends AbstractShape {

  /**
   * A method constructor for Oval that take in objects.
   * Due to an extends implementaton for the class, the method constructor would have
   *     to use super() to call the objects from the abstract class.
   * @param name Name of the shape, which is Oval.
   * @param type The of shape that being call form enum class.
   * @param coordinate the Position coordinate points of the shape.
   * @param width the width of the shape.
   * @param height the height of the shape.
   * @param color the colour of the shape.
   * @param appears the time when the shape first appear.
   * @param disappears the time when the shape disappear.
   */
  public Oval(String name, ShapeTypes type, Position coordinate, double width,
                   double height, Color color, int appears, int disappears) {
    super(name, type, coordinate, width, height, color, appears, disappears);
  }

  public String getPositionString() {
    return "Center: " + getPositionString(this.getPosition());
  }

  @Override
  public String getWidthString() {
    return "X radius: " + this.getWidth();
  }

  @Override
  public String getHeightString() {
    return "Y radius: " + this.getHeight();
  }

  @Override
  public String dim1String() {
    return "X radius: ";
  }

  @Override
  public String dim2String() {
    return "Y radius: ";
  }

  @Override
  public String getColorValues() {
    return "Color: " + "(" + getColorFloat(this.getColor().getRed()) + ","
            + getColorFloat(this.getColor().getGreen()) + ","
            + getColorFloat(this.getColor().getBlue()) + ")";
  }

}