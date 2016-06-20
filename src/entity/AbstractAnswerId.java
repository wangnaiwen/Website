package entity;

/**
 * AbstractAnswerId entity provides the base persistence definition of the
 * AnswerId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAnswerId implements java.io.Serializable {

	// Fields

	private Question question;
	private Integer ano;

	// Constructors

	/** default constructor */
	public AbstractAnswerId() {
	}

	/** full constructor */
	public AbstractAnswerId(Question question, Integer ano) {
		this.question = question;
		this.ano = ano;
	}

	// Property accessors

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
		if (!(other instanceof AbstractAnswerId))
			return false;
		AbstractAnswerId castOther = (AbstractAnswerId) other;

		return ((this.getQuestion() == castOther.getQuestion()) || (this
				.getQuestion() != null && castOther.getQuestion() != null && this
				.getQuestion().equals(castOther.getQuestion())))
				&& ((this.getAno() == castOther.getAno()) || (this.getAno() != null
						&& castOther.getAno() != null && this.getAno().equals(
						castOther.getAno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQuestion() == null ? 0 : this.getQuestion().hashCode());
		result = 37 * result
				+ (getAno() == null ? 0 : this.getAno().hashCode());
		return result;
	}

}