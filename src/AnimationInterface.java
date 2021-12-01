/**
 * This interface represents the Animation methods being offered.
 * This interface includes mainly getter functions.
 */
public interface AnimationInterface {

  /**
   * A getter that return the shape start state in a form of String method.
   * @return the string representation of the start state of the animation.
   */
  String getStartState();

  /**
   * A getter that return the state end state in a form of a String method.
   * @return the string representation of the end state of the animation.
   */
  String getEndState();

  /**
   * A getter that return the appear time of the animation shape.
   * @return the appear time of the animation in an int form, so the time would in an integer form.
   */
  int getStartTime();

  /**
   * A getter that return the disappear time of the animation shape.
   * @return the disappear time of the animation in an int form,
   *     so the time would in an integer form.
   */
  int getEndTime();

  /**
   * A getter that return the shape that the animation will be implemented.
   * @return the animation shape.
   */
  ShapeInterface getShape();

  /**
   * A getter that return what type of the animation.
   * @return the animation type that being implemented.
   */
  Animations getAnimationType();

  /**
   * A getter that return the the animation information in a string method form.
   * @return information of the animation that being implemented.
   */
  String getAnimationInfo();

  /**
   * A getter that return the string representation of the animation.
   * It has the shape name, animation type, and information from start to end time.
   * @return a string of the animation description.
   */
  String getAnimationDescription();

  /**
   * A method constructor that changes any appropriate fields that the
   *     animation needs to be animated.
   * @param time the starting time of the ansimation, which in the double form so the time
   *                     can be also implement as an integer or decimal points.
   */
  void animations(double time);
}
