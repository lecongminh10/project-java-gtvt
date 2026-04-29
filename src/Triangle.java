public class Triangle extends AbstractShape {
    private Point p1, p2, p3;

    public Triangle() {
        this.p1 = new Point(0, 0);
        this.p2 = new Point(1, 0);
        this.p3 = new Point(0, 1);
    }

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
    }

    public Point getP1() { return p1; }
    public Point getP2() { return p2; }
    public Point getP3() { return p3; }

    public void setP1(Point p) { this.p1 = new Point(p); }
    public void setP2(Point p) { this.p2 = new Point(p); }
    public void setP3(Point p) { this.p3 = new Point(p); }


    @Override
    public double area() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }


    @Override
    public double perimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public Point center() {
        return new Point(
            (p1.getX() + p2.getX() + p3.getX()) / 3.0,
            (p1.getY() + p2.getY() + p3.getY()) / 3.0
        );
    }

    @Override
    public double distance(Point p) {
        return center().distance(p);
    }


    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        p3.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        Point c = center();
        p1.rotateAround(c, angle);
        p2.rotateAround(c, angle);
        p3.rotateAround(c, angle);
    }

    @Override
    public void zoom(double ratio) {
        Point c = center();
        p1.zoomAround(c, ratio);
        p2.zoomAround(c, ratio);
        p3.zoomAround(c, ratio);
    }

    @Override
    public String toString() {
        return String.format("HìnhTamGiác[p1=%s, p2=%s, p3=%s, diện tích=%.2f, chu vi=%.2f]",
                p1, p2, p3, area(), perimeter());
    }
}
