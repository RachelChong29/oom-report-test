package com.solve.oom.report.processor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.solve.oom.report.model.Report;
import com.solve.oom.report.model.ReportRow;
import com.solve.oom.report.model.Request;

public class RequestProcessor {

	public RequestProcessor() {

	}

	public Report processRequest(Request req) {
		Report report = new Report(UUID.randomUUID());
		
		List<ReportRow> allRowList = new ArrayList<>();
		LocalDate startDate = req.getStartDate();
		LocalDate endDate = req.getEndDate();
		
		long numDay = ChronoUnit.DAYS.between(startDate,endDate) +1;
		
		for(int i=0; i<numDay; i++) {
			allRowList.addAll(createRow());
		}
		
		report.setReportRowList(allRowList);
		
		return report;
	}
	
	public List<ReportRow> createRow() {
		List<ReportRow> rowList = new ArrayList<>();
		
		for(long i =0; i<10000; i++) {
			ReportRow r = new ReportRow(i, new Date(), new Date(), BigDecimal.ZERO, 100L, "instrumentName");
			rowList.add(r);
		}

		return rowList;
	}
}
