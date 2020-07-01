package com.team3.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "movement_type")
public class MovementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "movement_type_id")
		private List<Movement> movement;
	
	@Column(nullable = false, name = "movement_type")
	private String movementType;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMovementType() {
		return movementType;
	}
	
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((movementType == null) ? 0 : movementType.hashCode());
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
		MovementType other = (MovementType) obj;
		if (id != other.id)
			return false;
		if (movementType == null) {
			if (other.movementType != null)
				return false;
		} else if (!movementType.equals(other.movementType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MovementType [id=" + id + ", movementType=" + movementType + "]";
	}
	
	public MovementType(int id, String movementType) {
		super();
		this.id = id;
		this.movementType = movementType;
	}
	
	public MovementType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
