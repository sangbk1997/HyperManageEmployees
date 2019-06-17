package hyperlogy.admin.user.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @NotEmpty
    @Column(name = "username", nullable = true)
    private String username;

    @NotEmpty
    @Column(name = "password", nullable = true)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "firstname", nullable = true)
    private String firstName;

    @Column(name = "lastname", nullable = true)
    private String lastName;

    @Column(name = "fullname", nullable = true)
    private String fullName;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "location", nullable = true)
    private String location;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "birthday", nullable = true)
    private Date birthDay;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "facebook", nullable = true)
    private String facebook;

    @Column(name = "github", nullable = true)
    private String github;

    @Column(name = "skype", nullable = true)
    private String skype;

    @Column(name = "role", nullable = true)
    private String role;

    @Column(name = "isadmin", nullable = true)
    private Boolean isAdmin;

    @Column(name = "status", nullable = true)
    private Boolean status;

    @Column(name = "statuslogin", nullable = true)
    private Boolean statusLogin;

    @Column(name = "lastlogon", nullable = true)
    private Date lastLogon;

    @Column(name = "createdat", nullable = true)
    private Date createdAt;

    @Column(name = "updatedat", nullable = true)
    private Date updatedAt;

    public User() {

    }

    public User(@NotEmpty String username, @NotEmpty String password, Set<Role> roles, String firstName, String lastName, String fullName, String email, String avatar, String location, String phone, Date birthDay, String gender, String facebook, String github, String skype, String role, Boolean isAdmin, Boolean status, Boolean statusLogin, Date lastLogon, Date createdAt, Date updatedAt) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.location = location;
        this.phone = phone;
        this.birthDay = birthDay;
        this.gender = gender;
        this.facebook = facebook;
        this.github = github;
        this.skype = skype;
        this.role = role;
        this.isAdmin = isAdmin;
        this.status = status;
        this.statusLogin = statusLogin;
        this.lastLogon = lastLogon;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public String getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(String birthDay) {
//        this.birthDay = birthDay;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(Boolean statusLogin) {
        this.statusLogin = statusLogin;
    }

    public Date getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(Date lastLogon) {
        this.lastLogon = lastLogon;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

