package com.company;
import com.company.Calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rmi extends UnicastRemoteObject implements Calculadora {

    public Rmi() throws RemoteException {
        double a, b;
    }

    public double soma(double a, double b) throws RemoteException {
        return a + b;
    }

    public double sub(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multi(double a, double b) throws RemoteException {
        return a * b;
    }

    public double div(double a, double b) throws RemoteException {
        return a / b;
    }

    public double porc(double a, double b) throws RemoteException {
        return a*(b/100);
    }

    public double raiz(double a) throws RemoteException {
        a = Math.sqrt(a);
        return a;
    }

    public double pot(double a, double b)
    {
        return Math.pow(a,b);
    }
}