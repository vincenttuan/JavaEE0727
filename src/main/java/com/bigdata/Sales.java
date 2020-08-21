package com.bigdata;

public class Sales {

    private String region;
    private String country;
    private String iemtype;
    private String saleschannel;
    private String orderpriority;
    private String orderdate;
    private int orderid;
    private String shipdate;
    private int unitssold;
    private double unitprice;
    private double unitcost;
    private double totalrevenue;
    private double totalcost;
    private double totalprofit;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIemtype() {
        return iemtype;
    }

    public void setIemtype(String iemtype) {
        this.iemtype = iemtype;
    }

    public String getSaleschannel() {
        return saleschannel;
    }

    public void setSaleschannel(String saleschannel) {
        this.saleschannel = saleschannel;
    }

    public String getOrderpriority() {
        return orderpriority;
    }

    public void setOrderpriority(String orderpriority) {
        this.orderpriority = orderpriority;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getShipdate() {
        return shipdate;
    }

    public void setShipdate(String shipdate) {
        this.shipdate = shipdate;
    }

    public int getUnitssold() {
        return unitssold;
    }

    public void setUnitssold(int unitssold) {
        this.unitssold = unitssold;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(double unitcost) {
        this.unitcost = unitcost;
    }

    public double getTotalrevenue() {
        return totalrevenue;
    }

    public void setTotalrevenue(double totalrevenue) {
        this.totalrevenue = totalrevenue;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public double getTotalprofit() {
        return totalprofit;
    }

    public void setTotalprofit(double totalprofit) {
        this.totalprofit = totalprofit;
    }

    @Override
    public String toString() {
        return "Sales{" + "region=" + region + ", country=" + country + ", iemtype=" + iemtype + ", saleschannel=" + saleschannel + ", orderpriority=" + orderpriority + ", orderdate=" + orderdate + ", orderid=" + orderid + ", shipdate=" + shipdate + ", unitssold=" + unitssold + ", unitprice=" + unitprice + ", unitcost=" + unitcost + ", totalrevenue=" + totalrevenue + ", totalcost=" + totalcost + ", totalprofit=" + totalprofit + '}';
    }
    
    
}
