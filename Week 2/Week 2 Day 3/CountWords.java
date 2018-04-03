package tr.com.jss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWords {
	public static final String FILE_DIRECTORY = "C:\\Users\\baki.unlu\\Desktop\\input.txt";
	private static final String[] strArray = { "Exit", "E", "exit", "e", "EXIT" };
	private static Map<String, Integer> wordCountMap = new TreeMap<>();

	public static void printWordsWithCountInformation() {
		for (String key : wordCountMap.keySet()) {
			System.out.println(key + ": " + wordCountMap.get(key));
		}
	}

	private static void readFromScanner(final List<String> exitWordList) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String line = scanner.nextLine();

			if (exitWordList.contains(line))
				break;

			// English Word Splitting
			for (String str : line.split("\\W")) {
				if ("".equals(str))
					continue;

				if (wordCountMap.containsKey(str)) {
					wordCountMap.put(str, wordCountMap.get(str) + 1);
				} else {
					wordCountMap.put(str, 1);
				}
			}
		}

		wordCountMap.clear();
		scanner.close();
	}

	private static void readFromFile(final List<String> exitWordList) {
		FileReader fr = null;
		BufferedReader reader = null;
		//try (FileReader fr = new FileReader(FILE_DIRECTORY);
		//		BufferedReader reader = new BufferedReader(fr)){
		try {
			fr = new FileReader(FILE_DIRECTORY);
			reader = new BufferedReader(fr);

			
			while (true) {
				String line = reader.readLine();

				if (line != null && !line.isEmpty()
						&& exitWordList.contains(line))
					break;

				// English Word Splitting
				for (String str : line.split("\\W")) {
					if ("".equals(str))
						continue;

					if (wordCountMap.containsKey(str)) {
						wordCountMap.put(str, wordCountMap.get(str) + 1);
					} else {
						wordCountMap.put(str, 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out
							.println("Scanner object referenced by read cannot be closed");
					e.printStackTrace();
				}
			}
			printWordsWithCountInformation();
			wordCountMap.clear();
		}
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList(strArray);

		System.out.println("Read From Scanner begins...");
		readFromScanner(list);
		printWordsWithCountInformation();

		System.out.println("Read From File begins...");
		readFromFile(list);
	}

}
