package entity;

import java.util.Set;

/**
 * File entity. @author MyEclipse Persistence Tools
 */
public class File extends AbstractFile implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(Publishjob publishjob, String root) {
		super(publishjob, root);
	}

	/** full constructor */
	public File(Teacher teacher, Student student, Publishjob publishjob,
			String root, Set publishjobs, Set submitjobs) {
		super(teacher, student, publishjob, root, publishjobs, submitjobs);
	}

}
