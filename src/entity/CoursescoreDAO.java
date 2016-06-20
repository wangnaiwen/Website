package entity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coursescore entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.Coursescore
 * @author MyEclipse Persistence Tools
 */

public class CoursescoreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoursescoreDAO.class);
	// property constants
	public static final String SCORE = "score";

	public void save(Coursescore transientInstance) {
		log.debug("saving Coursescore instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Coursescore persistentInstance) {
		log.debug("deleting Coursescore instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Coursescore findById(entity.CoursescoreId id) {
		log.debug("getting Coursescore instance with id: " + id);
		try {
			Coursescore instance = (Coursescore) getSession().get(
					"entity.Coursescore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Coursescore instance) {
		log.debug("finding Coursescore instance by example");
		try {
			List results = getSession().createCriteria("entity.Coursescore")
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
		log.debug("finding Coursescore instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Coursescore as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Coursescore instances");
		try {
			String queryString = "from Coursescore";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Coursescore merge(Coursescore detachedInstance) {
		log.debug("merging Coursescore instance");
		try {
			Coursescore result = (Coursescore) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Coursescore instance) {
		log.debug("attaching dirty Coursescore instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Coursescore instance) {
		log.debug("attaching clean Coursescore instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}