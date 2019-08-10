package com.comers.shenwu.stronger;

public class ProductMachine implements Machine {
    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing");
    }

    @Override
    public void carryOn() {
        System.out.println("carryOn");
    }
}
