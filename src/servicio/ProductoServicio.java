package servicio;

import java.util.ArrayList;

import modelo.Producto;

public class ProductoServicio {

	ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public ProductoServicio() {
	}

	public ProductoServicio(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void listarProductos() {

		System.out.println("\n============== LISTAR PRODUCTOS =============\n");

		if (listaProductos.isEmpty()) {

			System.out.println("No existen elementos en la lista.");

		} else {

			for (Producto producto : listaProductos) {
				
				System.out.println(producto.toString());

			}

		}
	}
}
