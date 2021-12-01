import java.awt.Color;

/**
 * This interface represents the Shape methods being offered.
 * This interface includes mainly getter functions, which would return the appearance and
 *     disappearance of the shaoe, the position of the shape, width and height,
 *     and the RGB color values.
 */
public interface ShapeInterface {

  /**
   * A getter that return the identfied shape name – Rectangle or Oval.
   * @return the shape name.
   */
  String getName();

  /**
   * This gets the shape details as shown on the assignment page.
   * Name:
   * Min corner: , Width/Xradius, Height/Yradius, Color.
   * Appears at t= ?
   * Disappears at t= ?
   * @return string format of the information above.
   */
  String getShapeDescription();

  /**
   * A getter that return the kind of the shape(s) that being called.
   * This getter is being call from an enum class.
   * @return The shape(s) that being called.
   */
  ShapeTypes getShapeType();

  /**
   * A getter that return the start time of this command, which is the tick that command
   *   begins on the shape.
   * @return the tick that the command assigned when to begin, which represent in term of int.
   */
  int getAppearance();

  /**
   * A getter that return the start of the of this command in a String method form.
   * @return A string of the tick that the command being set to start for the appearance.
   */
  String getAppearTime();

  /**
   * A getter that return the end time of this command, which is the tick that comman
   *     when the shape disappearance time.
   * @return the tick that the command assianged when to begin, which represent
   *     in value term of int.
   */
  int getDisappearance();

  /**
   * A getter that return the dissapearance of the shape in a String method form.
   * @return A string of the tick that the command being set when the shape need to be disappear.
   */
  String getDisappearTime();

  /**
   * A getter that retrun the position of the shape.
   * @return the position of the shape.
   */
  Position getPosition();

  /**
   * A getter that return of the position of the implemented shape in a String method form.
   * @return a String of the position of the implement shape in (X, Y) form.
   */
  String getPositionString();

  /**
   * A setter that return the coordinate points of the shape to the new shape coordinate.
   * @param newPosition the new shape coordinate points.
   */
  void setPosition(Position newPosition);

  /**
   * A getter that return the shape width.
   * @return the width of the shape, which represent in a value of double, where the width can be
   *     in either whole number or in decimal integers.
   */
  double getWidth();

  /**
   * A getter that return of the width of the shape in a String method form.
   * @return A string of the width of the shape, where it depends on the implement integer.
   *     the integer(s) can be either in whole numbers or in decimal form.
   */
  String getWidthString();

  /**
   * A getter that return the height of the shape.
   * @return the height og the shape, which represent in a value of double, where the height can be
   *     in either whole number or in decimal integers.
   */
  double getHeight();

  /**
   * A setter that return the dimension of this shape.
   * @param dim1 the first dinmension that chnage this shape to.
   * @throws java.lang.IllegalArgumentException if the double is non-positive integer.
   */
  void setDim1(double dim1);

  /**
   * A setter that return the dimension of this shape.
   * @param dim2 the second dinmension that chnage this shape to.
   * @throws java.lang.IllegalArgumentException if the double is non-positive integer.
   */
  void setDim2(double dim2);


  /**
   * A getter that return of the height of the shape in a String method form.
   * @return A string of the height of the shape, where it depends on the implement integer.
   *     the integer(s) can be either in whole numbers or in decimal form.
   */
  String getHeightString();

  /**
   * A getter that return the colour of the shape.
   * @return the color of the shape, which can be any implement colour.
   */
  Color getColor();

  /**
   * A setter that return the color of the shape ro a new color.
   * @param newColor new assigned color for the implement shape.
   */
  void setColor(Color newColor);


  /**
   * A getter that return the shape colour in a String method form.
   * @return A string of the shape colour, where it works differently. It will return the colour
   *     value in an integer form, instead of the colour name.
   */
  String getColorValues();

  /**
   * A string that return the dimension of the first dimension.
   * @return the dimension tag of the first dimension in a string method.
   */
  String dim1String();

  /**
   * A string that return the dimension of the second dimension.
   * @return the dimension tag of the second dimension in a string method.
   */
  String dim2String();

  /**
   * A getter that return the dimension of the shape.
   * @return a string form that represent the dimension of the shape.
   */
  String getDimensions();
}


