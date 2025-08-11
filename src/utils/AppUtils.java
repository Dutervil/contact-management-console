package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import static constant.AppConstant.FILE_PATH;


public class AppUtils {

    public static void initializeFile() throws IOException {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("id;name;email;phone");
                writer.newLine();
            }
        }
    }



    public static Integer generateId() {
      Random random = new Random();
      return random.nextInt(100);
    }


}
