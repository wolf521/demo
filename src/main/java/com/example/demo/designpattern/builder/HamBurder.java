package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 汉堡包
 **/
public abstract class HamBurder implements Food {
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
        return new Wrapper().pack();
    }
}
