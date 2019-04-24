package auction.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auction.demo.models.Bid;
import auction.demo.models.Item;
import auction.demo.models.User;
import auction.demo.repository.BidRepository;
import auction.demo.repository.ItemRepository;
import auction.demo.repository.UserRepository;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Bid> getAllBids(){
		return (List<Bid>) bidRepository.findAll();
	}
	
	public List<Object> getBidsByUser(Integer user_id){
		return bidRepository.getBidsByAuthenticatedUser(user_id);
	}

	public void addBid(Integer item_id, Integer user_id, int amount) {
		Bid bid = new Bid();
		Item item = itemRepository.findById(item_id).orElse(null);
		User user = userRepository.findById(user_id).orElse(null);
		bid.setItem(item);
		bid.setUser(user);
		bid.setAmount(amount);
		bidRepository.save(bid);
	}
}
