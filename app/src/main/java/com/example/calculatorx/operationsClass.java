package com.example.calculatorx;

import java.math.*;

class operationsClass {

    private static BigDecimal b1;
    private static BigDecimal b2;

    static String add(String val1, String val2)
    {
        try{
            b1=new BigDecimal(val1);
            b2=new BigDecimal(val2);
        }
        catch(Exception e)
        {
            System.out.println("It's not a number");
            return "Error";
        }
        BigDecimal res=b1.add(b2);
        return res.toString();
    }

    static String subtract(String val1,String val2)
    {
        try{
            b1=new BigDecimal(val1);
            b2=new BigDecimal(val2);
        }
        catch(Exception e)
        {
            System.out.println("It's not a number");
            return "Error";
        }
        BigDecimal res=b1.subtract(b2);
        return res.toString();

    }

    static String divide(String val1,String val2)
    {
        if (val2.equals("0")){
            return "Error";
        }
        try{
            b1=new BigDecimal(val1);
            b2=new BigDecimal(val2);
        }
        catch(Exception e)
        {
            System.out.println("It's not a number");
            return "Error";
        }
        BigDecimal res=b1.divide(b2,new MathContext(10,RoundingMode.HALF_UP));
        return res.toString();
    }

    static String multiply(String val1,String val2)
    {
        try{
            b1=new BigDecimal(val1);
            b2=new BigDecimal(val2);
        }
        catch(Exception e)
        {
            System.out.println("It's not a number");
            return "Error";
        }
        BigDecimal res=b1.multiply(b2);
        return res.toString();
    }
}
