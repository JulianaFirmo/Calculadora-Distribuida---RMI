package com.company;

import javax.swing.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Calculadora calculadora = (Calculadora)Naming.lookup("rmi://localhost:8000/Calculadora");
            boolean active = true;
            while (active) {
                String menu = JOptionPane.showInputDialog("Escolha uma opção: " + "\n1-Soma\n2-Subtração\n3-Multiplicação\n4-Divisão\n5-Porcentagem\n6-Raiz quadrada\n7-Potenciação\n0-Sair");

                switch (menu) {
                    case "1":{
                        Double[] numbers = read();
                        double result = calculadora.soma(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "2":{
                        Double[] numbers = read();
                        double result = calculadora.sub(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "3":{
                        Double[] numbers = read();
                        double result = calculadora.multi(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "4":{
                        Double[] numbers = read();
                        try {
                            double result = calculadora.div(numbers[0], numbers[1]);
                            print(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Divisão por 0 não disponível");
                        }
                        break;
                    }
                    case "5":{
                        Double[] numbers = read();
                        try {
                            double result = calculadora.porc(numbers[0], numbers[1]);
                            print(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Divisão por 0 não disponível");
                        }
                        break;
                    }
                    case "6":{
                        Double[] numbers = read2();
                        try {
                            double result = calculadora.raiz(numbers[0]);
                            print(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Divisão por 0 não disponível");
                        }
                        break;
                    }
                    case "7":{
                        Double[] numbers = read();
                        try {
                            double result = calculadora.pot(numbers[0], numbers[1]);
                            print(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Divisão por 0 não disponível");
                        }
                        break;
                    }

                    case "0":{
                        active = false;
                        break;
                    }

                    default: {
                        JOptionPane.showMessageDialog(null, "Operador inválido");
                    }
                }
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Server refused:" + exception.getMessage());
        }
    }

    private static void print(double result) {
        JOptionPane.showMessageDialog(null, "O resultado é:" + result);
    }

    private static Double[] read() {
        Double[] numbers = new Double[2];
        numbers[0] = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro número:"));
        numbers[1] = Double.parseDouble(JOptionPane.showInputDialog("Insira o segundo número:"));
        return numbers;
    }
    private static Double[] read2() {
        Double[] numbers = new Double[1];
        numbers[0] = Double.parseDouble(JOptionPane.showInputDialog("Insira o número:"));
        return numbers;
    }
}
