package main;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ADB {
	public static String AdbPath = "adbtools/adb.exe";

	public static void adbDevices() {
		try {
			ProcessBuilder builder = new ProcessBuilder(AdbPath, "devices");
			builder.redirectErrorStream(true);
			Process p;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while (true) {
				try {
					line = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void installApk() {
		String pathapk = null;

		// pedimos el path del apk
		JFileChooser fileChooser = new JFileChooser("C:");
		fileChooser.showOpenDialog(fileChooser);
		// filtro para que muestre apk
		FileNameExtensionFilter apkFilter = new FileNameExtensionFilter("Android Application Package", "apk");
		fileChooser.setFileFilter(apkFilter);
		try {
			pathapk = fileChooser.getSelectedFile().getAbsolutePath();
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningún fichero");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// hacemos el adb install pathapk
		try {
			ProcessBuilder builder = new ProcessBuilder(AdbPath, "install", pathapk);
			builder.redirectErrorStream(true);
			Process p;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while (true) {
				try {
					line = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Terminado! apk instalado!");
		}
	}

	public static void pushObb() {
		// adb push com.beatgames.beatsaber /sdcard/Android/obb/
		String pathObbdir = null;

		// pedimos el path del apk
		JFileChooser dirChooser = new JFileChooser("C:");
		dirChooser.showOpenDialog(dirChooser);
		dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Component parent = null;
		int returnVal = dirChooser.showSaveDialog(parent);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				// obtener ruta
				pathObbdir = dirChooser.getSelectedFile().getAbsolutePath();
				System.out.print(pathObbdir);

			} catch (NullPointerException e) {
				System.out.println("No se ha seleccionado ningún directorio");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// hacemos el adb install pathapk
		try {
			ProcessBuilder builder = new ProcessBuilder(AdbPath, "push", pathObbdir, "/sdcard/Android/obb/");
			builder.redirectErrorStream(true);
			Process p;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while (true) {
				try {
					line = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Terminado! obb instalado!");
		}

	}

	public static void reboot() {
		try {
			ProcessBuilder builder = new ProcessBuilder(AdbPath, "reboot");
			builder.redirectErrorStream(true);
			Process p;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while (true) {
				try {
					line = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Dispositivo reiniciado!");
		}		
	}

	public static void installedApps() {
		//TODO
		try {
			ProcessBuilder builder = new ProcessBuilder(AdbPath, "shell pm list packages");
			builder.redirectErrorStream(true);
			Process p;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while (true) {
				try {
					line = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}				
	}

}
