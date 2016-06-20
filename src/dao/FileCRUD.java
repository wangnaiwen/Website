package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sessionPa.HibernateSessionFactory;
import entity.File;
import entity.Publishjob;
import entity.PublishjobId;

public class FileCRUD {

	static Configuration config;
	static SessionFactory sessionFactory;
	

	public boolean doInsert(File file) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.persist(file);
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

	public boolean doDelete(File id) {
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

	public File doSelect(PublishjobId i) {
		Session session = null;
		Transaction transaction = null;
		File data = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			data = (File) session.get(File.class, i);
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

	public boolean doModify(File file) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			session.update(file);
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
	

	public List<File> doSelectAll(){
		Session session = null;
		Transaction transaction = null;
		List<File> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from File";
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
	
	public List<File> doSelectByCid(String cid){
		Session session = null;
		Transaction transaction = null;
		List<File> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from File where cid='"+cid+"'";
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
	public List<File> doSelectByCTA(String cid, String tid, int ano){
		Session session = null;
		Transaction transaction = null;
		List<File> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from File where cid='"+cid+"' and tid='"+tid+"' and ano="+ano;
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
	public List<File> doSelectByCAS(String cid, String sid, int ano){
		Session session = null;
		Transaction transaction = null;
		List<File> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sql = "from File where cid='"+cid+"' and sid='"+sid+"' and ano="+ano;
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
