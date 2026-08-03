package test.dao;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImpl;
import modelo.entities.Cliente;

public class TestCliente {
	
	
	public static ClienteDao cdao;
	
	static {
		cdao = new ClienteDaoImpl();
	}
	
	
	
	public static void main(String[] args) {
		
		todos();
		//insertOne();
		// updateOne();
		//deleteOne();
	}
	
	
	public static void todos() {
		
		for (Cliente cliente : cdao.findAll()) {
			System.out.println(cliente);
		}
		
	}
	
	public static void insertOne() {
		Cliente cliente = new Cliente();
		
		cliente.setCif("B0000034");
		cliente.setNombre("Ana");
		cliente.setApellidos("Cifuentes");
		cliente.setDomicilio("Calle La vieja de Haro");
		cliente.setFacturacionAnual(12000000.3450);
		cliente.setNumeroEmpleados(125);
		
		cdao.insertOne(cliente);
	}
	
	public static void deleteOne() {
		cdao.deleteOne("B0000034");
	}
	
	
	public static void updateOne() {

		String cif = "B0000034";
		Cliente clienteModificar = cdao.findById(cif);
		
		if (clienteModificar != null) {
			
			clienteModificar.setNumeroEmpleados(250);
		}
		
		int resultado = cdao.updateOne(clienteModificar);
		
		if (resultado == 1) {
			
			System.out.println("Modificacion con exito");
		}
	}

}
