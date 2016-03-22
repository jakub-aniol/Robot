package Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileBuffer {
	public static String OpenLogFile(String path) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				sb.append(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
