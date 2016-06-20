package entity;

/**
 * AnswerId entity. @author MyEclipse Persistence Tools
 */
public class AnswerId extends AbstractAnswerId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AnswerId() {
	}

	/** full constructor */
	public AnswerId(Question question, Integer ano) {
		super(question, ano);
	}

}
