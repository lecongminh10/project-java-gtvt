public abstract class AbstractShape implements Shape {

    @Override
    public double distance(Point p) {
        return this.center().distance(p);
    }
}
