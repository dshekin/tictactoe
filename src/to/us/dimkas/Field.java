package to.us.dimkas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            setCellValue(i, lineNumber, DEFAULT_FIELD_VALUE);
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

    private void setCellValue(int x, int y, char value) {
        field[x][y] = value;
    }

    public void humanMove() throws IOException {
        int x, y;
        System.out.println("Enter x(1-3):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine()) - 1;
        System.out.println("Enter y(1-3):");
        y = Integer.parseInt(br.readLine()) - 1;

        setCellValue(x, y, 'X');
    }
}
