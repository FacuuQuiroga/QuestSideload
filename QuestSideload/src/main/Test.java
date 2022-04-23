package main;

import javax.swing.JFileChooser;
import java.awt.Component;

public class Test {
	public static void main(String[] args) {
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
	}
}
