package Tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class InputData {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("C:\\Users\\mylty\\IdeaProjects\\Algorithms\\src\\Semistr\\data.txt");
        (new Random()).ints(10000).forEach(writer::println);
        writer.close();
    }
}