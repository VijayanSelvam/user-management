package com.stormcloud.dreamfyre.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class DreamfyreUserPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID dfid;

	public DreamfyreUserPrimaryKey() {
		super();
	}

	public DreamfyreUserPrimaryKey(UUID dfid) {
		super();
		this.dfid = dfid;
	}

	public UUID getDfid() {
		return dfid;
	}

	public void setDfid(UUID dfid) {
		this.dfid = dfid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dfid == null) ? 0 : dfid.hashCode());
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
		DreamfyreUserPrimaryKey other = (DreamfyreUserPrimaryKey) obj;
		if (dfid == null) {
			if (other.dfid != null)
				return false;
		} else if (!dfid.equals(other.dfid))
			return false;
		return true;
	}

}
