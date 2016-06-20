package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPublishjob entity provides the base persistence definition of the
 * Publishjob entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPublishjob implements java.io.Serializable {

	// Fields

	private PublishjobId id;
	private Teacher teacher;
	private File file;
	private String decription;
	private String time;
	private Set submitjobs = new HashSet(0);
	private Set files = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPublishjob() {
	}

	/** minimal constructor */
	public AbstractPublishjob(PublishjobId id, String time) {
		this.id = id;
		this.time = time;
	}

	/** full constructor */
	public AbstractPublishjob(PublishjobId id, Teacher teacher, File file,
			String decription, String time, Set submitjobs, Set files) {
		this.id = id;
		this.teacher = teacher;
		this.file = file;
		this.decription = decription;
		this.time = time;
		this.submitjobs = submitjobs;
		this.files = files;
	}

	// Property accessors

	public PublishjobId getId() {
		return this.id;
	}

	public void setId(PublishjobId id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set getSubmitjobs() {
		return this.submitjobs;
	}

	public void setSubmitjobs(Set submitjobs) {
		this.submitjobs = submitjobs;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

}