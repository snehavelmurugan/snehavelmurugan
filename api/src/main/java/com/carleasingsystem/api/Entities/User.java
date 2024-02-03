package com.carleasingsystem.api.Entities;

import java.io.Serializable;

import com.carleasingsystem.api.Config.ConfigConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = ConfigConstants.USER_TABLE)
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "license_number", nullable = false)
    private String license_number;
    
    @Column(name = "password", nullable = false)
	private String password;

    @Column(name = "token")
    private String token;

	public User()
	{	}

    public User(long id, String username, String name, @Email String email, String license_number, String password)
    {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.license_number = license_number;
        this.password = password;
        this.token = null;
    }
    
    public void copy(User other)
    {
    	this.username = other.username;
    	this.name = other.name;
    	this.email = other.email;
    	this.license_number = other.license_number;
    	this.password = other.password;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((license_number == null) ? 0 : license_number.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (license_number == null) {
            if (other.license_number != null)
                return false;
        } else if (!license_number.equals(other.license_number))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

    @Override
    public String toString() 
    {
        return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", license_number="
                + license_number + ", password=" + password + ", token=" + token + "]";
    }
}