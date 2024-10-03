package org.example;

public class Risunok extends Igra {
    private static final String PALKA = "\\";
    boolean proigrish;

    public Risunok() {
    }

    public boolean isProigrish() {
        return proigrish;
    }

    public void setProigrish(boolean proigrish) {
        this.proigrish = proigrish;
    }

    public void risovanie() {
        System.out.println("(" + PALKA + "_/)");
        System.out.println("='.'=");
        if (!proigrish) {
            System.out.println("Vi proigrali");
        } else {
            System.out.println("Vi viygrali, MOLODEC!");
        }
    }
}
