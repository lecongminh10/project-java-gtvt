
public class Point extends AbstractShape {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double distance(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public Point center() {
        return new Point(this);
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void rotate(double angle) {

    }

    public void rotateAround(Point pivot, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double dx = this.x - pivot.x;
        double dy = this.y - pivot.y;
        this.x = pivot.x + dx * cosA - dy * sinA;
        this.y = pivot.y + dx * sinA + dy * cosA;
    }


    public void zoomAround(Point pivot, double ratio) {
        this.x = pivot.x + (this.x - pivot.x) * ratio;
        this.y = pivot.y + (this.y - pivot.y) * ratio;
    }

    @Override
    public void zoom(double ratio) {

    }

    @Override
    public String toString() {
        return String.format("Điểm(%.2f, %.2f)", x, y);
    }
}
