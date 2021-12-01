/**
 * A constructor method that represent an abstract class for animations that have
 *     similar spec fields of the Animation enum class, and Shape, which the start time and
 *     end time being also being implement. The methods for the fiels in this abstract class
 *     are the same between all Animation class.
 */
public abstract class AbstractAnimation implements AnimationInterface {
  private Animations type;
  private int startTime;
  private int endTime;
  private ShapeInterface shape;

  /**
   * A method constructor for AbstractAnimation class that takes in objects.
   * @param type the type of animation.
   * @param shape the shape that being move for the animation, which will be implements on.
   * @param startTime the start time of the animation.
   * @param endTime the end time of the animation.
   * @throws IllegalArgumentException if either start or end time being negative integer.
   *     Similar when the start time starts later than disappear time.
   */
  public AbstractAnimation(Animations type, ShapeInterface shape,
                           int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("time cannot be negative");
    }
    if (startTime > endTime) {
      throw new IllegalArgumentException("starting time cannot be greater than ending time");
    }
    this.type = type;
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
  }


  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public ShapeInterface getShape() {
    return this.shape;
  }


  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public Animations getAnimationType() {
    return this.type;
  }

  @Override
  public String getAnimationDescription() {
    return "Shape " + this.shape.getName() + " " + this.getAnimationInfo() + " from "
            + this.getStartState() + " to " + this.getEndState() + " from t="
            + this.startTime + " to t=" + this.endTime;
  }

}
