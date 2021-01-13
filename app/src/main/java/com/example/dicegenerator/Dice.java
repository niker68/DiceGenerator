package com.example.dicegenerator;

public class Dice {
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    protected int numberOfSides;

    public int getNumberOfSides() {
        return numberOfSides;
    }
    public Dice(){
    }
    public Dice(int numberOfSides,int[]listOfColors,String[]listOfNumbers){
        this.numberOfSides = numberOfSides;
        this.listOfNumbers = listOfNumbers;
        this.listOfColors = listOfColors;
    }

    private String []listOfNumbers = new String[1];
    private int []listOfColors= new int[1];

    public void setListOfNumbers(String[] listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public void setListOfColors(int[] listOfColors) {
        this.listOfColors = listOfColors;
    }

    public String getNumber(int sideOfDice){
        return listOfNumbers[sideOfDice];
    }
    public int getColor(int sideOfDice){
        return listOfColors[sideOfDice];
    }
    public int ThrowDice(){
        if (numberOfSides>0){
        int sideOfDice = (int)(Math.round((Math.random()*(numberOfSides-1))));
        System.out.println("side = "+sideOfDice);
        return sideOfDice;}
        else{
            System.out.println("side must be >0");
            return 0;
        }
    }
}

