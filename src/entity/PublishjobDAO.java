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
 * Publishjob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Publishjob
 * @author MyEclipse Persistence Tools
 */

public class PublishjobDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PublishjobDAO.class);
	// property constants
	public static final String DECRIPTION = "decription";
	public static final String TIME = "time";

	public void save(Publishjob transientInstance) {
		log.debug("saving Publishjob instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publishjob persistentInstance) {
		log.debug("deleting Publishjob instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publishjob findById(entity.PublishjobId id) {
		log.debug("getting Publishjob instance with id: " + id);
		try {
			Publishjob instance = (Publishjob) getSession().get(
					"entity.Publishjob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Publishjob instance) {
		log.debug("finding Publishjob instance by example");
		try {
			List results = getSession().createCriteria("entity.Publishjob")
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
		log.debug("finding Publishjob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Publishjob as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDecription(Object decription) {
		return findByProperty(DECRIPTION, decription);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findAll() {
		log.debug("finding all Publishjob instances");
		try {
			String queryString = "from Publishjob";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publishjob merge(Publishjob detachedInstance) {
		log.debug("merging Publishjob instance");
		try {
			Publishjob result = (Publishjob) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publishjob instance) {
		log.debug("attaching dirty Publishjob instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publishjob instance) {
		log.debug("attaching clean Publishjob instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}