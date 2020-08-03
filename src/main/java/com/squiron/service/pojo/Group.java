package com.squiron.service.pojo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "group_scale")
public class Group {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "group_member", 
    joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "member_id", 
    referencedColumnName = "id"))
	private List<Member> members;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id")
	private List<Shift> shifts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
