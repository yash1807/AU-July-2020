package webapp.backend.cart.service;

import java.util.List;

import webapp.backend.cart.model.Item;

public interface CartDao {
	
	public long addNewItem(Item item);
	public List<Item> searchItem(String name);
	public List<Item> getAll();
	public List<Item> getTopTen();
	public boolean deleteItem(int id);
	public int updateItem(Item item); 
}