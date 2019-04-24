package auction.demo.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUCTION_ITEMS")
public class Item {

	@Id
	private Integer item_id;
	private String item_name;
	private String item_description;
	private Timestamp start_time;
	private Timestamp end_time;
	private int starting_amount;
	@ManyToOne
	@JoinColumn(name="winner")
	private User user;
	private String imageURL;
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public int getStarting_amount() {
		return starting_amount;
	}
	public void setStarting_amount(int starting_amount) {
		this.starting_amount = starting_amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
