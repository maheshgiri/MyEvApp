package com.example.hungry.projectone;

/**
 * Created by Hungry on 1/2/2016.
 */
public class TableInfo {
String Code;
int from=100;
int to=100;
int qty=1;
int total;
int totalSum;
TableInfo(String code,int from,int to,int qty,int total,int totalSum){
    this.Code=code;
    this.from=from;
    this.to=to;
    this.qty=qty;
    this.total=total;
    this.totalSum=totalSum;
}
TableInfo(){

}

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
