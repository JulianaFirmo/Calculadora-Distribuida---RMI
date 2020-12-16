package com.company;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class Server
{
    public static void main(String[] args) throws IOException
    {
        try {
            Registry registry = java.rmi.registry.LocateRegistry.createRegistry(8000);
            Rmi calculadoraRmi = new Rmi();
            registry.rebind("Calculadora", calculadoraRmi);
            JOptionPane.showMessageDialog(null, "Server Ready");
        } catch (RemoteException exception) {
            JOptionPane.showMessageDialog(null, "Server failure: " + exception.getMessage());
        }
    }
}
