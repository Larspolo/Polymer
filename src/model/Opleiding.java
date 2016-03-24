package model;

public class Opleiding{
    private String naam;
    private Student leerling;
    private Klas mijnKlas;

        public Opleiding(String nm){
            naam = nm;
        }

        public void toevoegenStudent(Student lrLng){
            leerling = lrLng;
        }

        public void toevoegenKlas(Klas mK){
            mijnKlas = mk;
        }

    }