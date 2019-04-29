/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.Serializable;

/**
 *
 * @author Abdallah_Ahmed
 */
public class Account implements Serializable{
    private int AccNo;
    private String AccName;
    private float AccBalance;

    public Account(int AccNo, String AccName, float AccBalance) {
        this.AccName = AccName;
        this.AccNo = AccNo;
        this.AccBalance = AccBalance;
    }
    

    public int getAccNo() {
        return AccNo;
    }
    
    public void setAccNo(int AccNo) {
        this.AccNo = AccNo;
    }

    public String getAccName() {
        return AccName;
    }

    public void setAccName(String AccName) {
        this.AccName = AccName;
    }

    public float getAccBalance() {
        return AccBalance;
    }

    public void setAccBalance(float AccBalance) {
        this.AccBalance = AccBalance;
    }

    @Override
    public String toString() {
        return "Account => " + " AccNo = " + AccNo + "\t AccName = " + AccName + "\t AccBalance = " + AccBalance + '.';
    }
    
    
    
}
