package auction.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auction.demo.models.Item;
import auction.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/auction/items")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@RequestMapping("/auction/items/{id}")
	public Object getItem(@PathVariable("id") Integer id) {
		return itemService.getItem(id);
	}
	
}
