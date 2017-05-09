package com.ipartek.ejemplos.joseba.dal;

public class DalFactory {

	public static ProductoDAL getProductoDAL() {
		// return new UsuarioDalUsuarioUnico();
		// Crea un nuevo usuario cada vez que se ejecute
		return new ProductoDalColeccion();
	}
}
