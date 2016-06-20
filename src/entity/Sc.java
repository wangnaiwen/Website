package entity;

/**
 * Sc entity. @author MyEclipse Persistence Tools
 */
public class Sc extends AbstractSc implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sc() {
	}

	/** minimal constructor */
	public Sc(ScId id) {
		super(id);
	}

	/** full constructor */
	public Sc(ScId id, Integer score) {
		super(id, score);
	}

}
