package com.thinkgem.jeesite.modules.potevio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.potevio.entity.Watch;
import com.thinkgem.jeesite.modules.potevio.service.WatchService;

@Controller
@RequestMapping(value = "watch")
public class WatchController extends BaseController {
	@Autowired
	private WatchService watchService;

	@RequestMapping("latest")
	public @ResponseBody
	Object latestData() {
		Watch watch = watchService.latestData();
		if (watch != null) {
			return watch;
		}
		return "";
	}
}
