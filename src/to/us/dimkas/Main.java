package to.us.dimkas;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: dimkas
 * Date: 7/21/13
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String arg[]) {
        Field field = new Field();
        field.eraseField();
        field.showField();
        try {
            field.humanMove();

        } catch(IOException ioe){
            //Handle exception here, most of the time you will just log it.
        }
//        field.showField();

    }
}
