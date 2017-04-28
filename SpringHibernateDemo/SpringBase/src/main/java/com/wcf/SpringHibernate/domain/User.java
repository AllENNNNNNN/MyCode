package com.wcf.SpringHibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//此处用来指定表名
@Table(name="user")
public class User {

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String sex;
	@Column
	private String address;
	@Column
	private int enabled;
	//GeneratedValue覆盖@id的默认访问策略
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
//  @GenericGenerator是在hibernate中定义的，使用hibernate内置的各种主键生成粗略生成主键值
//  @GenericGenerator(name = "hibernate-uuid",strategy = "uuid")
//  @GeneratedValue(generator = "hibernate-uuid")
	private int id;
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
