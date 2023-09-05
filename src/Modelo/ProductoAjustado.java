package Modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.base = base;
	}
	public String getNombre()
	{
		return base.getNombre();
	}
	public int getPrecio()
	{
		int precioBase = base.getPrecio();
		int precioAgregados = 0;
		for(Ingrediente agregado: agregados)
		{
			precioAgregados += agregado.getCostoAdicional();
		}
		return precioBase+precioAgregados;
	}
	public String generarTextoFactura()
	{
		StringBuilder agregadosCadena = new StringBuilder();
		StringBuilder eliminadosCadena = new StringBuilder();
		for(Ingrediente adicional: agregados)
		{
			String adicion = adicional.getNombre();
			agregadosCadena.append(adicion).append(", ");
			
		}
		for(Ingrediente eliminado: eliminados)
		{
			String eliminacion = eliminado.getNombre();
			eliminadosCadena.append(eliminacion).append(", ");
			
		}
		String cadena = "Producto adquirido: "+ getNombre() 
		+"\n"+ "Adiciones: "+agregadosCadena + "\n" + "Eliminaciones: "
		+ eliminadosCadena + "\n" + "Precio: " + getPrecio();
		
		return cadena;
	}
}
