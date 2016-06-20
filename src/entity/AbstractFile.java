package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractFile entity provides the base persistence definition of the File
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFile implements java.io.Serializable {

	// Fields

	private Long id;
	private Teacher teacher;
	private Student student;
	private Publishjob publishjob;
	private String root;
	private Set publishjobs = new HashSet(0);
	private Set submitjobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractFile() {
	}

	/** minimal constructor */
	public AbstractFile(Publishjob publishjob, String root) {
		this.publishjob = publishjob;
		this.root = root;
	}

	/** full constructor */
	public AbstractFile(Teacher teacher, Student student,
			Publishjob publishjob, String root, Set publishjobs, Set submitjobs) {
		this.teacher = teacher;
		this.student = student;
		this.publishjob = publishjob;
		this.root = root;
		this.publishjobs = publishjobs;
		this.submitjobs = submitjobs;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Publishjob getPublishjob() {
		return this.publishjob;
	}

	public void setPublishjob(Publishjob publishjob) {
		this.publishjob = publishjob;
	}

	public String getRoot() {
		return this.root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Set getPublishjobs() {
		return this.publishjobs;
	}

	public void setPublishjobs(Set publishjobs) {
		this.publishjobs = publishjobs;
	}

	public Set getSubmitjobs() {
		return this.submitjobs;
	}

	public void setSubmitjobs(Set submitjobs) {
		this.submitjobs = submitjobs;
	}

}