package entity;

/**
 * AbstractSubmitjobId entity provides the base persistence definition of the
 * SubmitjobId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSubmitjobId implements java.io.Serializable {

	// Fields

	private String cid;
	private String sid;
	private Integer ano;

	// Constructors

	/** default constructor */
	public AbstractSubmitjobId() {
	}

	/** full constructor */
	public AbstractSubmitjobId(String cid, String sid, Integer ano) {
		this.cid = cid;
		this.sid = sid;
		this.ano = ano;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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
		if (!(other instanceof AbstractSubmitjobId))
			return false;
		AbstractSubmitjobId castOther = (AbstractSubmitjobId) other;

		return ((this.getCid() == castOther.getCid()) || (this.getCid() != null
				&& castOther.getCid() != null && this.getCid().equals(
				castOther.getCid())))
				&& ((this.getSid() == castOther.getSid()) || (this.getSid() != null
						&& castOther.getSid() != null && this.getSid().equals(
						castOther.getSid())))
				&& ((this.getAno() == castOther.getAno()) || (this.getAno() != null
						&& castOther.getAno() != null && this.getAno().equals(
						castOther.getAno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCid() == null ? 0 : this.getCid().hashCode());
		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getAno() == null ? 0 : this.getAno().hashCode());
		return result;
	}

}