package test.entities;

import modelo.entities.Empleado;

public class TestEntity {

	public static void main(String[] args) {
		
		
		Empleado empl1 = new Empleado();
		
		empl1.setNombre("Maria");
		empl1.setGenero("m");

		System.out.println(empl1.literalGenero());
		System.out.println(empl1.nombreCompleto());
		System.out.println(empl1.salarioMensual(12));
	}

}
