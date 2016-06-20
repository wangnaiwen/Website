package entity;

import java.util.HashSet;
import java.util.Set;

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
	private Set publishjobs = new HashSet(0);
	private Set questions = new HashSet(0);
	private Set answers = new HashSet(0);
	private Set files = new HashSet(0);
	private Set courses = new HashSet(0);

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
			String abstracts, String sex, String password, Integer type,
			Set publishjobs, Set questions, Set answers, Set files, Set courses) {
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
		this.publishjobs = publishjobs;
		this.questions = questions;
		this.answers = answers;
		this.files = files;
		this.courses = courses;
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

	public Set getPublishjobs() {
		return this.publishjobs;
	}

	public void setPublishjobs(Set publishjobs) {
		this.publishjobs = publishjobs;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
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

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}