package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class LearningResource {
	@Id
	private Integer id;
	private String name;
	private Integer cp;
	private Integer sp;
   
	@Enumerated(EnumType.STRING)
	private LearningResourceStatus lrStat;
	private Date created;
	private Date published;
	private Date retired;
	
	public LearningResource(Integer id, String name, Integer cp, Integer sp, LearningResourceStatus lrStat,
			Date created, Date published, Date retired) {
		super();
		this.id = id;
		this.name = name;
		this.cp = cp;
		this.sp = sp;
		this.lrStat = lrStat;
		this.created = created;
		this.published = published;
		this.retired = retired;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public Integer getSp() {
		return sp;
	}
	public void setSp(Integer sp) {
		this.sp = sp;
	}
	public LearningResourceStatus getLrStat() {
		return lrStat;
	}
	public void setLrStat(LearningResourceStatus lrStat) {
		this.lrStat = lrStat;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public Date getRetired() {
		return retired;
	}
	public void setRetired(Date retired) {
		this.retired = retired;
	}
	
		
}
