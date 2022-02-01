package com.assignment.daofab.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import org.springframework.core.io.Resource;

/**
 * Utility class for file handling
 */
public final class FileUtil {

	/**
	 * Private constructor
	 */
	private FileUtil(){}

	/**
	 * Method to check if object is null
	 * @param resource
	 * @return
	 */
	public static List<String> readFileFromResource(Resource resource){
		List<String> content = new LinkedList<>();
		try {
			InputStream in = resource.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

}
