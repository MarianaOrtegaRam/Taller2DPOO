package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsProducto;

	public Pedido(String nombreCliente, String direccionCliente)
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		Random rand = new Random();
        this.idPedido = rand.nextInt(101);
        numeroPedidos+=1;
	}

	public int getIdPedido()
	{
		return idPedido;
	}
	public void agregarProduco(Producto nuevoItem)
	{
		itemsProducto.add(nuevoItem);
	}
	private int getPrecioNetoPedido()
	{
		int precio = 0;
		for (Producto item: itemsProducto)
		{
			int precioUnico = item.getPrecio();
			precio += precioUnico;
		}
			
		return precio;
	}
	private int getPrecioTotalPedido()
	{
		int precioNeto = getPrecioNetoPedido();
		int iva = getPrecioIvaPedido();
		return precioNeto+iva;
	}
	private int getPrecioIvaPedido() 
	{
		int precioNeto = getPrecioNetoPedido();
		return (int) Math.round(precioNeto*0.19);
	}
	private String generarTextoFactura()
	{
		StringBuilder productosCadena = new StringBuilder();
		for(Producto item: itemsProducto)
		{
			String nombreProducto = item.getNombre();
			int precio = item.getPrecio();
			productosCadena.append(nombreProducto).append(", ").append(precio).append(", ");
			
		}
		String cadena = "Nombre pedido: "+ nombreCliente 
		+"\n"+ "Direccion del Cliente: "+ direccionCliente + "\n" + "identificadfor unico del Pedido: "
		+ idPedido + "\n" + "Producto, precio: " + productosCadena+ "\n" + "Precio Neto : " + getPrecioNetoPedido()
		+  "\n" + "Precio Iva" + getPrecioIvaPedido()+ "\n" + "Precio Total" + getPrecioTotalPedido();
		return cadena;
	}
	public void guardarFactura(String archivo)
	{
		
	}
}

