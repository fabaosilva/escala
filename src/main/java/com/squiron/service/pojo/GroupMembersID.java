package com.squiron.service.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupMembersID implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="group_id")
	private Long group_id;
	
	@Column(name="member_id")
	private Long Member_id;

	public GroupMembersID(Long group_id, Long member_id) {
		super();
		this.group_id = group_id;
		Member_id = member_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Member_id == null) ? 0 : Member_id.hashCode());
		result = prime * result + ((group_id == null) ? 0 : group_id.hashCode());
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
		GroupMembersID other = (GroupMembersID) obj;
		if (Member_id == null) {
			if (other.Member_id != null)
				return false;
		} else if (!Member_id.equals(other.Member_id))
			return false;
		if (group_id == null) {
			if (other.group_id != null)
				return false;
		} else if (!group_id.equals(other.group_id))
			return false;
		return true;
	}
	
	
}
