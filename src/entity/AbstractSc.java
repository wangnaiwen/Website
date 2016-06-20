package entity;

/**
 * AbstractSc entity provides the base persistence definition of the Sc entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractSc implements java.io.Serializable {

	// Fields

	private ScId id;
	private Integer score;

	// Constructors

	/** default constructor */
	public AbstractSc() {
	}

	/** minimal constructor */
	public AbstractSc(ScId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractSc(ScId id, Integer score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public ScId getId() {
		return this.id;
	}

	public void setId(ScId id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}