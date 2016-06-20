package entity;

import java.util.Set;

/**
 * Publishjob entity. @author MyEclipse Persistence Tools
 */
public class Publishjob extends AbstractPublishjob implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Publishjob() {
	}

	/** minimal constructor */
	public Publishjob(PublishjobId id, String time) {
		super(id, time);
	}

	/** full constructor */
	public Publishjob(PublishjobId id, Teacher teacher, File file,
			String decription, String time, Set submitjobs, Set files) {
		super(id, teacher, file, decription, time, submitjobs, files);
	}

}
