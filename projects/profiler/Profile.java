import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Profile {

    public static void main(String[] args) {
        // ...
    }

    /**
     * Read a file and return an array of lines
     *
     * @param filename The filename (path) to read
     * @return         An array of lines read
     */
    public static String[] readLines(String filename) {
        String[] data;

        try {
            Path path = Paths.get(filename);
            data = Files.readString(path).strip().split("\n");
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
            data = new String[0];
        }

        return data;
    }
}
