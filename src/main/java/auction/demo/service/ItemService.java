package auction.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import auction.demo.models.Item;
import auction.demo.models.User;
import auction.demo.repository.ItemRepository;
import auction.demo.repository.UserRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<Item> getAllItems(){
		return (List<Item>) itemRepository.findAll();
	}
	
	public Object getItem(Integer id) {
		Item i = itemRepository.findById(id).orElse(null);
		if(i == null) {
			return "No Such Item in auction";
		}
		else if(i.getUser()!=null) {
			return i.getUser();
		}
		else {
			//will be returning highest bid amount for that particular item
			return itemRepository.getMaxBid(id);
		}
	}
	
	@Scheduled(cron="0 29 12 * * ?")
	public void scheduledTask() {
		List<Item> listOfItems = (List<Item>)itemRepository.findAll();
		for(Item i : listOfItems) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			if(time.equals(i.getEnd_time()) || time.after(i.getEnd_time())) {
				if(i.getUser() == null) {
					Integer item_id = i.getItem_id();
					Integer winner_id = itemRepository.findWinner(item_id);
					User u= userRepository.findById(winner_id).orElse(null);
					
					i.setUser(u);
					itemRepository.save(i);
				}
			}
		}
	}
	
}
