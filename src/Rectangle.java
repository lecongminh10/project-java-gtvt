public class Rectangle extends AbstractShape {
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;
    private Point bottomLeft;

    public Rectangle() {
        this.topLeft     = new Point(0, 0);
        this.topRight    = new Point(1, 0);
        this.bottomRight = new Point(1, 1);
        this.bottomLeft  = new Point(0, 1);
    }

    public Rectangle(double x, double y, double width, double height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException("Chiều rộng và chiều cao phải >= 0");
        this.topLeft     = new Point(x,         y);
        this.topRight    = new Point(x + width,  y);
        this.bottomRight = new Point(x + width,  y + height);
        this.bottomLeft  = new Point(x,          y + height);
    }

    public static Rectangle fromCenter(double cx, double cy, double width, double height) {
        return new Rectangle(cx - width / 2, cy - height / 2, width, height);
    }

    public double getWidth() {
        return topLeft.distance(topRight);
    }

    public double getHeight() {
        return topLeft.distance(bottomLeft);
    }

    public Point getTopLeft()     { return topLeft; }
    public Point getTopRight()    { return topRight; }
    public Point getBottomRight() { return bottomRight; }
    public Point getBottomLeft()  { return bottomLeft; }

    @Override
    public double area() {
        return getWidth() * getHeight();
    }

    @Override
    public double perimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    public Point center() {
        return new Point(
            (topLeft.getX() + bottomRight.getX()) / 2,
            (topLeft.getY() + bottomRight.getY()) / 2
        );
    }

    @Override
    public double distance(Point p) {
        return center().distance(p);
    }


    @Override
    public void move(double dx, double dy) {
        topLeft.move(dx, dy);
        topRight.move(dx, dy);
        bottomRight.move(dx, dy);
        bottomLeft.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        Point c = center();
        topLeft.rotateAround(c, angle);
        topRight.rotateAround(c, angle);
        bottomRight.rotateAround(c, angle);
        bottomLeft.rotateAround(c, angle);
    }


    @Override
    public void zoom(double ratio) {
        Point c = center();
        topLeft.zoomAround(c, ratio);
        topRight.zoomAround(c, ratio);
        bottomRight.zoomAround(c, ratio);
        bottomLeft.zoomAround(c, ratio);
    }

    @Override
    public String toString() {
        return String.format("HìnhChữNhật[gócTrênTrái=%s, rộng=%.2f, cao=%.2f, diện tích=%.2f, chu vi=%.2f]",
                topLeft, getWidth(), getHeight(), area(), perimeter());
    }
}
