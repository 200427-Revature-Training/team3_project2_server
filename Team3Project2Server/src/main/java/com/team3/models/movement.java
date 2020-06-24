/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.hibernate.annotations.Check;
import java.time.LocalDate;
import java.util.List;
import com.team3.models.user;
import java.util.Date;

/**
 *
 * @author JJ
 */
@Entity
@Table(name = "movement")
public class movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "mov_goal")
    private int goal;

    @Column(nullable = false, name = "mov_start")
    private Date start;

    @Column(name = "mov_expire")
    private Date expire;

    @Column(name = "mov_desc")
    private String desc;

    @Column(nullable = false, name = "mov_author")
    private int author;

    @Column(name = "mov_approver")
    private int approver;

    @Column(nullable = false, name = "mov_status")
    private int status;

    @Column(nullable = false, name = "mov_type")
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
    
    
    public String getDescription() {
		return desc;
	}

	public void setDescription(String desc) {
		this.desc = desc;
	}

        public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
    
    public int getApprover() {
        return approver;
    }

    public void setApprover(int approver) {
        this.approver = approver;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
        
        
    public movement(int id, int goal, Date start, String desc, int author, int status, int type) {
        super();
        this.id = id;
        this.goal = goal; 
        this.start = start;
        this.desc = desc;
        this.author = author;        
        this.status = status;
        this.type = type;

    }

    public movement() {
        super();
        // TODO Auto-generated constructor stub
    }
}
