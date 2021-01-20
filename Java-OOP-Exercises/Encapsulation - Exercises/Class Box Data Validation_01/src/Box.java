public class Box {
    private double length;
    private double width;
    private double height;

    public Box (double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length){
        validateData(length, "Length");
        this.length = length;
    }

    private void setWidth(double wight){
        validateData(wight, "Width");
        this.width = wight;
    }

    private void setHeight(double height){
        validateData(height, "Height");
        this.height = height;
    }

    private void validateData(double size, String stringVariable) {
        if(size <= 0){
            throw new IllegalArgumentException(stringVariable + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea (){
        return  2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea (){
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume (){
        return this.length * this.width * this.height;
    }
}
