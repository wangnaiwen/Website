package entity;

/**
 * ScId entity. @author MyEclipse Persistence Tools
 */
public class ScId extends AbstractScId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ScId() {
	}

	/** full constructor */
	public ScId(Student student, Course course) {
		super(student, course);
	}

}
