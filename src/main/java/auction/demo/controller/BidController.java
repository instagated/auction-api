package auction.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import auction.demo.models.Bid;
import auction.demo.service.BidService;

@RestController
public class BidController {

	@Autowired
	private BidService bidService;
	
	@RequestMapping("/auction/bids")
	public List<Bid> getAllBids(){
		return bidService.getAllBids();
	}
	
	@RequestMapping("/auction/bids/{user_id}")
	public List<Object> getBidsByUser(@PathVariable("user_id") Integer user_id){
		return bidService.getBidsByUser(user_id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="auction/bids/add")
	public void addBid(@RequestBody Map<String,String> requestParams) {
		System.out.println("printing map, size= "+requestParams.size());
		for(Map.Entry<String, String> entry : requestParams.entrySet()) {
			System.out.println("key="+entry.getKey()+", value= "+entry.getValue());
		}
		
		Integer item_id = Integer.parseInt(requestParams.get("item_id"));
		Integer user_id = Integer.parseInt(requestParams.get("user_id"));
		int amount = Integer.parseInt(requestParams.get("amount"));
		
		bidService.addBid(item_id, user_id, amount);
	}
}
