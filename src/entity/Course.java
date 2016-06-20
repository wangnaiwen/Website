package entity;

import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String id, String courseCode, String courseType,
			String courseName, Integer courseDuration,
			Integer courseExpDuration, String courseStartDate,
			String courseEndDate) {
		super(id, courseCode, courseType, courseName, courseDuration,
				courseExpDuration, courseStartDate, courseEndDate);
	}

	/** full constructor */
	public Course(String id, Teacher teacher, String courseCode,
			String courseType, String courseName, Integer courseDuration,
			Integer courseExpDuration, String courseStartDate,
			String courseEndDate, String teacherName, Set questions,
			Set publishjobs, Set scs) {
		super(id, teacher, courseCode, courseType, courseName, courseDuration,
				courseExpDuration, courseStartDate, courseEndDate, teacherName,
				questions, publishjobs, scs);
	}

}
