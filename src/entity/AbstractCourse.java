package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	private String id;
	private Teacher teacher;
	private String courseCode;
	private String courseType;
	private String courseName;
	private Integer courseDuration;
	private Integer courseExpDuration;
	private String courseStartDate;
	private String courseEndDate;
	private String teacherName;
	private Set questions = new HashSet(0);
	private Set publishjobs = new HashSet(0);
	private Set scs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(String id, String courseCode, String courseType,
			String courseName, Integer courseDuration,
			Integer courseExpDuration, String courseStartDate,
			String courseEndDate) {
		this.id = id;
		this.courseCode = courseCode;
		this.courseType = courseType;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseExpDuration = courseExpDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
	}

	/** full constructor */
	public AbstractCourse(String id, Teacher teacher, String courseCode,
			String courseType, String courseName, Integer courseDuration,
			Integer courseExpDuration, String courseStartDate,
			String courseEndDate, String teacherName, Set questions,
			Set publishjobs, Set scs) {
		this.id = id;
		this.teacher = teacher;
		this.courseCode = courseCode;
		this.courseType = courseType;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseExpDuration = courseExpDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.teacherName = teacherName;
		this.questions = questions;
		this.publishjobs = publishjobs;
		this.scs = scs;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseDuration() {
		return this.courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Integer getCourseExpDuration() {
		return this.courseExpDuration;
	}

	public void setCourseExpDuration(Integer courseExpDuration) {
		this.courseExpDuration = courseExpDuration;
	}

	public String getCourseStartDate() {
		return this.courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public String getCourseEndDate() {
		return this.courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	public Set getPublishjobs() {
		return this.publishjobs;
	}

	public void setPublishjobs(Set publishjobs) {
		this.publishjobs = publishjobs;
	}

	public Set getScs() {
		return this.scs;
	}

	public void setScs(Set scs) {
		this.scs = scs;
	}

}