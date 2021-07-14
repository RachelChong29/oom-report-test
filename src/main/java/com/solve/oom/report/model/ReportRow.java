package com.solve.oom.report.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReportRow {

	public ReportRow() {
		// TODO Auto-generated constructor stub
	}

	
	private Long rowId;
	
	private Date tradeDate;
	
	private Date settlementDate;
	
	private BigDecimal price;
	
	private Long quantity;
	
	private String instrumentName;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public ReportRow(Long rowId, Date tradeDate, Date settlementDate, BigDecimal price, Long quantity,
			String instrumentName) {
		super();
		this.rowId = rowId;
		this.tradeDate = tradeDate;
		this.settlementDate = settlementDate;
		this.price = price;
		this.quantity = quantity;
		this.instrumentName = instrumentName;
	}
	
}
