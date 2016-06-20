package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractQuestion entity provides the base persistence definition of the
 * Question entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractQuestion implements java.io.Serializable {

	// Fields

	private QuestionId id;
	private Teacher teacher;
	private Student student;
	private String title;
	private String description;
	private String time;
	private Set answers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractQuestion() {
	}

	/** minimal constructor */
	public AbstractQuestion(QuestionId id, String title, String description,
			String time) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.time = time;
	}

	/** full constructor */
	public AbstractQuestion(QuestionId id, Teacher teacher, Student student,
			String title, String description, String time, Set answers) {
		this.id = id;
		this.teacher = teacher;
		this.student = student;
		this.title = title;
		this.description = description;
		this.time = time;
		this.answers = answers;
	}

	// Property accessors

	public QuestionId getId() {
		return this.id;
	}

	public void setId(QuestionId id) {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set answers) {
		this.answers = answers;
	}

}