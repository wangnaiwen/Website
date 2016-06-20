package entity;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */
public class Answer extends AbstractAnswer implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** minimal constructor */
	public Answer(AnswerId id, String time, String content) {
		super(id, time, content);
	}

	/** full constructor */
	public Answer(AnswerId id, Teacher teacher, Student student, String time,
			String content) {
		super(id, teacher, student, time, content);
	}

}
