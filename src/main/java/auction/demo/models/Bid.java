package auction.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BIDS", schema="public")
public class Bid {

	@Id()
	@Column(name="bid_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bid_id;
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private int amount;
	
	public Integer getBid_id() {
		return bid_id;
	}
	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
