package com.solve.oom.report.model;

import java.util.List;
import java.util.UUID;

public class Report {

	
	private UUID reportId;
	
	private List<ReportRow> reportRowList;

	public UUID getReportId() {
		return reportId;
	}

	public void setReportId(UUID reportId) {
		this.reportId = reportId;
	}

	public List<ReportRow> getReportRowList() {
		return reportRowList;
	}

	public void setReportRowList(List<ReportRow> reportRowList) {
		this.reportRowList = reportRowList;
	}

	public Report(UUID reportId) {
		super();
		this.reportId = reportId;
//		this.reportRowList = reportRowList;
	}
	
}
