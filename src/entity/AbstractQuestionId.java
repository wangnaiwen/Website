package entity;

/**
 * AbstractQuestionId entity provides the base persistence definition of the
 * QuestionId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractQuestionId implements java.io.Serializable {

	// Fields

	private Course course;
	private Integer qno;

	// Constructors

	/** default constructor */
	public AbstractQuestionId() {
	}

	/** full constructor */
	public AbstractQuestionId(Course course, Integer qno) {
		this.course = course;
		this.qno = qno;
	}

	// Property accessors

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getQno() {
		return this.qno;
	}

	public void setQno(Integer qno) {
		this.qno = qno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractQuestionId))
			return false;
		AbstractQuestionId castOther = (AbstractQuestionId) other;

		return ((this.getCourse() == castOther.getCourse()) || (this
				.getCourse() != null && castOther.getCourse() != null && this
				.getCourse().equals(castOther.getCourse())))
				&& ((this.getQno() == castOther.getQno()) || (this.getQno() != null
						&& castOther.getQno() != null && this.getQno().equals(
						castOther.getQno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCourse() == null ? 0 : this.getCourse().hashCode());
		result = 37 * result
				+ (getQno() == null ? 0 : this.getQno().hashCode());
		return result;
	}

}