package com.project;

import com.project.Brain;

public class Babel {

    private Brain s;

    public Babel() {
        System.out.println("conectando :D");
    }

    public void connect(String ip, int port) {
        try {
            s = new Brain(ip, port);
            s.send("holi");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}