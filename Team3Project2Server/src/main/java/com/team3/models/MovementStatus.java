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

/**
 * 
 * @author nmpos
 */

@Entity
@Table(name= "movement_status")
public class MovementStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "movement_status_id")
		private List<Movement> movement;
	
	@Column(nullable = false, name="movement_status")
	private String movementStatus;
	
	/**
	 * 	Getters and Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovementStatus() {
		return movementStatus;
	}

	public void setMovementStatus(String movementStatus) {
		this.movementStatus = movementStatus;
	}

	/**
	 *  Generate hashCode() and equals()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((movementStatus == null) ? 0 : movementStatus.hashCode());
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
		MovementStatus other = (MovementStatus) obj;
		if (id != other.id)
			return false;
		if (movementStatus == null) {
			if (other.movementStatus != null)
				return false;
		} else if (!movementStatus.equals(other.movementStatus))
			return false;
		return true;
	}
	/**
	 *  Generated toString()
	 */
	@Override
	public String toString() {
		return "MovementStatus [id=" + id + ", movementStatus=" + movementStatus + "]";
	}

	public MovementStatus(int id, String movementStatus) {
		super();
		this.id = id;
		this.movementStatus = movementStatus;
	}
        public MovementStatus(int id) {
		super();
		this.id = id;
		
	}

	/**
	 * Generated super
	 */
	public MovementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}



