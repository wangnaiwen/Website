package entity;

import java.util.HashSet;
import java.util.Set;

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
	private Set questions = new HashSet(0);
	private Set scs = new HashSet(0);
	private Set answers = new HashSet(0);
	private Set files = new HashSet(0);

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
			Integer type, Set questions, Set scs, Set answers, Set files) {
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
		this.questions = questions;
		this.scs = scs;
		this.answers = answers;
		this.files = files;
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

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	public Set getScs() {
		return this.scs;
	}

	public void setScs(Set scs) {
		this.scs = scs;
	}

	public Set getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set answers) {
		this.answers = answers;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

}