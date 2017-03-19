package com.mindtree.skillspeed.hotelmanagement.entity;
import javax.persistence.*;
@Entity
@Table(name="CityEntity")
public class CityEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer id;
String CityName;
HotelEntity hotelentity;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCityName() {
	return CityName;
}
public void setCityName(String cityName) {
	CityName = cityName;
}
@OneToMany(mappedBy = "CityEntity", cascade = CascadeType.ALL)
public HotelEntity getHotelentity() {
	return hotelentity;
}
public void setHotelentity(HotelEntity hotelentity) {
	this.hotelentity = hotelentity;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CityName == null) ? 0 : CityName.hashCode());
	result = prime * result + ((hotelentity == null) ? 0 : hotelentity.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	CityEntity other = (CityEntity) obj;
	if (CityName == null) {
		if (other.CityName != null)
			return false;
	} else if (!CityName.equals(other.CityName))
		return false;
	if (hotelentity == null) {
		if (other.hotelentity != null)
			return false;
	} else if (!hotelentity.equals(other.hotelentity))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
