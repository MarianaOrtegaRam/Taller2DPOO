package Modelo;

import java.util.ArrayList;

public class Combo implements Producto {

	
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(String nombre, double descuento)
	{
		this.nombreCombo = nombre;
		this.descuento = descuento;
		
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo)
	{
		itemsCombo.add(itemCombo);
	}
	public int getPrecio()
	{
		int precioProducto =0;
		for (Producto items: itemsCombo)
		{
			precioProducto += items.getPrecio();
		}
		
		return (int) Math.round(precioProducto-(precioProducto*descuento));
	}
	public String generarTextoFactura()
	{
		return "si";
	}
	public String getNombre()
	{
		return nombreCombo;
	}
}

