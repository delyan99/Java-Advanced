public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        return bottomLeft.getX() <= point.getX() && bottomLeft.getY() <= point.getY()
                && topRight.getX() >= point.getX() && topRight.getY() >= point.getY();
    }
}
