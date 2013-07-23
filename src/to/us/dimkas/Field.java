package to.us.dimkas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: dimkas
 * Date: 7/21/13
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
public class Field {
    private static final char DEFAULT_FIELD_VALUE = ' ';
    private static final char X_CHAR = 'X';
    private static final char O_CHAR = 'O';
    private int fieldSize;
    private char[][] field;

    Field() {
        this(3);
    }

    Field(int size) {
        fieldSize = size;
        field  = new char[fieldSize][fieldSize];
    }

    public void eraseField() {
        for (int i = 0; i < fieldSize; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            setCellValue(i, lineNumber, DEFAULT_FIELD_VALUE);
        }
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            showCell(i, lineNumber);
        }
    }

    public void showField() {
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
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

        while (field[x][y] == X_CHAR || field[x][y] == O_CHAR) {
            System.out.println("wrong cell!! \n Enter x:");
            x = Integer.parseInt(br.readLine());
            System.out.println("Enter y:");
            y = Integer.parseInt(br.readLine());
        }
        setCellValue(x, y, X_CHAR);

        machineMove();
    }

    private void machineMove() {
        if (canMove()) {
            Random rnd = new Random();
            int x = rnd.nextInt(3);
            int y = rnd.nextInt(3);
            while (field[x][y] == X_CHAR || field[x][y] == O_CHAR) {
                x = rnd.nextInt(3);
                y = rnd.nextInt(3);
            }
            setCellValue(x, y, O_CHAR);
            showField();
            try {
                humanMove();
            } catch (IOException e) {
                //
            }
        } else {
            System.out.println("No more moves");
            showField();
        }
    }

    private boolean canMove() {
        boolean p = false;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == ' ') {
                    p = true;
                    return p;
                }
            }
        }
        return p;
    }


    //not used
    private void clearConsole()
    {
        try
        {
            String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception exception)
        {
            //  Handle exception.
        }
    }

}
