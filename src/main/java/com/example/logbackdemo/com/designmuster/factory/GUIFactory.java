package com.example.logbackdemo.com.designmuster.factory;

/**
 * @program: source-demo
 * @description: 抽象工厂接口
 * @ClassName：GUIFactory
 * @author: Mr.Wang
 * @create: 2022-02-24 14:25
 **/
public interface GUIFactory {

    Button createBUtton();
    CheckBox createCheckBox();
}
