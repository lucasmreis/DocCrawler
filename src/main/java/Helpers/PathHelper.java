package Helpers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class PathHelper {
	public List<Path> getValidPaths(Path path) throws IOException {
		List<Path> paths = new ArrayList<Path>();
		DirectoryStream dir = Files.newDirectoryStream(path);
		for (Object o : dir)
		{
			Path p = (Path)o;
			if (Files.isDirectory(p)) paths.addAll(getValidPaths(p));
			else paths.add(p);
		}
		return paths;
	}
}
