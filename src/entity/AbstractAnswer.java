package entity;

/**
 * AbstractAnswer entity provides the base persistence definition of the Answer
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAnswer implements java.io.Serializable {

	// Fields

	private AnswerId id;
	private Teacher teacher;
	private Student student;
	private String time;
	private String content;

	// Constructors

	/** default constructor */
	public AbstractAnswer() {
	}

	/** minimal constructor */
	public AbstractAnswer(AnswerId id, String time, String content) {
		this.id = id;
		this.time = time;
		this.content = content;
	}

	/** full constructor */
	public AbstractAnswer(AnswerId id, Teacher teacher, Student student,
			String time, String content) {
		this.id = id;
		this.teacher = teacher;
		this.student = student;
		this.time = time;
		this.content = content;
	}

	// Property accessors

	public AnswerId getId() {
		return this.id;
	}

	public void setId(AnswerId id) {
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}