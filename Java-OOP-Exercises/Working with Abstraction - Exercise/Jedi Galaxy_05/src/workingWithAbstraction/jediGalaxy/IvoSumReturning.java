package workingWithAbstraction.jediGalaxy;

public class IvoSumReturning {
    public static int returnIvoSum(Matrix matrix, int[] ivoCoordinates){
        int sum = 0;
        int ivoRows = ivoCoordinates[0];
        int ivoCols = ivoCoordinates[1];

        while (ivoRows >= 0 && ivoCols < matrix.getMatrixColLength())
        {
            if (ivoRows < matrix.getMatrixRowLength() && ivoCols >= 0) {
                sum += matrix.getCurrentValueFromMatrix(ivoRows, ivoCols);
            }

            ivoCols++;
            ivoRows--;
        }
        return sum;
    }
}
