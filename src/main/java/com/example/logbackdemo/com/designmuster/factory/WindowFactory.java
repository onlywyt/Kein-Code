package com.example.logbackdemo.com.designmuster;

/**
 * @program: source-demo
 * @description:
 * @ClassName：WindowFactory
 * @author: Mr.Wang
 * @create: 2022-02-24 14:28
 **/
public class WindowFactory implements GUIFactory{
    @Override
    public Button createBUtton() {
        return new WindowButton("");
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox("");
    }
}
