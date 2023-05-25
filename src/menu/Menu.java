package menu;

import java.util.Scanner;
import modelo.Producto;
import servicio.ArchivoServicio;
import servicio.ProductoServicio;
import servicio.Utilidad;

public class Menu {

	Scanner sc = new Scanner(System.in);
	ProductoServicio productoServicio = new ProductoServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	Utilidad utilidad = new Utilidad();

	public void inicio() {

		desplegarMenu();
		
		try {
			int opcion = Integer.parseInt(sc.nextLine());
		

		switch (opcion) {

		case 1:

			productoServicio.listarProductos();
			break;

		case 2:

			editarProducto();
			break;

		case 3:
			
			System.out.println("\n=============== ABRIR ARCHIVO ===============\n");
			System.out.println("Ingrese la ubicación (ruta) del archivo: ");
			String ruta = sc.nextLine();
			productoServicio.setListaProductos(archivoServicio.cargarDatos(ruta));
			break;

		case 4:

			salir();
			break;

		default:

			porDefecto();
			break;
		}
		
		inicio();
		
		} catch (NumberFormatException e) {
			
			System.out.println("\n==================== ERROR ====================\n");
			System.out.println("La opción no pude estar vacía. Intente nuevamente.");
			inicio();
		}
	}

	public void porDefecto() {

		System.out.println("\n============== OPCIÓN INVÁLIDA ==============\n");

		System.out.println("Opción no válida. Intente nuevamente.");

	}

	public void desplegarMenu() {

		System.out.println("\n============= MENÚ RECICLAJEANS =============\n" + "\n1 Listar Producto\n"
				+ "2 Editar Datos\n" + "3 Importar Datos\n" + "4 Salir\n" + "\nIngrese una opción:\n");

	}

	private void salir() {

		System.out.println("\n=================== SALIR ===================\n");
		System.out.println("Abandonando el sistema productos...");
		utilidad.espera();
		System.out.println("Acaba de salir del sistema\n");
		utilidad.limpiar();
		System.exit(0);

	}

	private void editarProducto() {
		
		System.out.println("\n============== EDITAR PRODUCTO ==============\n");
		
		if (productoServicio.getListaProductos().isEmpty()) {
			
			System.out.println("No existen productos para editar.");
			
		} else {
			
			System.out.println("Ingrese el codigo del producto: \n");
			String codigoProducto = sc.nextLine();

			boolean productoEncontrado = false;
			
			for (Producto productoAux : productoServicio.getListaProductos()) {

				if (codigoProducto.equals(productoAux.getCodigo())) {
					productoEncontrado = true;
					int op;

					do {

						System.out.println(productoAux.toString());
						System.out.print("8 Salir al menú principal.\n");

						System.out.println("\nIngrese opción a editar de los datos del cliente: \n");
						op = Integer.parseInt(sc.nextLine());

						switch (op) {

						case 1:

							System.out.print("\nIngrese el nuevo valor para Artículo: \n");
							String nuevoArticulo = sc.nextLine();
							productoAux.setArticulo(nuevoArticulo);
							break;

						case 2:

							System.out.print("\nIngrese el nuevo valor para Código: \n");
							String nuevoCodigo = sc.nextLine();
							productoAux.setCodigo(nuevoCodigo);
							break;

						case 3:

							System.out.print("\nIngrese el nuevo valor para Marca: \n");
							String nuevaMarca = sc.nextLine();
							productoAux.setMarca(nuevaMarca);
							break;

						case 4:

							System.out.print("\nIngrese el nuevo valor para Color: \n");
							String nuevoColor = sc.nextLine();
							productoAux.setColor(nuevoColor);
							break;

						case 5:

							System.out.print("\nIngrese el nuevo valor para Descripción: \n");
							String nuevaDescripcion = sc.nextLine();
							productoAux.setDescripcion(nuevaDescripcion);
							break;

						case 6:

							System.out.print("\nIngrese el nuevo valor para Precio: \n");
							String nuevoPrecio = sc.nextLine();
							productoAux.setPrecio(nuevoPrecio);
							break;

						case 7:

							System.out.print("\nIngrese el nuevo valor para Talla: \n");
							String nuevaTalla = sc.nextLine();
							productoAux.setTalla(nuevaTalla);
							break;

						case 8:

							inicio();
							break;

						default:

							porDefecto();
							break;

						}

					} while (op != 8);

				} 
					
			} 
			if(!productoEncontrado) {
				
				System.out.println("\nNo hay productos que coincidan con el código ingresado.");
			}
					
		}

	}

}

