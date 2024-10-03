package org.example;

import java.util.Scanner;
import java.util.Random;

public class Question {
    String topic;
    String viborTemi;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    private static final String KLETKA = "__  ";

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Question() {
    }

    public void questionTopic() {
        viborTemi = sc.nextLine();
        switch (viborTemi) {
            case "ovoshi" -> podgotovitTopik( new String[]{"svekla", "morkovka", "perec", "baklajan", "pomidor", "ogurec", "kapusta"});
            case "frukti" -> podgotovitTopik( new String[]{"banan", "grusha", "sliva", "persik", "vinograd", "ananas", "nektarin"});
            case "eda" -> podgotovitTopik( new String[]{"plov", "ris", "kurica", "salat", "krevetki", "uha", "kotleta"});
            case "цветы" -> podgotovitTopik( new String[]{"fialka", "astra", "gortenzia", "lileynik", "podsolnuh", "kalla", "oduvanchik"});
            default -> System.out.println("Vi vveli neizvestnoe znachenie, poprobuyte eshe raz!");
        }
    }

    private void podgotovitTopik(String [] naborSlov) {
        topic = (naborSlov[rand.nextInt(naborSlov.length)]);
        dlinaSlova();
    }

    public void dlinaSlova (){
        int index = topic.length();
        System.out.println("V slove " + (index) + " bukv:");
        for (int i = 0; i < index; i++) {
            System.out.print(KLETKA);
        }
    }
}
