package nl.hjj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Day02Part2 {
    public static void main(String[] args) throws IOException {
		Day02Part2 instance = new Day02Part2();
		int result = instance.processInput("input.txt");

		System.out.println("Result of Day 2 part 2 = " + result);
    }

    private InputStream getFileAsIOStream(final String fileName) 
    {
        return this.getClass()
            .getClassLoader()
            .getResourceAsStream(fileName);
    }

    private int processInput(final String fileName) throws IOException 
    {		
		int total = 0;
		InputStream ioStream = getFileAsIOStream(fileName);

        if (ioStream != null) {
			try (InputStreamReader isr = new InputStreamReader(ioStream); 
					BufferedReader br = new BufferedReader(isr);) 
			{
				String line;
				HashMap<String, Integer> rgb =  new HashMap<>();
				rgb.put("red", 0);
				rgb.put("blue", 0);
				rgb.put("green", 0);

				while ((line = br.readLine()) != null) {
					String[] game = line.split(":");
					String[] sets = game[1].split(";");

					rgb.replace("red", 0);
					rgb.replace("blue", 0);
					rgb.replace("green", 0);

					for (String set : sets) {
						String[] cubes = set.split(",");

						for (String cube : cubes) {
							processCube(rgb, cube);
						}
					}

					total = total + (rgb.get("red") * rgb.get("blue") * rgb.get("green"));
				}

				ioStream.close();
			}
		}

		return total;
    }

	private void processCube(HashMap<String, Integer> rgb, String cube) {
		String[] content = cube.trim().split(" ");

		if (Integer.valueOf(content[0]) > rgb.get(content[1])) {
			rgb.replace(content[1], Integer.valueOf(content[0]));
		}
	}
}