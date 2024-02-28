package es.iessoterohernandez.daw.endes.TestShoppingCart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestShoppingCart {
	
	private Product producto;
	private ShoppingCart shoppingcart;

	@BeforeEach
	public void init() {
		producto = new Product("Agua", 0.50);
		shoppingcart = new ShoppingCart();
	}
	
	@Test
	public void TestCrearCarritoVacio() {
		assertEquals(0, shoppingcart.getItemCount());
	}
	
	@Test
	public void TestAsegurarCarritoVacio() {
		assertEquals(0, shoppingcart.getItemCount());
	}
	
	@Test
	public void TestAumentarNumProductos() {
		shoppingcart.addItem(producto);
		assertEquals(1, shoppingcart.getItemCount());
	}
	
	@Test
	public void TestAumentarBalanceCorrectamente() {
		shoppingcart.addItem(producto);
		shoppingcart.getBalance();
		Product producto2 = new Product("Coca-Cola", 1.00);
		shoppingcart.addItem(producto2);
		assertEquals(1.50, shoppingcart.getBalance());
	}
	
	@Test
	public void TestEliminarProducto() throws ProductNotFoundException {
		shoppingcart.removeItem(producto);
		assertEquals(0, shoppingcart.getItemCount());
	}
	
	@Test
	public void TestEliminarProductoNoEncontrado() {
		try {
			shoppingcart.removeItem(producto);
			fail("No se ha ejecutado la excepción");
		} catch (ProductNotFoundException e) {
			System.out.println(e);
		}
	}

}
