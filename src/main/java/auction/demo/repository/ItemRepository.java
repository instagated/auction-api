package auction.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import auction.demo.models.Item;
import auction.demo.models.User;

public interface ItemRepository extends CrudRepository<Item,Integer>{

	@Query(value="select max(b.amount) from bids as b where b.item_id=?1", nativeQuery=true )
	public Integer getMaxBid(Integer item_id);
	
	@Query(value="select b.user_id from bids as b where b.item_id=?1 AND b.amount = (select max(amount) from bids);", nativeQuery=true)
	public Integer findWinner(Integer id);
	
}
