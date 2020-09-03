package com.hfad.quadraticformulacalculator;



public class MathLogic {


    public double[] getX(double a, double b, double c)
    {
        double[] answers = new double[2];
        answers[0] = ((b * -1) + (Math.sqrt(b*b - 4 * a * c))) / (2 * a);
        answers[1] = ((b * -1) - (Math.sqrt(b*b - 4 * a * c))) / (2 * a);
        return answers;
    }
    public boolean isNull(String x)
    {
        return (x.equals("-") || x.equals(".") || x.equals("-.") || x.equals(""));

    }


}

