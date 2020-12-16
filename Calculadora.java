package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote
{
    public double soma(double x, double y) throws RemoteException;
    public double sub(double x, double y) throws RemoteException;
    public double multi(double x, double y) throws RemoteException;
    public double div(double x, double y) throws RemoteException;
    public double porc(double x, double y) throws RemoteException;;
    public double raiz(double x) throws RemoteException;;
    public double pot(double x, double y) throws RemoteException;;
}