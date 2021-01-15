package workingWithAbstraction.jediGalaxy;

public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int cols){
        this.matrix = new int[rows][cols];
    }

    public void matrixFill(){
        int value = 0;
        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < this.matrix[i].length; j++)
            {
                this.matrix[i][j] = value++;
            }
        }
    }

    public int getMatrixRowLength() {
        return this.matrix.length;
    }

    public int getMatrixColLength() {
        return this.matrix[0].length;
    }

    public void setMatrix(int rows, int cols, int newValue){
        this.matrix[rows][cols] = newValue;
    }

    public int getCurrentValueFromMatrix(int row, int col) {
        return matrix[row][col];
    }
}
