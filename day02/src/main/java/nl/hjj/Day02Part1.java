package nl.hjj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Day02Part1 {
    public static void main(String[] args) throws IOException {
		Day02Part1 instance = new Day02Part1();
		int result = instance.processInput("input.txt");

		System.out.println("Result of Day 2 part 1 = " + result);
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

				while ((line = br.readLine()) != null) {
					String[] game = line.split(":");
					String[] sets = game[1].split(";");

					boolean correctSets = true;

					for (String set : sets) {
						String[] cubes = set.split(",");

						for (String cube : cubes) {
							correctSets = correctSets && isNumberOfCubesPossible(cube);
						}
					}

					if (correctSets) {
						String[] str = game[0].split(" ");
						total = total + Integer.valueOf(str[1]);
					}
				}

				ioStream.close();
			}
		}

		return total;
    }

	private boolean isNumberOfCubesPossible(String cube) {
		boolean possible = true;

		String[] content = cube.trim().split(" ");

		switch (content[1]) {
			case "red":
				possible = Integer.valueOf(content[0]) <= 12;
				break;
			case "green":
				possible = Integer.valueOf(content[0]) <= 13;
				break;
			case "blue":
				possible = Integer.valueOf(content[0]) <= 14;
				break;
			default:
				break;
		}

		return possible;
	}
}