// implemented from user profile class
import java.lang.*;
import java.util.*;
public class BMI_Calculator
{
    private String height;
    private String weight;

    // default setting, show 0 on user profile
    public BMI_Calculator()
    {
        this.height = "0.0";
        this.weight = "0.0";
    }

    public BMI_Calculator(String height, String weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public String BMI_Calculate()
    {
        double h = 0.0;
        double w = 0.0;
        double BMI = 0.0;
        String BMI_Result= "";
        // check whether user inputs about height and height are valid
        try
        {
            h = Double.parseDouble(this.height);
            w = Double.parseDouble(this.weight);
            h = h/100;


        }
        catch(Exception e)
        {
            System.out.println("Invalid height and/or weight information!");
            System.err.println(e);
            w = 0.0;
            h = 0.0;

        }

        try
        {
            BMI = w/Math.pow(h,2);
        }
        catch(Exception e)
        {
            System.err.println(e);
            BMI = 0.0;
        }

        BMI_Result = String.valueOf(BMI);
        return BMI_Result;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    // convert lbs to kg
    public String convertLBS(String weight)
    {
        double w = 0.0;
        double wKG = 0.0;



        try
        {
            w = Double.parseDouble(weight);

        }
        catch(Exception e)
        {
            System.out.println("Invalid weight information!");
            System.err.println(e);
            w = 0.0;
        }

        wKG = w*0.453592;

        return String.valueOf(wKG);


    }

    // convert Feet tall to cm tall
    public String convertFEET(String height)
    {
        String[] height_sep = null;



        if(height.contains("."))
        {
            height_sep = height.split("\\.");


        }
        else if(height.contains("'"))
        {
            height_sep = height.split("\'");
        }

        double hFeet = 0.0;
        double hInch = 0.0;
        double hCM = 0.0;

        try
        {
            if(height_sep.length > 2)
            {
                throw new Exception("Invalid height information!");
            }
            hFeet = Double.parseDouble(height_sep[0]);
            hInch = Double.parseDouble(height_sep[1]);

        }

        catch(Exception e)
        {
            System.out.println("Invalid height information!");
            System.err.println(e);
            hFeet = 0.0;
            hInch = 0.0;
        }

        hCM = hFeet*30.48 + hInch*2.54;
        return String.valueOf(hCM);

    }



}