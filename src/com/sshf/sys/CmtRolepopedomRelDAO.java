package com.sshf.sys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtRolepopedomRel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtRolepopedomRel
 * @author MyEclipse Persistence Tools
 */

public class CmtRolepopedomRelDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtRolepopedomRelDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(CmtRolepopedomRel transientInstance) {
		log.debug("saving CmtRolepopedomRel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtRolepopedomRel persistentInstance) {
		log.debug("deleting CmtRolepopedomRel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtRolepopedomRel findById(CmtRolepopedomRelId id) {
		log.debug("getting CmtRolepopedomRel instance with id: " + id);
		try {
			CmtRolepopedomRel instance = (CmtRolepopedomRel) getHibernateTemplate()
					.get("com.ssh.sys.CmtRolepopedomRel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtRolepopedomRel instance) {
		log.debug("finding CmtRolepopedomRel instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CmtRolepopedomRel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmtRolepopedomRel as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CmtRolepopedomRel instances");
		try {
			String queryString = "from CmtRolepopedomRel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtRolepopedomRel merge(CmtRolepopedomRel detachedInstance) {
		log.debug("merging CmtRolepopedomRel instance");
		try {
			CmtRolepopedomRel result = (CmtRolepopedomRel) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtRolepopedomRel instance) {
		log.debug("attaching dirty CmtRolepopedomRel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtRolepopedomRel instance) {
		log.debug("attaching clean CmtRolepopedomRel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtRolepopedomRelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtRolepopedomRelDAO) ctx.getBean("CmtRolepopedomRelDAO");
	}
}