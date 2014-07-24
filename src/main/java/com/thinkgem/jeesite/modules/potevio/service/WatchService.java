package com.thinkgem.jeesite.modules.potevio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.potevio.dao.WatchDao;
import com.thinkgem.jeesite.modules.potevio.entity.Watch;

@Service
@Transactional
public class WatchService extends BaseService {
	@Autowired
	private WatchDao watchDao;

	public void insertWatch(Watch watch) {
		watchDao.save(watch);
		// watchDao.getSession().save(watch);
	}

	public Watch latestData() {
		List<Watch> list = watchDao
				.find("from Watch w where w.createDate = (select max(createDate) from w)");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
