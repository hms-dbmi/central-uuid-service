package edu.harvard.childrens.rc.uuid.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UUIDMapping {
	
	@Id
	private UUID uuid;

	private String source_id;
	private String source;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
