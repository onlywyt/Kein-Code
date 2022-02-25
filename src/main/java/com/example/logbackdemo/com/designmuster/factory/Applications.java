package com.example.logbackdemo.com.designmuster;


/**
 * @program: source-demo
 * @description:
 * @ClassName：Applications
 * @author: Mr.Wang
 * @create: 2022-02-24 14:38
 **/
public class Applications {

    private static GUIFactory factory;
    private Button button;

    public Applications(GUIFactory factory) {
        Applications.factory = factory;
    }


    public Button createUI(){
        this.button = factory.createBUtton();
        return button;
    }



    static class App {
        public static void main(String[] args) {
            if ("config.OS" == "Windows") {
                factory = new WindowFactory();
            }
        }
        Applications a = new Applications(factory);
    }
}
