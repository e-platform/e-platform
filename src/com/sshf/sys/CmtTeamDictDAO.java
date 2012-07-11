package com.sshf.sys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmtTeamDict entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ssh.sys.CmtTeamDict
 * @author MyEclipse Persistence Tools
 */

public class CmtTeamDictDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CmtTeamDictDAO.class);
	// property constants
	public static final String PAR_TEAMID = "parTeamid";
	public static final String TEAM_NAME = "teamName";
	public static final String LEADER_LOGIN = "leaderLogin";

	protected void initDao() {
		// do nothing
	}

	public void save(CmtTeamDict transientInstance) {
		log.debug("saving CmtTeamDict instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmtTeamDict persistentInstance) {
		log.debug("deleting CmtTeamDict instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmtTeamDict findById(java.lang.String id) {
		log.debug("getting CmtTeamDict instance with id: " + id);
		try {
			CmtTeamDict instance = (CmtTeamDict) getHibernateTemplate().get(
					"com.ssh.sys.CmtTeamDict", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmtTeamDict instance) {
		log.debug("finding CmtTeamDict instance by example");
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
		log.debug("finding CmtTeamDict instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmtTeamDict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParTeamid(Object parTeamid) {
		return findByProperty(PAR_TEAMID, parTeamid);
	}

	public List findByTeamName(Object teamName) {
		return findByProperty(TEAM_NAME, teamName);
	}

	public List findByLeaderLogin(Object leaderLogin) {
		return findByProperty(LEADER_LOGIN, leaderLogin);
	}

	public List findAll() {
		log.debug("finding all CmtTeamDict instances");
		try {
			String queryString = "from CmtTeamDict";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmtTeamDict merge(CmtTeamDict detachedInstance) {
		log.debug("merging CmtTeamDict instance");
		try {
			CmtTeamDict result = (CmtTeamDict) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmtTeamDict instance) {
		log.debug("attaching dirty CmtTeamDict instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmtTeamDict instance) {
		log.debug("attaching clean CmtTeamDict instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmtTeamDictDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmtTeamDictDAO) ctx.getBean("CmtTeamDictDAO");
	}
}