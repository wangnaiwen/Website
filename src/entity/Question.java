package entity;

import java.util.Set;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */
public class Question extends AbstractQuestion implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(QuestionId id, String title, String description, String time) {
		super(id, title, description, time);
	}

	/** full constructor */
	public Question(QuestionId id, Teacher teacher, Student student,
			String title, String description, String time, Set answers) {
		super(id, teacher, student, title, description, time, answers);
	}

}
