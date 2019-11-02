import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	private HashMap<String, Integer> wordCounter;

	public DuplicateCounter() {
		wordCounter = new HashMap<>();
	}

	public void count(String dataFile) throws IOException {
		FileInputStream stream = new FileInputStream(dataFile);
		Scanner scanner = new Scanner(stream);

		while (scanner.hasNext()) {
			// increment word count (take advantage of compute())
		    wordCounter.compute(scanner.next(), (s, c) -> c == null ? 1 : c + 1);
		}

		scanner.close();
		stream.close();
	}

	public void write(String outputFile) throws IOException {
		FileOutputStream stream = new FileOutputStream(outputFile);
		PrintWriter writer = new PrintWriter(stream);

		for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
		    writer.printf("%s %d\n", entry.getKey(), entry.getValue());
		}

		writer.close();
		stream.close();
	}
}
