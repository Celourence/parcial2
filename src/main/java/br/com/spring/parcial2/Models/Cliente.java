package br.com.spring.parcial2.Models;

public class Cliente {


    public static String getNome() {
        return Nome;
    }

    public static void setNome(String nome) {
        Nome = nome;
    }

    public static String getTitular_Eleitor() {
        return Titular_Eleitor;
    }

    public static void setTitular_Eleitor(String titular_Eleitor) {
        Titular_Eleitor = titular_Eleitor;
    }

    public static String getCPF() {
        return CPF;
    }

    public static void setCPF(String cpf) {
        CPF = cpf;
    }



    public static int getID() {
        return ID;
    }

    public static void setID(int id) {
        ID = id;
    }
    private static int ID;
    private static String Nome;
    private static String Titular_Eleitor;
    private static String CPF;
}
