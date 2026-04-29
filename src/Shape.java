
public interface Shape {

    double area();

    double perimeter();

    double distance(Point p);

    Point center();


    void move(double dx, double dy);


    void rotate(double angle);

    void zoom(double ratio);
}
