package com.sshf.sys;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtRoleDict entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtRoleDict
 * @author MyEclipse Persistence Tools
 */

public class CmtRoleDictDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtRoleDictDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_DESC = "roleDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(CmtRoleDict transientInstance) {
		log.debug("saving CmtRoleDict instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtRoleDict persistentInstance) {
		log.debug("deleting CmtRoleDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtRoleDict findById(java.lang.Long id) {
		log.debug("getting CmtRoleDict instance with id: " + id);
		try {
			CmtRoleDict instance = (CmtRoleDict) getHibernateTemplate().get(
					"com.ssh.sys.CmtRoleDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtRoleDict instance) {
		log.debug("finding CmtRoleDict instance by example");
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
		log.debug("finding CmtRoleDict instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmtRoleDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByRoleDesc(Object roleDesc) {
		return findByProperty(ROLE_DESC, roleDesc);
	}

	public List findAll() {
		log.debug("finding all CmtRoleDict instances");
		try {
			String queryString = "from CmtRoleDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtRoleDict merge(CmtRoleDict detachedInstance) {
		log.debug("merging CmtRoleDict instance");
		try {
			CmtRoleDict result = (CmtRoleDict) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtRoleDict instance) {
		log.debug("attaching dirty CmtRoleDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtRoleDict instance) {
		log.debug("attaching clean CmtRoleDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtRoleDictDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtRoleDictDAO) ctx.getBean("CmtRoleDictDAO");
	}
}