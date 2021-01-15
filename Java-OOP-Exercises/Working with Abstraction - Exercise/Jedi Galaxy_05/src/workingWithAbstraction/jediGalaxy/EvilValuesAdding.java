package workingWithAbstraction.jediGalaxy;

public class EvilValuesAdding {
    public static void addEvilValues(Matrix matrix, int[] evilCoordinates){
        int evilRows = evilCoordinates[0];
        int evilCols = evilCoordinates[1];

        while (evilRows >= 0 && evilCols >= 0)
        {
            if (evilRows < matrix.getMatrixRowLength() && evilCols < matrix.getMatrixColLength()) {
                matrix.setMatrix(evilRows, evilCols, 0);
            }
            evilRows--;
            evilCols--;
        }
    }
}
