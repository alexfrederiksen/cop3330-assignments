import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
	private HashSet<String> uniqueWords;

	public DuplicateRemover() {
		uniqueWords = new HashSet<>();
	}

	public void remove(String filename) throws IOException {
		FileInputStream stream = new FileInputStream(filename);
		Scanner scanner = new Scanner(stream);

		while (scanner.hasNext()) {
			uniqueWords.add(scanner.next());
		}

		stream.close();
	}

	public void write(String filename) throws IOException {
		FileOutputStream stream = new FileOutputStream(filename);
		PrintWriter writer = new PrintWriter(stream);

		for (String word : uniqueWords) {
			writer.println(word);
		}

		writer.close();
		stream.close();

	}
}
