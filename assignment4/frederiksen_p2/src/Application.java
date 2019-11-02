import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter counter = new DuplicateCounter();
        counter.count("problem2.txt");
        counter.write("unique_word_counts.txt");
    }
}
