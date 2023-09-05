package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Restaurante {

	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
//	private ArrayList<Combo> combos;
//	private ArrayList<Ingrediente> ingredientes;
//	private ArrayList<Producto> menuBase;
	private Map<String, ProductoMenu> menuH = new HashMap<>();
	private Map<String, Ingrediente> ingredientesH = new HashMap<>();
	private Map<String, Combo> combosH = new HashMap<>();


	
	public Restaurante()
	{
		
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido pedidoEnCurso = new Pedido(nombreCliente,direccionCliente);
		this.pedidoEnCurso = pedidoEnCurso;
	}
	public void cerrarYGuardarPedido()
	{
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso = null;
	}
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
//	public ArrayList<Producto> getMenuBase()
//	{
//		return menuBase;
//	}
//	public ArrayList <Ingrediente> getIngredientes()
//	{
//		return ingredientes;
//	}
	public Map<String,ProductoMenu> getMenuBase()
	{
		return menuH;
	}
	public Map<String,Ingrediente> getIngredientes()
	{
		return ingredientesH;
	}
	public Map<String,Combo> getCombos()
	{
		return combosH;
	}
	public void cargarInformacion(String archivoIngredientes, String archivoMenu, String archivoCombos)
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	public void cargarIngredientes(String archivoIngredientes)
	{
		Map<String, Ingrediente> ingredientesH = getIngredientes();
		System.out.println("\n" + "Cargar un archivo de Ingredientes" + "\n");
		try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoIngredientes));
            String linea = lector.readLine();
            while (linea != null) 
            		{
            	String[] partes = linea.split(";");
            	String nombreIngrediente = partes[0];
            	int costoAdicional = Integer.parseInt(partes[1]);

         //METODO AGREGAR A UN ARRAYLIST LOS INGREDIENTES
//            	Ingrediente ingredienteOBJ = new Ingrediente(nombreIngrediente,costoAdicional);
//                boolean ingredienteExistente = false;
//        		for (Ingrediente ingre : ingredientes)
//            	{
//            		if (ingre.getNombre().equals(ingredienteOBJ.getNombre()))
//            				{
//            			ingredienteExistente = true;
//                        break;
//            				}
//            	}
//        		if (!ingredienteExistente) {
//                    ingredientes.add(ingredienteOBJ);
            	
         // METODO AGREGAR LOS INGREDIENTES AUN HASHMAP
            	Ingrediente ingredienteOBJ = ingredientesH.get(nombreIngrediente); 
        		if (ingredienteOBJ == null)
            	{
            		ingredienteOBJ = new Ingrediente(nombreIngrediente,costoAdicional);
            		ingredientesH.put(nombreIngrediente, ingredienteOBJ);
//            		ingredientes.add(ingredienteOBJ);
            	}
            
    			linea = lector.readLine(); // Leer la siguiente línea

            }

            lector.close();
            System.out.println(ingredientesH);
        } catch (IOException e) {
        	
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
		
	}
	public void cargarCombos(String archivoCombos)
	{
		Map<String, Combo> combosH = getCombos();
		Map<String, ProductoMenu> menuH = getMenuBase();

		
		System.out.println("\n" + "Cargar un archivo de combos" + "\n");
		try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoCombos));
            String linea = lector.readLine();
            while (linea != null) 
            		{
            	String[] partes = linea.split(";");
            	String nombreCombo = partes[0];
            	double descuento = (Double.parseDouble((partes[1].replace(String.valueOf("%"),""))))/100;
            	String nombreSolo = partes[2];
            	String papasYTamaño = partes[3];
            	String bebida = partes[4];
            	//METODO AGREGAR A UN ARRAYLIST LOS combos
//            	Combo comboOBJ = new Combo(nombreCombo,descuento);
//                boolean comboExistente = false;
//        		for (Combo combo_esp : combos)
//            	{
//            		if (combo_esp.getNombre().equals(comboOBJ.getNombre()))
//            				{
//            			comboExistente = true;
//                        break;
//            				}
//            	}
//        		if (!comboExistente) {
//                    combos.add(comboOBJ);
            	
         // METODO AGREGAR LOS combos AUN HASHMAP
            	Combo comboOBJ = combosH.get(nombreCombo); 
            	if (comboOBJ == null)
            	{
            		
            		comboOBJ = new Combo(nombreCombo,descuento);
            		ProductoMenu papasOBJ = menuH.get(papasYTamaño);
            		ProductoMenu bebidaOBJ = menuH.get(bebida);
            		comboOBJ.agregarItemACombo(papasOBJ);
            		comboOBJ.agregarItemACombo(bebidaOBJ);
//            		combos.add(comboOBJ);
            		combosH.put(nombreSolo, comboOBJ);
            	}
            
    			linea = lector.readLine(); // Leer la siguiente línea

            }

            lector.close();
            System.out.println(combosH);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
	}
	public void cargarMenu(String archivoMenu)
	{
		Map<String, ProductoMenu> menuH = getMenuBase();
		System.out.println("\n" + "Cargar un archivo de menú" + "\n");
		try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoMenu));
            String linea = lector.readLine();
            while (linea != null) 
            {
            	String[] partes = linea.split(";");
            	String nombreProducto = partes[0];
            	int precioBase = Integer.parseInt(partes[1]);
            	//METODO AGREGAR A UN ARRAYLIST LOS PRODUCOS DEL MENU
//            	ProductoMenu menuOBJ =  new ProductoMenu(nombreProducto,precioBase);
//                boolean menuExistente = false;
//        		for (ProductoMenu menu_esp : menuBase)
//            	{
//            		if (menu_esp.getNombre().equals(menuOBJ.getNombre()))
//            				{
//            			menuExistente = true;
//                        break;
//            				}
//            	}
//        		if (!menuExistente) {
//                    menuBase.add(menuOBJ);
            	
         // METODO AGREGAR menuBase AUN HASHMAP
            	ProductoMenu productoMenuOBJ = menuH.get(nombreProducto);
            	if (productoMenuOBJ == null)
            	{
            		productoMenuOBJ = new ProductoMenu(nombreProducto,precioBase);
//            		menuBase.add(productoMenuOBJ);
            		menuH.put(nombreProducto, productoMenuOBJ);
            	}
            	linea = lector.readLine(); // Leer la siguiente línea
            }

            lector.close();
            System.out.println(menuH);
	}catch (IOException e) 
		{
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
	}
}

