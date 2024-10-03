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

    public void setVerniyOtvet(boolean[] verniyOtvet) {
        this.verniyOtvet = verniyOtvet;
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

        for (int i = 0; i < 11; i++) {          // 11 popitok 4tobi narisovat zayca
            int peremennaya = 0;

            for (int f = 0; f < topic.length(); f++) {
                if (verniyOtvet[f]) {
                    peremennaya = peremennaya + 1;
                }
            }

            if (peremennaya == topic.length()) {                      //esli slovo ugadano
                risunok.setProigrish(true);
                break;
            } else {
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

                            } else if (!ugadalBukvu) {                  //esli ne ugadali bukvu
                                neUgadalBukvu = true;
                            }
                        }
                        if (ugadalBukvu) {                       //vivodim otvet esli ugadali
                            System.out.println("U vas ostalos " + (11 - (i + 1)) + " popitok");
                        } else if (neUgadalBukvu) {                                     //vivodim otvet esli ne ugadali
                            System.out.println("Takoi bukvi net v slove, u vas ostalos " + (11 - (i + 1)) + " popitok");
                        }
                    }
                }
            }
            //risunok.setProigrish(false);
            //break;
        }
    }
}



/*
        for (int f = 0; f < topic.length(); f++) {
            int peremennaya = 0;

            for (int i = 0; i < 11; i++) {          // 11 popitok 4tobi narisovat zayca
                if (!verniyOtvet[f]) {
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
                        System.out.println("U vas ostalos " + (11 - (i + 1)) + " popitok");
                    } else if (neUgadalBukvu) {                                     //vivodim otvet esli ne ugadali
                        System.out.println("Takoi bukvi net v slove, u vas ostalos " + (11 - (i + 1)) + " popitok");
                    }
                } else {

                    for (int n = 0; n < topic.length(); n++) {    // proveryem vse li bukvi ugadali

                        if (!verniyOtvet[n]) {
                            peremennaya = peremennaya + peremennaya;
                        } else {
                            peremennaya = peremennaya + 1;
                        }
                    }
                }
                if (peremennaya == topic.length()) {                      //esli slovo ugadano
                    risunok.setProigrish(true);
                    break;
                }
            }
        }
    }*/
