public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width){
        this.height = height;
        this.width = width;
    }


    @Override
    double calculatePerimeter() {
        return 2 * this.height + 2 * this.width;
    }

    @Override
    double calculateArea() {
        return this.height * this.width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
}
