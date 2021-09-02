
package com.userController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class User {
    
    private int id;
    @Column(name = "username")
    private String username;
    @Column
    private String password;

    @Column
    protected LocalDateTime createTime ;

    @Column
    private LocalDateTime updateTime;

    @PrePersist
    public void prePersist() {
        createTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
       updateTime = LocalDateTime.now();
    }
    
    public User(){
        
    }

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="username")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "create_time")
    public LocalDateTime getcreateTime() {
        return this.createTime;
    }

    public void setcreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }


    //------------------------------------------------------------

    @Override
    public String toString() {
        return "{" +
            "ID='" + getId() + "'" +
            " name='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
