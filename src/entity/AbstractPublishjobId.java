package entity;

/**
 * AbstractPublishjobId entity provides the base persistence definition of the
 * PublishjobId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPublishjobId implements java.io.Serializable {

	// Fields

	private Course course;
	private Integer ano;

	// Constructors

	/** default constructor */
	public AbstractPublishjobId() {
	}

	/** full constructor */
	public AbstractPublishjobId(Course course, Integer ano) {
		this.course = course;
		this.ano = ano;
	}

	// Property accessors

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractPublishjobId))
			return false;
		AbstractPublishjobId castOther = (AbstractPublishjobId) other;

		return ((this.getCourse() == castOther.getCourse()) || (this
				.getCourse() != null && castOther.getCourse() != null && this
				.getCourse().equals(castOther.getCourse())))
				&& ((this.getAno() == castOther.getAno()) || (this.getAno() != null
						&& castOther.getAno() != null && this.getAno().equals(
						castOther.getAno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCourse() == null ? 0 : this.getCourse().hashCode());
		result = 37 * result
				+ (getAno() == null ? 0 : this.getAno().hashCode());
		return result;
	}

}