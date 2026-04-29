public class Circle extends AbstractShape {
    private Point center;
    private double radius;
    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Circle(Point center, double radius) {
        if (radius < 0) throw new IllegalArgumentException("Bán kính phải >= 0");
        this.center = new Point(center);
        this.radius = radius;
    }

    public Circle(double cx, double cy, double radius) {
        this(new Point(cx, cy), radius);
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Bán kính phải >= 0");
        this.radius = radius;
    }


    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Point center() {
        return new Point(center);
    }

    @Override
    public double distance(Point p) {
        return center.distance(p);
    }


    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void zoom(double ratio) {
        this.radius *= ratio;
    }

    @Override
    public String toString() {
        return String.format("HìnhTròn[tâm=%s, bán kính=%.2f, diện tích=%.2f, chu vi=%.2f]",
                center, radius, area(), perimeter());
    }
}
