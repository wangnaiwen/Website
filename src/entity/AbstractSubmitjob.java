package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSubmitjob entity provides the base persistence definition of the
 * Submitjob entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSubmitjob implements java.io.Serializable {

	// Fields

	private SubmitjobId id;
	private File file;
	private String content;
	private Integer score;
	private String type;
	private Set coursescores = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSubmitjob() {
	}

	/** minimal constructor */
	public AbstractSubmitjob(SubmitjobId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractSubmitjob(SubmitjobId id, File file, String content,
			Integer score, String type, Set coursescores) {
		this.id = id;
		this.file = file;
		this.content = content;
		this.score = score;
		this.type = type;
		this.coursescores = coursescores;
	}

	// Property accessors

	public SubmitjobId getId() {
		return this.id;
	}

	public void setId(SubmitjobId id) {
		this.id = id;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getCoursescores() {
		return this.coursescores;
	}

	public void setCoursescores(Set coursescores) {
		this.coursescores = coursescores;
	}

}