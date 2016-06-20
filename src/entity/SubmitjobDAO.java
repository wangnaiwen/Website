package entity;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Submitjob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Submitjob
 * @author MyEclipse Persistence Tools
 */

public class SubmitjobDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SubmitjobDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String SCORE = "score";
	public static final String TYPE = "type";

	public void save(Submitjob transientInstance) {
		log.debug("saving Submitjob instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Submitjob persistentInstance) {
		log.debug("deleting Submitjob instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Submitjob findById(entity.SubmitjobId id) {
		log.debug("getting Submitjob instance with id: " + id);
		try {
			Submitjob instance = (Submitjob) getSession().get(
					"entity.Submitjob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Submitjob instance) {
		log.debug("finding Submitjob instance by example");
		try {
			List results = getSession().createCriteria("entity.Submitjob")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Submitjob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Submitjob as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all Submitjob instances");
		try {
			String queryString = "from Submitjob";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Submitjob merge(Submitjob detachedInstance) {
		log.debug("merging Submitjob instance");
		try {
			Submitjob result = (Submitjob) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Submitjob instance) {
		log.debug("attaching dirty Submitjob instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Submitjob instance) {
		log.debug("attaching clean Submitjob instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}