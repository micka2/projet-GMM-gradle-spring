package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;

@Entity
@Table(name = "Archive")
public class Archive extends EntityBase {

	@ManyToMany
	private List<Subject> subjectReference;
	@ManyToMany
	private List<Homework> homeworkReference;
	@ManyToMany
	private List<Storage> urlReference;

	/**
	 * @return the subjectReference
	 */
	public List<Subject> getSubjectReference() {
		return subjectReference;
	}

	/**
	 * @param subjectReference
	 *            the subjectReference to set
	 */
	public void setSubjectReference(List<Subject> subjectReference) {
		this.subjectReference = subjectReference;
	}

	/**
	 * @return the homeworkReference
	 */
	public List<Homework> getHomeworkReference() {
		return homeworkReference;
	}

	/**
	 * @param homeworkReference
	 *            the homeworkReference to set
	 */
	public void setHomeworkReference(List<Homework> homeworkReference) {
		this.homeworkReference = homeworkReference;
	}

	/**
	 * @return the urlReference
	 */
	public List<Storage> getUrlReference() {
		return urlReference;
	}

	/**
	 * @param urlReference
	 *            the urlReference to set
	 */
	public void setUrlReference(List<Storage> urlReference) {
		this.urlReference = urlReference;
	}

}
