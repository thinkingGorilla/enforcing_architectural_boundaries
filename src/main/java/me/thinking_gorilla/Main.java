package me.thinking_gorilla;

import me.thinking_gorilla.application.port.in.UserInterfacePort;
import me.thinking_gorilla.configuration.Assembler;

public class Main {
    public static void main(String[] args) {
        Assembler.init();
        Assembler.inject(UserInterfacePort.class).execute();
    }
}