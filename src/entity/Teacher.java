package entity;

import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
public class Teacher extends AbstractTeacher implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String tid, String password, Integer type) {
		super(tid, password, type);
	}

	/** full constructor */
	public Teacher(String tid, String name, String birthday, String grade,
			String phoneNumber, String qq, String wechat, String abstracts,
			String sex, String password, Integer type, Set publishjobs,
			Set questions, Set answers, Set files, Set courses) {
		super(tid, name, birthday, grade, phoneNumber, qq, wechat, abstracts,
				sex, password, type, publishjobs, questions, answers, files,
				courses);
	}

}
