package entity;

import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sid, String password, Integer type) {
		super(sid, password, type);
	}

	/** full constructor */
	public Student(String sid, String name, String sex, String birthday,
			String department, String major, String phoneNumber, String qq,
			String wechat, String password, Integer type, Set questions,
			Set scs, Set answers, Set files) {
		super(sid, name, sex, birthday, department, major, phoneNumber, qq,
				wechat, password, type, questions, scs, answers, files);
	}

}
