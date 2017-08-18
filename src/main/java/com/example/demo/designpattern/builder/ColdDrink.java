package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 冷饮
 **/
public abstract class ColdDrink implements Food {
    /**
     * 名称
     *
     * @return
     */
    public abstract String name();

    /**
     * 价格
     *
     * @return
     */
    public abstract double price();

    /**
     * 包装
     *
     * @return
     */
    public String packing() {
        return new Bottle().pack();
    }
}
