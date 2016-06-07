package entity;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private String sid;
	private String name;
	private String sex;
	private String birthday;
	private String department;
	private String major;
	private String phoneNumber;
	private String qq;
	private String wechat;
	private String password;
	private Integer type;

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(String sid, String password, Integer type) {
		this.sid = sid;
		this.password = password;
		this.type = type;
	}

	/** full constructor */
	public AbstractStudent(String sid, String name, String sex,
			String birthday, String department, String major,
			String phoneNumber, String qq, String wechat, String password,
			Integer type) {
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.department = department;
		this.major = major;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
		this.wechat = wechat;
		this.password = password;
		this.type = type;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
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