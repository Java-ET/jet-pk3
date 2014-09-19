package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PK3 {

	public static Map<String, ZipEntry> getEntryMap(Path filePath) throws IOException {
		Map<String, ZipEntry> pk3Contents = new HashMap<String, ZipEntry>();
		ZipInputStream instream = new ZipInputStream(new FileInputStream(
				filePath.toString()));
		ZipEntry pk3entry = instream.getNextEntry();

		while (pk3entry != null) {
			if (!pk3entry.isDirectory())
				pk3Contents.put(pk3entry.getName(), pk3entry);

			pk3entry = instream.getNextEntry();
		}

		instream.close();
		return pk3Contents;
	}

}
