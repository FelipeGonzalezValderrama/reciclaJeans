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
			System.out.println("Ingrese la ubicaci�n (ruta) del archivo: ");
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
			System.out.println("La opci�n no pude estar vac�a. Intente nuevamente.");
			inicio();
		}
	}

	public void porDefecto() {

		System.out.println("\n============== OPCI�N INV�LIDA ==============\n");

		System.out.println("Opci�n no v�lida. Intente nuevamente.");

	}

	public void desplegarMenu() {

		System.out.println("\n============= MEN� RECICLAJEANS =============\n" + "\n1 Listar Producto\n"
				+ "2 Editar Datos\n" + "3 Importar Datos\n" + "4 Salir\n" + "\nIngrese una opci�n:\n");

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
						System.out.print("8 Salir al men� principal.\n");

						System.out.println("\nIngrese opci�n a editar de los datos del cliente: \n");
						op = Integer.parseInt(sc.nextLine());

						switch (op) {

						case 1:

							System.out.print("\nIngrese el nuevo valor para Art�culo: \n");
							String nuevoArticulo = sc.nextLine();
							productoAux.setArticulo(nuevoArticulo);
							break;

						case 2:

							System.out.print("\nIngrese el nuevo valor para C�digo: \n");
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

							System.out.print("\nIngrese el nuevo valor para Descripci�n: \n");
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
				
				System.out.println("\nNo hay productos que coincidan con el c�digo ingresado.");
			}
					
		}

	}

}

