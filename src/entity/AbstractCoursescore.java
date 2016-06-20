package entity;

/**
 * AbstractCoursescore entity provides the base persistence definition of the
 * Coursescore entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCoursescore implements java.io.Serializable {

	// Fields

	private CoursescoreId id;
	private Integer score;

	// Constructors

	/** default constructor */
	public AbstractCoursescore() {
	}

	/** minimal constructor */
	public AbstractCoursescore(CoursescoreId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractCoursescore(CoursescoreId id, Integer score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public CoursescoreId getId() {
		return this.id;
	}

	public void setId(CoursescoreId id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}