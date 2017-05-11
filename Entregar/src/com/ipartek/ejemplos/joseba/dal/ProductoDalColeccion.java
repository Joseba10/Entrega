package com.ipartek.ejemplos.joseba.dal;

import java.util.Map;
import java.util.TreeMap;

import ProductosTipos.Producto;

//Ejemplo concreto de producto dal utilizando una coleccion
public class ProductoDalColeccion implements ProductoDAL {

	private Map<Integer, Producto> productos = new TreeMap<Integer, Producto>();
	public static int siguienteId = 0;

	@Override
	public void alta(Producto producto) {
		if (productos.containsKey(producto.getId()))
			throw new ProductoYaExisteDALException("Ya existe el producto " + producto.getId());

		productos.put(producto.getId(), producto);
		siguienteId++;

	}

	@Override
	public void modificar(Producto producto) {
		if (!productos.containsKey(producto.getId()))
			throw new DALException("Intento de modificar usuario no existente " + producto);

		productos.put(producto.getId(), producto);

	}

	@Override
	public void borrar(Producto producto) {
		productos.remove(producto.getId());

	}

	@Override
	public Producto buscarPorId(int id) {
		return productos.get(id);
	}

	@Override
	public Producto[] buscarTodosLosProductos() {
		return productos.values().toArray(new Producto[productos.size()]);
	}

	@Override
	public boolean validar(Producto producto) {
		return productos.containsValue(producto);
	}

}
