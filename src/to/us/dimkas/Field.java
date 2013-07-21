package to.us.dimkas;

/**
 * Created with IntelliJ IDEA.
 * User: dimkas
 * Date: 7/21/13
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
public class Field {
    public static int FIELD_SIZE = 3;
    public static char DEFAULT_FIELD_VALUE = ' ';
    private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    public void eraseField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i][lineNumber] = DEFAULT_FIELD_VALUE;
        }
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i <FIELD_SIZE; i++) {
            showCell(i, lineNumber);
        }
    }

    public void showField() {
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }
}
