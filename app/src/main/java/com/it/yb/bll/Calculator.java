package com.it.yb.bll;

public class Calculator {

    private  double tip1;
    private  double tip2;
    private  double tip3;
    private  double tipCustom;

    public Calculator(double tip1,
                      double tip2, double tip3, double tipCustom) {
        this.tip1 = tip1;
        this.tip2 = tip2;
        this.tip3 = tip3;
        this.tipCustom = tipCustom;
    }

    public double getTip1() {
        return tip1;
    }

    public void setTip1(double tip1) {
        this.tip1 = tip1;
    }

    public double getTip2() {
        return tip2;
    }

    public void setTip2(double tip2) {
        this.tip2 = tip2;
    }

    public double getTip3() {
        return tip3;
    }

    public void setTip3(double tip3) {
        this.tip3 = tip3;
    }

    public double getTipCustom() {
        return tipCustom;
    }

    public void setTipCustom(double tipCustom) {
        this.tipCustom = tipCustom;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "tip1=" + tip1 +
                ", tip2=" + tip2 +
                ", tip3=" + tip3 +
                ", tipCustom=" + tipCustom +
                '}';
    }
}
