package entity;

/**
 * AbstractTeacher entity provides the base persistence definition of the
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeacher implements java.io.Serializable {

	// Fields

	private String tid;
	private String name;
	private String birthday;
	private String grade;
	private String phoneNumber;
	private String qq;
	private String wechat;
	private String abstracts;
	private String sex;
	private String password;
	private Integer type;

	// Constructors

	/** default constructor */
	public AbstractTeacher() {
	}

	/** minimal constructor */
	public AbstractTeacher(String tid, String password, Integer type) {
		this.tid = tid;
		this.password = password;
		this.type = type;
	}

	/** full constructor */
	public AbstractTeacher(String tid, String name, String birthday,
			String grade, String phoneNumber, String qq, String wechat,
			String abstracts, String sex, String password, Integer type) {
		this.tid = tid;
		this.name = name;
		this.birthday = birthday;
		this.grade = grade;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
		this.wechat = wechat;
		this.abstracts = abstracts;
		this.sex = sex;
		this.password = password;
		this.type = type;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getAbstracts() {
		return this.abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}