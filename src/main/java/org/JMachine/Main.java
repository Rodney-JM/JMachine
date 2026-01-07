package org.JMachine;

import org.JMachine.infra.config.StudentConfig;
import org.JMachine.presentation.Console;
import org.JMachine.presentation.StudentConsoleHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentConsoleHandler handler = StudentConfig.studentHandler();
        Console console = new Console(handler);

        console.start();
    }
}