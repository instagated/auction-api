package auction.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import auction.demo.models.Bid;

public interface BidRepository extends CrudRepository<Bid, Integer> {

//	@Query(value="select max(b.amount) from bids as b where b.item_id=?1", nativeQuery=true )
//	public Integer getMaxBid(Integer item_id);
	@Query(value="select i.item_name, b.amount from bids as b, auction_items as i where b.user_id=?1 AND b.item_id=i.item_id", nativeQuery = true)
	public List<Object> getBidsByAuthenticatedUser(Integer user_id);
}
