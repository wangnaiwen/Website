package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Sc;


import sessionPa.HibernateSessionFactory;
public class CourseCRUD {
	static Configuration config;
	static SessionFactory sessionFactory;

	public boolean doInsert(Course cou) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.persist(cou);
			transaction.commit();
			return true;
			// System.out.println("OK!");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
			// System.out.println("Fail!");
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
	}

	public boolean doDelete(String id) {
		Session session = null;
		Transaction transaction = null;
		Course newdata = null;

		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			newdata = (Course) session.get(Course.class, id);
			// System.out.println(newdata.toString());
			session.delete(newdata);
			transaction.commit();
			return true;
			// System.out.println("OK!");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
			// System.out.println("Fail!");
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
	}

	public Course doSelect(String i) {
		Session session = null;
		Transaction transaction = null;
		Course data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (Course) session.get(Course.class, i);
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return data;
	}

	public boolean doModify(Course cou) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			session.update(cou);
			transaction.commit();
			return true;
//			System.out.println("OK!");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
//			System.out.println("Fail!");
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
	}
	
	public List<Course> doSelectByTid(String id){
		Session session = null;
		Transaction transaction = null;
		List<Course> data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			String sql = "from Course where tid='"+id+"'";
			System.out.println(sql+"!!!!!!!!!!!!!!!!!!!!!!!!!");
			Query q = session.createQuery(sql);
			data = q.list();
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return data;
	}
	

	public List<Course> doSelectAll(){
		Session session = null;
		Transaction transaction = null;
		List<Course> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Course";
			Query q = session.createQuery(sql);
			list = q.list();
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	public List<Course> doSelectBySID(String sid){
		Session session = null;
		Transaction transaction = null;
		List<Course> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select o from Course o where o.id not in(select m.id.course.id from Sc m where m.id.student.id ='"+sid+"')";
			//String sql = "from Course where id not in(select cid from Sc where sid='"+sid+"')";
			Query q = session.createQuery(hql);
			list = q.list();
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}
}
