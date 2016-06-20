package entity;

/**
 * PublishjobId entity. @author MyEclipse Persistence Tools
 */
public class PublishjobId extends AbstractPublishjobId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public PublishjobId() {
	}

	/** full constructor */
	public PublishjobId(Course course, Integer ano) {
		super(course, ano);
	}

}
