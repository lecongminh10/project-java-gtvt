public class Line extends AbstractShape {
    private Point start;
    private Point end;

    public Line() {
        this.start = new Point(0, 0);
        this.end   = new Point(1, 0);
    }

    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end   = new Point(end);
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end   = new Point(x2, y2);
    }

    public Point getStart() { return start; }
    public Point getEnd()   { return end; }
    public void setStart(Point start) { this.start = new Point(start); }
    public void setEnd(Point end)     { this.end   = new Point(end); }

    public double length() {
        return start.distance(end);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return length();
    }

    @Override
    public Point center() {
        return new Point((start.getX() + end.getX()) / 2,
                         (start.getY() + end.getY()) / 2);
    }

    @Override
    public double distance(Point p) {
        return center().distance(p);
    }


    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        Point c = center();
        start.rotateAround(c, angle);
        end.rotateAround(c, angle);
    }


    @Override
    public void zoom(double ratio) {
        Point c = center();
        start.zoomAround(c, ratio);
        end.zoomAround(c, ratio);
    }

    @Override
    public String toString() {
        return String.format("ĐoạnThẳng[%s -> %s, độ dài=%.2f]", start, end, length());
    }
}
