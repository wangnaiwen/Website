package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sessionPa.HibernateSessionFactory;
import entity.Course;
import entity.Publishjob;
import entity.PublishjobId;

public class PublishJobCRUD {
	static Configuration config;
	static SessionFactory sessionFactory;
	

	public boolean doInsert(Publishjob job) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.persist(job);
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

	public boolean doDelete(PublishjobId id) {
		Publishjob newdata = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			newdata = (Publishjob) session.get(Publishjob.class, id);
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

	public Publishjob doSelect(PublishjobId i) {
		Session session = null;
		Transaction transaction = null;
		Publishjob data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (Publishjob) session.get(Publishjob.class, i);
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

	public boolean doModify(Publishjob job) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			session.update(job);
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
	
	/*public List<PublishJob> doSelectByType(int type){
		Session session = null;
		Transaction transaction = null;
		List<PublishJob> data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			String sql = "from PublishJob";
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
	}*/
	

	public List<Publishjob> doSelectAll(){
		Session session = null;
		Transaction transaction = null;
		List<Publishjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Publishjob";
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
	public List<Publishjob> doSelectByCid(String cid){
		Session session = null;
		Transaction transaction = null;
		List<Publishjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Publishjob where cid='"+cid+"'";
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
	
/*	public List<Publishjob> doSelectBySID(String sid){
		Session session = null;
		Transaction transaction = null;
		List<Publishjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select o from Course o where o.id in(select m.id.course.id from Sc m where m.id.student.id ='"+sid+"')";
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
	}*/
}
