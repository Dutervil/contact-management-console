
import output.App;

import java.io.IOException;

import static utils.AppUtils.initializeFile;
public class Main {
    public static void main(String[] args) throws IOException {
        initializeFile();

        
         new App().start();
    }
}