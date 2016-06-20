package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sessionPa.HibernateSessionFactory;
import entity.Publishjob;
import entity.PublishjobId;
import entity.Submitjob;
import entity.SubmitjobId;

public class SubmitJobCRUD {
	static Configuration config;
	static SessionFactory sessionFactory;
	

	public boolean doInsert(Submitjob job) {
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

	public boolean doDelete(SubmitjobId id) {
		Submitjob newdata = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			newdata = (Submitjob) session.get(Submitjob.class, id);
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

	public Submitjob doSelect(SubmitjobId i) {
		Session session = null;
		Transaction transaction = null;
		Submitjob data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (Submitjob) session.get(Submitjob.class, i);
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

	public boolean doModify(Submitjob job) {
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
	

	public List<Submitjob> doSelectAll(){
		Session session = null;
		Transaction transaction = null;
		List<Submitjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Submitjob";
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
	public List<Submitjob> doSelectByCid(String cid){
		Session session = null;
		Transaction transaction = null;
		List<Submitjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Submitjob where cid='"+cid+"'";
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
	public List<Submitjob> doSelectByCidAno(String cid, int ano){
		Session session = null;
		Transaction transaction = null;
		List<Submitjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Submitjob where cid='"+cid+"' and ano="+ano;
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
	
	public List<Submitjob> doSelectByCSID(String cid, String sid){
		Session session = null;
		Transaction transaction = null;
		List<Submitjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Submitjob where cid='"+cid+"' and sid='"+sid+"'";
			//String hql = "select o from Course o where o.id in(select m.id.course.id from Sc m where m.id.student.id ='"+sid+"')";
			//String sql = "from Course where id not in(select cid from Sc where sid='"+sid+"')";
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
	
	public List<Submitjob> doSelectByCSAID(String cid, String sid, int ano){
		Session session = null;
		Transaction transaction = null;
		List<Submitjob> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from Submitjob where cid='"+cid+"' and sid='"+sid+"' and ano="+ano;
			//String hql = "select o from Course o where o.id in(select m.id.course.id from Sc m where m.id.student.id ='"+sid+"')";
			//String sql = "from Course where id not in(select cid from Sc where sid='"+sid+"')";
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
