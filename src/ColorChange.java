import java.awt.Color;

/**
 * A constructor method that represent the change of colours for shape animation.
 */
public class ColorChange extends AbstractAnimation {

  private Color startColor;
  private Color endColor;

  /**
   * A constructor method for a {@code ColorChange} objects.
   *
   * @param shape      the shape that would be move when the animation will be implemented on.
   * @param startColor the original shape colour for the animation.
   * @param endColor   the new shape colour for the animation.
   * @param startTime  the start time of the animation.
   * @param endTime    the end time of the animation.
   */
  public ColorChange(ShapeInterface shape, Color startColor,
                     Color endColor, int startTime, int endTime) {
    super(Animations.COLORCHANGE, shape, startTime, endTime);
    this.startColor = startColor;
    this.endColor = endColor;
  }

  @Override
  public void animations(double time) {
    float changeRed;
    float changeGreen;
    float changeBlue;
    float timeChange;
    float toRed;
    float toGreen;
    float toBlue;
    changeRed = AbstractShape.getColorFloat(this.endColor.getRed()
            - this.startColor.getRed());
    changeGreen = AbstractShape.getColorFloat(this.endColor.getGreen()
            - this.startColor.getGreen());
    changeBlue = AbstractShape.getColorFloat(this.endColor.getBlue()
            - this.startColor.getBlue());
    timeChange = (float) (time - this.getStartTime())
            / (float) (this.getEndTime() - this.getStartTime());

    if ((time > this.getEndTime()) || time < this.getStartTime()) {
      throw new IllegalArgumentException("Time is invalid");
    } else {
      toRed = (timeChange * changeRed)
              + AbstractShape.getColorFloat(this.startColor.getRed());
      toGreen = (timeChange * changeGreen)
              + AbstractShape.getColorFloat(this.startColor.getGreen());
      toBlue = (timeChange * changeBlue)
              + AbstractShape.getColorFloat(this.startColor.getBlue());
      Color changeColor = new Color(toRed, toGreen, toBlue);
      this.getShape().setColor(changeColor);
    }
  }

  /**
   * A helper methods for color getter in a string form.
   *
   * @param c an object of color.
   * @return the RGB value in a string format.
   */
  private String getColorString(Color c) {
    return "(" + AbstractShape.getColorFloat(c.getRed()) + ","
            + AbstractShape.getColorFloat(c.getGreen()) + ","
            + AbstractShape.getColorFloat(c.getBlue()) + ")";
  }

  @Override
  public String getStartState() {
    return getColorString(this.startColor);
  }

  @Override
  public String getEndState() {
    return getColorString(this.endColor);
  }

  @Override
  public String getAnimationInfo() {
    return "changes color";
  }
}
