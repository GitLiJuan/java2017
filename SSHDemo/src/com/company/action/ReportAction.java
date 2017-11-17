package com.company.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.service.iservice.ReportService;

@Controller("reportAction")
@Scope("prototype")
public class ReportAction {
	@Autowired
	ReportService service;

	public void getInfoReport() {
		String str = service.reportDeptInfo();
		try {
			ServletActionContext.getResponse().getWriter().println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
