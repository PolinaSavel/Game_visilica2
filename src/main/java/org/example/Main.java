package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Na kakuyu temu vi bi hoteli? ovoshi, frukti, eda, cveti?");

        Question question = new Question();
        question.questionTopic();

        Risunok risunok = new Risunok();
        Igra igra = new Igra();
        igra.slovoPoBukvam(question.topic);

        igra.ugadivaemBukvu(question.topic, risunok, igra.bukva);


        risunok.risovanie();
    }
}
