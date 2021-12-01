/**
 * A constructor method that represent the movement changes for shaoe animation.
 */
public class Moving extends AbstractAnimation {

  private Position startPosition;
  private Position endPosition;

  /**
   * A constructor method for a {@code Moving} objects.
   * @param shape the shape that would be move when the animation will be implemented on.
   * @param startPosition the original shape for the animation.
   * @param endPosition the new shape moved for the animation.
   * @param startTime  the start time of the animation.
   * @param endTime the end time of the animation.
   */
  public Moving(ShapeInterface shape, Position startPosition,
                Position endPosition, int startTime, int endTime) {
    super(Animations.MOVING, shape, startTime, endTime);
    this.startPosition = startPosition;
    this.endPosition = endPosition;
  }


  @Override
  public String getStartState() {
    return AbstractShape.getPositionString(this.startPosition);
  }

  @Override
  public String getEndState() {
    return AbstractShape.getPositionString(this.endPosition);
  }

  @Override
  public void animations(double time) {
    double xChange;
    double yChange;
    double timeChange;
    double toX;
    double toY;
    xChange = this.endPosition.getX() - this.startPosition.getX();
    yChange = this.endPosition.getY() - this.startPosition.getY();
    timeChange = (time - this.getStartTime())
            / (double) (this.getEndTime() - this.getStartTime());
    if (time > this.getEndTime() || time < this.getStartTime()) {
      throw new IllegalArgumentException("Time is invalid");
    } else {
      toX = (xChange * timeChange) + this.startPosition.getX();
      toY = (yChange * timeChange) + this.startPosition.getY();
      Position newPosition = new Position(toX, toY);
      this.getShape().setPosition(newPosition);
    }
  }

  @Override
  public String getAnimationInfo() {
    return "moves";
  }
}
