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
 * Course entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Course
 * @author MyEclipse Persistence Tools
 */

public class CourseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CourseDAO.class);
	// property constants
	public static final String COURSE_CODE = "courseCode";
	public static final String COURSE_TYPE = "courseType";
	public static final String COURSE_NAME = "courseName";
	public static final String COURSE_DURATION = "courseDuration";
	public static final String COURSE_EXP_DURATION = "courseExpDuration";
	public static final String COURSE_START_DATE = "courseStartDate";
	public static final String COURSE_END_DATE = "courseEndDate";
	public static final String TEACHER_NAME = "teacherName";

	public void save(Course transientInstance) {
		log.debug("saving Course instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Course persistentInstance) {
		log.debug("deleting Course instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Course findById(java.lang.String id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) getSession().get("entity.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Course instance) {
		log.debug("finding Course instance by example");
		try {
			List results = getSession().createCriteria("entity.Course")
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
		log.debug("finding Course instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Course as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCourseCode(Object courseCode) {
		return findByProperty(COURSE_CODE, courseCode);
	}

	public List findByCourseType(Object courseType) {
		return findByProperty(COURSE_TYPE, courseType);
	}

	public List findByCourseName(Object courseName) {
		return findByProperty(COURSE_NAME, courseName);
	}

	public List findByCourseDuration(Object courseDuration) {
		return findByProperty(COURSE_DURATION, courseDuration);
	}

	public List findByCourseExpDuration(Object courseExpDuration) {
		return findByProperty(COURSE_EXP_DURATION, courseExpDuration);
	}

	public List findByCourseStartDate(Object courseStartDate) {
		return findByProperty(COURSE_START_DATE, courseStartDate);
	}

	public List findByCourseEndDate(Object courseEndDate) {
		return findByProperty(COURSE_END_DATE, courseEndDate);
	}

	public List findByTeacherName(Object teacherName) {
		return findByProperty(TEACHER_NAME, teacherName);
	}

	public List findAll() {
		log.debug("finding all Course instances");
		try {
			String queryString = "from Course";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Course merge(Course detachedInstance) {
		log.debug("merging Course instance");
		try {
			Course result = (Course) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Course instance) {
		log.debug("attaching dirty Course instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Course instance) {
		log.debug("attaching clean Course instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}