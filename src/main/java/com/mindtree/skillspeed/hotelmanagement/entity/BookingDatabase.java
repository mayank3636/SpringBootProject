package com.mindtree.skillspeed.hotelmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name="BookingHistory")


public class BookingDatabase {
	CityEntity city_name;
	HotelEntity hotel_name;
	Integer no_rooms;
	String Checkin_date;
	String Checkout_date;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@OneToOne	   
	@JoinColumn(name="CityEntity_id")
	public CityEntity getCity_name() {
		return city_name;
	}
	public void setCity_name(CityEntity city_name) {
		this.city_name = city_name;
	}
	@OneToOne	   
	@JoinColumn(name="HotelEntity_Hotel_id")
	public HotelEntity getHotel_name() {
		return hotel_name;
	}
		 
	public void setHotel_name(HotelEntity hotel_name) {
		this.hotel_name = hotel_name;
	}
	public Integer getNo_rooms() {
		return no_rooms;
	}
	public void setNo_rooms(Integer no_rooms) {
		this.no_rooms = no_rooms;
	}
	public String getCheckin_date() {
		return Checkin_date;
	}
	public void setCheckin_date(String checkin_date) {
		Checkin_date = checkin_date;
	}
	public String getCheckout_date() {
		return Checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		Checkout_date = checkout_date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Checkin_date == null) ? 0 : Checkin_date.hashCode());
		result = prime * result + ((Checkout_date == null) ? 0 : Checkout_date.hashCode());
		result = prime * result + ((city_name == null) ? 0 : city_name.hashCode());
		result = prime * result + ((hotel_name == null) ? 0 : hotel_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no_rooms == null) ? 0 : no_rooms.hashCode());
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
		BookingDatabase other = (BookingDatabase) obj;
		if (Checkin_date == null) {
			if (other.Checkin_date != null)
				return false;
		} else if (!Checkin_date.equals(other.Checkin_date))
			return false;
		if (Checkout_date == null) {
			if (other.Checkout_date != null)
				return false;
		} else if (!Checkout_date.equals(other.Checkout_date))
			return false;
		if (city_name == null) {
			if (other.city_name != null)
				return false;
		} else if (!city_name.equals(other.city_name))
			return false;
		if (hotel_name == null) {
			if (other.hotel_name != null)
				return false;
		} else if (!hotel_name.equals(other.hotel_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no_rooms == null) {
			if (other.no_rooms != null)
				return false;
		} else if (!no_rooms.equals(other.no_rooms))
			return false;
		return true;
	}
	
	
	

}
