
package Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Robot.FindPattern;

public class FileReaderToSwing {
	public static String OpenLogFile(String path, String bookstoreName) {
		// File file = new File(path);

		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;

			try {
				while ((sCurrentLine = br.readLine()) != null) {

					if (new FindPattern().FP(sCurrentLine, bookstoreName)) {
						sb.append(sCurrentLine + "\n");

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sb.toString();
	}
}
