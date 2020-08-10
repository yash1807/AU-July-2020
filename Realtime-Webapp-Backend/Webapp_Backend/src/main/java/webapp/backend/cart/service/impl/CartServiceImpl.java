package webapp.backend.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapp.backend.cart.model.Item;
import webapp.backend.cart.service.CartDao;
import webapp.backend.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;

	@Override
	public long addNewItem(Item item) {
		return cartDao.addNewItem(item);
	}
	

	@Override
	public List<Item> searchItem(String name) {
		return cartDao.searchItem(name);
	}

	@Override
	public List<Item> getAll()
	{
		return cartDao.getAll();
	}


	@Override
	public List<Item> getTopTen() {
		return cartDao.getTopTen();
	}


	@Override
	public boolean deleteItem(int id) {
		return cartDao.deleteItem(id);
	}
	
	@Override
	public int updateItem(Item item) {
		return cartDao.updateItem(item);
	}
}