package entity;

/**
 * Coursescore entity. @author MyEclipse Persistence Tools
 */
public class Coursescore extends AbstractCoursescore implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Coursescore() {
	}

	/** minimal constructor */
	public Coursescore(CoursescoreId id) {
		super(id);
	}

	/** full constructor */
	public Coursescore(CoursescoreId id, Integer score) {
		super(id, score);
	}

}
