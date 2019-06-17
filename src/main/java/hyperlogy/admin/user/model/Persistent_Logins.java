package hyperlogy.admin.user.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persistentLogins")
public class Persistent_Logins implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "username", nullable = false)
    private String username;

    @Id
    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "last_used", nullable = false)
    private Date last_used;

    public Persistent_Logins() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLast_used() {
        return last_used;
    }

    public void setLast_used(Date last_used) {
        this.last_used = last_used;
    }
}
