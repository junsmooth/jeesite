package com.thinkgem.jeesite.modules.potevio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.potevio.dao.BedDao;
import com.thinkgem.jeesite.modules.potevio.entity.Bed;

@Service
public class BedService extends BaseService {
	@Autowired
	private BedDao bedDao;

	public Bed latestBedData() {
		List<Bed> bedList = bedDao.findAll();
		if (bedList.size() > 0) {
			return bedList.get(0);
		}
		return null;
	}
}
