package entity;

import java.util.Set;

/**
 * Submitjob entity. @author MyEclipse Persistence Tools
 */
public class Submitjob extends AbstractSubmitjob implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Submitjob() {
	}

	/** minimal constructor */
	public Submitjob(SubmitjobId id) {
		super(id);
	}

	/** full constructor */
	public Submitjob(SubmitjobId id, File file, String content, Integer score,
			String type, Set coursescores) {
		super(id, file, content, score, type, coursescores);
	}

}
