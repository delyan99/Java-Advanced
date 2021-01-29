public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius){
        this.radius = radius;
    }


    @Override
    double calculatePerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public final Double getRadius() {
        return radius;
    }
}
