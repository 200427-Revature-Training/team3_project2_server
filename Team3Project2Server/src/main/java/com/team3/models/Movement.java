/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.models;

import java.util.Date;
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
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author JJ
 */
@Entity
@Table(name = "movement")
public class Movement {

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

      @Column(nullable = false,name = "mov_name")
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "mov_author")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mov_approver")
    private User approver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movement_status_id")
    private MovementStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movement_type_id")
    private MovementType type;

    @Column(name = "mov_current")
    private int current;

    @Column(name = "mov_image")
    private String image;

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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        
            this.author= author;

       
    }

    public User getApprover() {
        if(approver == null){
            return new User(0);
        }
        else{
                    return approver;            
        }
    }

    public void setApprover(User approver) {
       
            this.approver=approver;

        
    }

    public MovementStatus getStatus() {
        return status;
    }

    public void setStatus(MovementStatus status) {
        this.status= status;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type= type;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getImage() {
        return image;
    }

    public void setType(String image) {
        this.image = image;
    }

    public Movement(int id, int goal, String name, int current, Date start, String desc, Integer author, Integer status, Integer type, String image) {
        super();
        this.id = id;
        this.goal = goal;
        this.current = current;
        if (start == null) {
            this.start = new Date();
        } else {
            this.start = start;
        }
        this.name = name;
        this.desc = desc;
        this.author.setId(author);
        this.status = new MovementStatus(status);
        this.type = new MovementType(type);
        this.image = image;
    }
   

    public Movement() {
        super();
        // TODO Auto-generated constructor stub
    }
}
