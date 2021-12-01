/**
 * A constructor method that represent the change of dimension for the shape animation.
 */
public class Scaling extends AbstractAnimation {

  private double dim1;
  private double dim2;
  private double newDim1;
  private double newDim2;

  /**
   * A constructor method for a {@code Scaling} object.
   * @param shape the shape that would be move when the animation will be implemented on.
   * @param startTime the start time of the animation.
   * @param endTime the end time of the animation.
   * @param dim1 The data to change one dimension of the shape.
   * @param dim2 The data to change the second dimension of the shape.
   * @param newDim1 the new change one dimension of the shape.
   * @param newDim2 the new change the second dimension of the shape.
   */
  public Scaling(ShapeInterface shape, int startTime, int endTime,
                 double dim1, double dim2, double newDim1, double newDim2) {
    super(Animations.SCALING, shape, startTime, endTime);
    if (dim1 < 0 || dim2 < 0 || newDim1 < 0 || newDim2 < 0) {
      throw new IllegalArgumentException("Dimensions cant be negative");
    }
    this.dim1 = dim1;
    this.dim2 = dim2;
    this.newDim1 = newDim1;
    this.newDim2 = newDim2;
  }

  @Override
  public String getStartState() {
    return "Width: " + this.dim1 + "," + "Height: " + this.dim2;
  }

  @Override
  public String getEndState() {
    return "Width: " + this.newDim1 + "," + "Height: " + this.newDim2;
  }

  @Override
  public String getAnimationInfo() {
    return "scales";
  }

  @Override
  public void animations(double time) {
    double dim1Change;
    double dim2Change;
    double timeChange;
    double newX;
    double newY;
    dim1Change = this.newDim1 - this.dim1;
    dim2Change = this.newDim2 - this.dim2;

    timeChange = (time - this.getStartTime())
            / (double) (this.getEndTime() - this.getStartTime());

    if ((time > this.getEndTime()) || (time < this.getStartTime())) {
      throw new IllegalArgumentException("Time is invalid");
    } else {
      newX = this.dim1 + (timeChange * dim1Change);
      newY = this.dim2 + (timeChange * dim2Change);
      this.getShape().setDim1(newX);
      this.getShape().setDim2(newY);
    }
  }
}
