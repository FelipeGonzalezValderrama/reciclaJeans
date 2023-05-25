package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Producto;

public class ArchivoServicio {

	
	

	public ArrayList<Producto> cargarDatos(String ruta) {
		
		ArrayList<Producto> productos = new ArrayList<>();

		
		File archivoImportado = new File(ruta+"ProductosImportados.csv");

		if (archivoImportado.exists()) {

			try {
				FileReader fr = new FileReader(archivoImportado);
				BufferedReader br = new BufferedReader(fr);
				String nuevaLinea = br.readLine();

				while (nuevaLinea != null) {

					String[] productoActual = nuevaLinea.split(",");

					//public Producto(String articulo, String precio, String descripcion, String codigo, String talla, String marca,
					//		String color)
					
					Producto productoAux = new Producto(productoActual[0], productoActual[1], productoActual[2],
							productoActual[3], productoActual[4], productoActual[5], productoActual[6]);

					productos.add(productoAux);
					nuevaLinea = br.readLine();

				}
				
				
				br.close();
				System.out.println("El archivo ha sido importado correctamente.");

			} catch (FileNotFoundException e) {

				System.out.println("Archivo no encontrado.");
				e.printStackTrace();

			} catch (IOException e) {
				System.out.println("Error al leer el archivo.");
				e.printStackTrace();
			}

		} else {

			System.out.println("El archivo no existe, o se encuentra en otra ubicación.\n");

		}
		return productos;

	}

}
