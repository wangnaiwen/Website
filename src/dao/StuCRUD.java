package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

import sessionPa.HibernateSessionFactory;

public class StuCRUD {

	static Configuration config;
	static SessionFactory sessionFactory;
	static Session session;
	static Transaction transaction;

	public boolean doInsert(Student stu) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.persist(stu);
			transaction.commit();
			return true;
			// System.out.println("OK!");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
			// System.out.println("Fail!");
		} finally {
			/*if(session.isOpen()){
				session.close();
			}*/
		}
	}

	public boolean doDelete(String id) {
		Student newdata = null;

		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			newdata = (Student) session.get(Student.class, id);
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
			/*if(session.isOpen()){
				session.close();
			}*/
		}
	}

	public Student doSelect(String i) {
		Student data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (Student) session.get(Student.class, i);
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			/*if(session.isOpen()){
				session.close();
			}*/
		}
		return data;
	}

	public boolean doModify(Student stu) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			Student s = null;
			s = doSelect(stu.getSid());
			if(s != null){
				doDelete(stu.getSid());
				doInsert(stu);
			}
			//transaction.commit();
			return true;
//			System.out.println("OK!");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
//			System.out.println("Fail!");
		} finally {
			/*if(session.isOpen()){
				session.close();
			}*/
		}
	}
	
	public List<Student> doSelectByType(int type){
		List<Student> data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			String sql = "from Student where type="+type+"";
			Query q = session.createQuery(sql);
			data = q.list();
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			/*if(session.isOpen()){
				session.close();
			}*/
		}
		return data;
	}
	

	public List<Student> doSelectAll(){
		List<Student> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Student";
			Query q = session.createQuery(sql);
			list = q.list();
			// System.out.println(newdata.toString());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			/*if(session.isOpen()){
				session.close();
			}*/
		}
		return list;
	}
}
