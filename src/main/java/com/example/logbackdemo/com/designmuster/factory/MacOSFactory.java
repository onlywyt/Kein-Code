package com.example.logbackdemo.com.designmuster;

/**
 * @program: source-demo
 * @description:
 * @ClassName：MacOSFactory
 * @author: Mr.Wang
 * @create: 2022-02-24 14:35
 **/
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createBUtton() {
        return new MacOSButton("");
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox("");
    }
}
