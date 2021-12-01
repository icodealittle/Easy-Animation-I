/**
 * A constructor method that represent of the Position class for the shape in a
 *     coordinate form – (X, Y).
 */
public class Position {
  private double x;
  private double y;

  /**
   * A method class {@code Position}, which take in objects.
   * @param x the x coordinate point of the shape position.
   * @param y the y coordinate point of the shape position.
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * A method constructor for the x coordinate point.
   * @return the x coordinate of the shape.
   */
  public double getX() {
    return this.x;
  }

  /**
   * A method constructor for the y coordinate point.
   * @return the y coordinate of the shape.
   */
  public double getY() {
    return this.y;
  }
}
