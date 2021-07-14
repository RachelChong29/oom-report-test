package com.solve.oom.report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.solve.oom.report.model.Report;
import com.solve.oom.report.model.Request;
import com.solve.oom.report.processor.RequestProcessor;

public class ReportTest {

	private static RequestProcessor requestProcessor;
	
	public ReportTest() {
		requestProcessor = new RequestProcessor();
	}
	
//	test environment :
//	1. vm arguments set to 
//		-Xms256m
//		-Xmx256m
//	2. Report period set to 30 days and each report has 10000 rows
//	3. Assume there are 15 threads start at the same time
//  4. Assume 3 as the num of threads in the pool
//	
// line 39 can test the scenario using thread pool
// line 43 can test the scenario without thread pool 
	
	public static void main(String[] args) {
		ReportTest reportTest = new ReportTest();
		
		LocalDate startDate = LocalDate.of(2020, 6, 1);
		LocalDate endDate = LocalDate.of(2020, 6, 30);
		
		Request req = new Request(startDate, endDate);
		
		//test thread pool that can run for all 15 threads without any out of memory error
		reportTest.testThreadPool(req);
		
		//test running 15 threads without using thread pool, this will cause out of memory error
//		reportTest.testWithoutThreadPool(req);
	}
		
	public void testThreadPool(Request req) {
		List<Thread> threadList = new ArrayList<>();
		
		for(int i=1; i<=15; i++) {
			Thread thread = new Thread(new MyRunnable(req, i));
			threadList.add(thread);
		}
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(Thread thread: threadList) {
			pool.execute(thread);
		}
          
        pool.shutdown();    
		
	}
	
	public void testWithoutThreadPool(Request req) {
		List<Thread> threadList = new ArrayList<>();
		
		for(int i=1; i<=15; i++) {
			Thread thread = new Thread(new MyRunnable(req, i));
			threadList.add(thread);
		}
		
		for(Thread thread: threadList) {
			thread.start();
		}
	}
	
	public class MyRunnable implements Runnable {
		private Request req;
		private int threadNum;
		
		public MyRunnable(Request req, int threadNum) {
		       this.req = req;
		       this.threadNum = threadNum;
		   }

		public void run(){
			System.out.println("Start Thread " + threadNum);
			Report report = requestProcessor.processRequest(req);
			System.out.println("End Thread" + threadNum + "; report id:" + report.getReportId() + "; report size:" + report.getReportRowList().size());
	    }
	}

}
