package dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

import sessionPa.HibernateSessionFactory;

public class TeaCRUD {

	static Configuration config;
	static SessionFactory sessionFactory;

	public boolean doInsert(Teacher teacher) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.persist(teacher);
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
		Teacher newdata = null;

		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			newdata = (Teacher) session.get(Teacher.class, id);
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

	public Teacher doSelect(String i) {
		Session session = null;
		Transaction transaction = null;
		Teacher data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (Teacher) session.get(Teacher.class, i);
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

	public boolean doModify(Teacher teacher) {
		Session session = null;
		Transaction transaction = null;
		Teacher t = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(teacher);
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
	public List<Teacher> doSelectByType(int type){
		Session session = null;
		Transaction transaction = null;
		List<Teacher> data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			String sql = "from Teacher where type="+type+"";
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
	

	public List<Teacher> doSelectAll(){
		Session session = null;
		Transaction transaction = null;
		List<Teacher> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Teacher";
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
	
}
