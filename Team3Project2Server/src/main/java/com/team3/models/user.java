/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.models;

import java.time.LocalDate;

/**
 *
 * @author JJ
 */


public class user {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
     public user(int id, String username, String password, String firstName, String lastName, String email,int role) {
		super();
		
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
}
