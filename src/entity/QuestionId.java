package entity;

/**
 * QuestionId entity. @author MyEclipse Persistence Tools
 */
public class QuestionId extends AbstractQuestionId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public QuestionId() {
	}

	/** full constructor */
	public QuestionId(Course course, Integer qno) {
		super(course, qno);
	}

}
