
import java.io.File;

public class organizer {
	
	static String location = "M:\\\\Downloads\\\\";

	
	public static void main(String[] args) {

		File[] files = new File(location).listFiles();
		moveFiles(files);
		createFolder();
	}
	

	public static void createFolder() {
		
		String[] folders = new String[] { "Videos", "Pictures", "Rars", "Installation files" };
		
		for (int i = 0; i < folders.length; i++) {
			File theDir = new File(location + folders[i]);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
				
				System.out.println("creating directory: " + theDir.getName());
				boolean result = false;

				try {
					theDir.mkdir();
					result = true;
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				
				if (result) {
					System.out.println("Folder created");
				}

			}
		}
	}

	public static void moveFiles(File[] files) {
		
		for (File file : files) {
			
			if (file.isDirectory()) {
				moveFiles(file.listFiles());
				
			} else {
				String abs = file.getAbsolutePath();
				
				if (abs.endsWith(".gz") || abs.endsWith(".rar") || abs.endsWith(".zip")) {
					file.renameTo(new File(location + "Rars\\\\" + file.getName()));
					System.out.println("File moved successfuly");
				}

				
				// Checks and moves pictures
				else if (abs.endsWith(".PNG") || abs.endsWith(".JPG") || abs.endsWith(".BMP") || abs.endsWith(".png")
						|| abs.endsWith(".jpg") || abs.endsWith(".jpeg") || abs.endsWith(".JPEG")) {
					
					file.renameTo(new File(location + "Pictures\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
				
				// Checks and moves video files
				else if (abs.endsWith(".FLV") || abs.endsWith(".MOV") || abs.endsWith(".MKV") || abs.endsWith(".MP4")
						|| abs.endsWith(".WMV") || abs.endsWith(".mp4")) {
					
					file.renameTo(new File(location + "Videos\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
				// Checks and moves installation and .exe files
				else if (abs.endsWith(".exe") || abs.endsWith(".EXE")) {
					
					file.renameTo(new File(location + "Installation files\\\\" + file.getName()));
					System.out.println("File moved successfuly");

				}
			}
		}
	}
}