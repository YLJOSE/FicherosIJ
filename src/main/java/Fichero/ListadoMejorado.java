package Fichero;

import java.io.File;

public class ListadoMejorado {
    public static void main(String[] args) {
        String rutaDirectorio = "c:/dir1";
        File directorio = new File(rutaDirectorio);
		/*File archivos[] = directorio.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".txt");
			}

		}

		);*/
        File[] archivos = directorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        for (File file : archivos) {
            System.out.println(file.getAbsoluteFile());
        }

    }
}
