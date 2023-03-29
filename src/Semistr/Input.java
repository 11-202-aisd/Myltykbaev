package Semistr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Input {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\mylty\\IdeaProjects\\Algorithms\\src\\data.txt");

        Random random = new Random();
        for (int x = 0; x < 100; x++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100 * (x + 1); i++) {
                sb.append(random.nextInt(1000000000) + 100000000).append(" ");
            }
            writer.write(sb.toString().trim() + "\n");
        }

        writer.close();
    }
}