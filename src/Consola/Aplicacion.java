package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Modelo.Restaurante;

public class Aplicacion {
	
	private static Restaurante restaurante;
	
	public Aplicacion() {
		Aplicacion.restaurante = new Restaurante();
		
		restaurante.cargarInformacion("data/ingredientes.txt","data/menu.txt","data/combos.txt");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Aplicacion();
		System.out.println("Bienvenido a la Hamburguesería");
		Aplicacion aja = new Aplicacion();

		while (true)
		{
			try {
				System.out.println("Seleccione cual opción desea: ");
				System.out.println("1. Mostrar Menú");
				System.out.println("2. Iniciar nuevo pedido");
				System.out.println("3. Agregar un elemento a un pedido");
				System.out.println("4. Cerrar un pedido y guardar la factura");
				System.out.println("5. Consultar la información de un pedido dado su ID");
				int opcion_seleccionada = Integer.parseInt(input("Seleccione una opción: "));
				ejecutarOpcion(opcion_seleccionada);
				
			} catch (Exception e) {
				
			}
			
		}
				// TODO: handle exception
			
	}
	
	
	public static void mostrarMenu()
	{
		restaurante.getMenuBase();
		
		
	}
	
	public static void  ejecutarOpcion(int opcionSeleccionada)
	{
		if (opcionSeleccionada == 1)
			mostrarMenu();
		
		else if (opcionSeleccionada == 2)
		{
			String nombre = (input("Indique su nombre: "));
			String direccion = (input("Indique su dirección: "));
			restaurante.iniciarPedido(nombre, direccion);
		}
		else if (opcionSeleccionada == 3)
		{
			System.out.println("aja op 3");
		}
		else if (opcionSeleccionada == 4)
		{
			System.out.println("aja op 4");
		}
		else if (opcionSeleccionada == 5 )
		{
			System.out.println("aja op 5");
		}
		
		
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	
	}
}
