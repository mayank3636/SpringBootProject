package com.mindtree.skillspeed.hotelmanagement.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="HotelEntity")
public class HotelEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer Hotel_id;
	String hotel_name;
	Double Hotel_price;
	Integer room_avail;
	
	//
	@ManyToOne
	@JoinColumn(name="CityEntity_id")
	public CityEntity getCityentity() {
		return cityentity;
	}
	public void setCityentity(CityEntity cityentity) {
		this.cityentity = cityentity;
	}
	CityEntity cityentity;	
	public Integer getHotel_id() {
		return Hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		Hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public Double getHotel_price() {
		return Hotel_price;
	}
	public void setHotel_price(Double hotel_price) {
		Hotel_price = hotel_price;
	}
	public Integer getRoom_avail() {
		return room_avail;
	}
	public void setRoom_avail(Integer room_avail) {
		this.room_avail = room_avail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Hotel_id == null) ? 0 : Hotel_id.hashCode());
		result = prime * result + ((Hotel_price == null) ? 0 : Hotel_price.hashCode());
		result = prime * result + ((hotel_name == null) ? 0 : hotel_name.hashCode());
		result = prime * result + ((room_avail == null) ? 0 : room_avail.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelEntity other = (HotelEntity) obj;
		if (Hotel_id == null) {
			if (other.Hotel_id != null)
				return false;
		} else if (!Hotel_id.equals(other.Hotel_id))
			return false;
		if (Hotel_price == null) {
			if (other.Hotel_price != null)
				return false;
		} else if (!Hotel_price.equals(other.Hotel_price))
			return false;
		if (hotel_name == null) {
			if (other.hotel_name != null)
				return false;
		} else if (!hotel_name.equals(other.hotel_name))
			return false;
		if (room_avail == null) {
			if (other.room_avail != null)
				return false;
		} else if (!room_avail.equals(other.room_avail))
			return false;
		return true;
	}
	

}
