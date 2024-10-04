package org.example;

import java.util.Scanner;

public class Igra extends Question {
    String varianBukviIgroka;
    String[] bukva;
    boolean[] verniyOtvet;
    Scanner scanner = new Scanner(System.in);

    public void setBukva(String[] bukva) {
        this.bukva = bukva;
    }

    public void slovoPoBukvam(String topic) {
        String[] bukva = new String[topic.length()];                //zapisivaem v massiv bukvi slova

        for (int i = 0; i < topic.length(); i++) {
            bukva[i] = topic.substring(i, i + 1);
            setBukva(bukva);
        }
    }

    public void ugadivaemBukvu(String topic, Risunok risunok, String[] bukva) {
        boolean[] verniyOtvet = new boolean[topic.length()];

        var kolvoPopitok = 11;
        for (int i = 0; i < kolvoPopitok; i++) {          // 11 popitok 4tobi narisovat zayca
            var peremennaya = initializePeremennaya(topic, verniyOtvet);

            if (peremennaya == topic.length()) {                      //esli slovo ugadano
                risunok.setProigrish(true);
                break;
            }
            System.out.println("\nVvedite vashu bukvu: ");
            varianBukviIgroka = scanner.nextLine();
            boolean neUgadalBukvu = false;
            boolean ugadalBukvu = false;

            for (int j = 0; j < topic.length(); j++) {

                if (bukva[j].equals(varianBukviIgroka)) {                          //proverka po pervomu krugu
                    System.out.println("Bukva " + bukva[j] + " pod nomerom: " + (j + 1));
                    verniyOtvet[j] = true;      // esli bukvu ugadali, to true
                    ugadalBukvu = true;
                    neUgadalBukvu = false;

                    for (int k = j + 1; k < topic.length(); k++) {    //vdrug v slove dve povtoryayushiesya bukvi

                        if (bukva[k].equals(varianBukviIgroka)) {
                            System.out.println("Eshe bukva " + bukva[k] + " pod nomerom: " + (k + 1));
                            j = k + 1;
                            verniyOtvet[k] = true;
                        }
                    }
                } else if (!ugadalBukvu) {                  //esli ne ugadali bukvu
                    neUgadalBukvu = true;
                }
            }
            if (ugadalBukvu) {                       //vivodim otvet esli ugadali
                System.out.println("U vas ostalos " + (kolvoPopitok - (i + 1)) + " popitok");
            } else if (neUgadalBukvu) {                                     //vivodim otvet esli ne ugadali
                System.out.println("Takoi bukvi net v slove, u vas ostalos " + (kolvoPopitok - (i + 1)) + " popitok");
            }
        }
    }

    public int initializePeremennaya(String topic, boolean[] verniyOtvet) {
        int peremennaya = 0;
        for (int f = 0; f < topic.length(); f++) {
            if (verniyOtvet[f]) {
                peremennaya = peremennaya + 1;
            }
        }
        return peremennaya;
    }
}

