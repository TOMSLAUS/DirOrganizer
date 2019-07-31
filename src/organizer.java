
import java.io.File;

public class organizer {

	public static void main(String[] args) {

		File[] files = new File("D:\\Downloads").listFiles();
		moveFiles(files);
		createFolder();

	}

	public static void createFolder() {
		String[] folders = new String[] { "Videos", "Pictures", "Rars", "Installation files" };
		for (int i = 0; i < folders.length; i++) {
			File theDir = new File("D:\\\\Downloads\\" + folders[i]);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
				System.out.println("creating directory: " + theDir.getName());
				boolean result = false;

				try {
					theDir.mkdir();
					result = true;
				} catch (SecurityException e) {
					// handle it
				}
				if (result) {
					System.out.println("Folder created");
				}

			}
		}
	}

	public static void moveFiles(File[] files) {
		String[]video=new String[] {".FLV",".MOV",".MKV",".MP4",".WMV",".mp4"};
		for (File file : files) {
			if (file.isDirectory()) {
				// System.out.println("Directory: " + file.getName());
				moveFiles(file.listFiles()); // Calls same method again.
			} else {
				// System.out.println("File: " + file.getName());

				// Checks and moves rars
				String abs = file.getAbsolutePath();
				if (abs.endsWith(".gz") || abs.endsWith(".rar") || abs.endsWith(".zip")) {
					file.renameTo(new File("D:\\\\\\\\Downloads\\\\Rars\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}

				
				// Checks and moves pictures
				else if (abs.endsWith(".PNG") || abs.endsWith(".JPG") || abs.endsWith(".BMP") || abs.endsWith(".png")
						|| abs.endsWith(".jpg") || abs.endsWith(".jpeg") || abs.endsWith(".JPEG")) {
					file.renameTo(new File("D:\\\\\\\\Downloads\\\\Pictures\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
				
				// Checks and moves video files
				else if (abs.endsWith(".FLV") || abs.endsWith(".MOV") || abs.endsWith(".MKV") || abs.endsWith(".MP4")
						|| abs.endsWith(".WMV") || abs.endsWith(".mp4")) {
					file.renameTo(new File("D:\\\\\\\\Downloads\\\\Videos\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
				// Checks and moves installation and .exe files
				else if (abs.endsWith(".exe") || abs.endsWith(".EXE")) {
					file.renameTo(new File("D:\\\\\\\\Downloads\\\\Installation files\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
			}
		}
	}
}