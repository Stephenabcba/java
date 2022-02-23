package com.stephenlee.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	// MEMBER VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "First Name must not be blank")
	@Size(min = 3, message = "First Name must be at least 3 characters long")
	@Pattern(regexp = "[a-zA-Z]+", message = "First Name can only contain letters")
	private String firstName;
    
    @NotNull(message = "Last Name must not be blank")
	@Size(min = 3, message = "Last Name must be at least 3 characters long")
	@Pattern(regexp = "[a-zA-Z]+", message = "Last Name can only contain letters")
    private String lastName;
    

	@NotEmpty(message = "Email must not be blank")
	@Email(message = "Email must be in valid format")
	private String email;

	@NotNull(message = "Password must not be blank")
	@Size(min = 8, message = "Password must be at lease 8 characters long")
	private String password;

	@Transient
	@NotNull(message = "Confirm Password must not be blank")
	@Size(min = 8, message = "Confirm Password must be at lease 8 characters long")
	private String passwordConfirm;
   
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Project> createdProjects;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "participant_project", joinColumns = @JoinColumn(name = "participant_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> participatingProjects;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Task> tasks;

    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // CONSTRUCTOR
    public User() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Project> getCreatedProjects() {
		return createdProjects;
	}

	public void setCreatedProjects(List<Project> createdProjects) {
		this.createdProjects = createdProjects;
	}


	

	public List<Project> getParticipatingProjects() {
		return participatingProjects;
	}

	public void setParticipatingProjects(List<Project> participatingProjects) {
		this.participatingProjects = participatingProjects;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
    
    
}
