import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws TestException
    {
        Scanner scanner = new Scanner(System.in);

        String sExpression = scanner.nextLine();
        System.out.println(calc(sExpression));
        scanner.close();
    }
    public static String calc(String sExpression) throws TestException 
    {
        boolean[] bRomeNum = {false, false};
        String[] Args = sExpression.split(" ");

        if (Args.length != 3) 
        {
            throw new TestException("Неверный формат выражения");
        }
        float fNum1, fNum2;
        try 
        {
            fNum1 = Float.parseFloat(Args[0].trim());
            if(fNum1 < 1 || fNum1 > 10) throw new TestException("Число вышло за рамки допустимого");
            if(fNum1 % 1 != 0) throw new TestException("Только целые числа");
        } 
        catch (NumberFormatException e) 
        {
            bRomeNum[0] = !bRomeNum[0];
            switch (Args[0]) 
            {
                case "I": fNum1 = 1;
                case "II": fNum1 = 2;
                case "III": fNum1 = 3;
                case "IV": fNum1 = 4;
                case "V": fNum1 = 5;
                case "VI": fNum1 = 6;
                case "VII": fNum1 = 7;
                case "VIII": fNum1 = 8;
                case "IX": fNum1 = 9;
                case "X": fNum1 = 10;
                default: throw new TestException("Число должно быть от I до X");
            }
        }
        try 
        {
            fNum2 = Float.parseFloat(Args[2].trim());
            if(fNum2 < 1 || fNum2 > 10) throw new TestException("Число вышло за рамки допустимого");
            if(fNum2 % 1 != 0) throw new TestException("Только целые числа");
        } 
        catch (NumberFormatException e) 
        {
            bRomeNum[1] = !bRomeNum[1];
            switch (Args[2]) 
            {
                case "I": fNum2 = 1;
                case "II": fNum2 = 2;
                case "III": fNum2 = 3;
                case "IV": fNum2 = 4;
                case "V": fNum2 = 5;
                case "VI": fNum2 = 6;
                case "VII": fNum2 = 7;
                case "VIII": fNum2 = 8;
                case "IX": fNum2 = 9;
                case "X": fNum2 = 10;
                default: throw new TestException("Число должно быть от I до X");
            }
        }
       if (bRomeNum[0] != bRomeNum[1])
           throw new TestException("Только арабские или только римские числа");

        int iResult; String sReturn = "";
        if(Args[1] != "+" && Args[1] != "-" && Args[1] != "*" && Args[1] != "/")
        {
            throw new TestException("Неверный операнд");
        }
        switch (Args[1]) 
        {
            case "+": 
            {
                iResult = (int) fNum1 + (int) fNum2;
                if (bRomeNum[0]) 
                {
                    if (iResult < 1)
                        throw new TestException("Результат вычислений с римскими числами должен быть положительным");
                    
                    sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + m_prGetStrNum(iResult);// = Args[0] + " " + Args[1] + " " + Args[2] + " = " + m_prGetStrNum(iResult);
                } 
                else sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + iResult;
            }
            case "*": {
                iResult = (int) fNum1 * (int) fNum2;
                if (bRomeNum[0]) 
                {
                    if (iResult < 1)
                        throw new TestException("Результат вычислений с римскими числами должен быть положительным");
                    sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + m_prGetStrNum(iResult);
                } 
                else sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + iResult;
            }
            case "-": {
                iResult = (int) fNum1 - (int) fNum2;
                if (bRomeNum[0]) 
                {
                    if (iResult < 1)
                        throw new TestException("Результат вычислений с римскими числами должен быть положительным");
                    sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + m_prGetStrNum(iResult);
                } 
                else sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + iResult;
            }
            case "/": {
                iResult = (int) fNum1 / (int) fNum2;
                if (bRomeNum[0]) 
                {
                    if (iResult < 1)
                        throw new TestException("Результат вычислений с римскими числами должен быть положительным");
                    sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + m_prGetStrNum(iResult);
                } 
                else sReturn = Args[0] + " " + Args[1] + " " + Args[2] + " = " + iResult;
            }
        }
        return sReturn;
    }
    private static String m_prGetStrNum(int iResult) 
    {
        String sResult = "";
        while (iResult > 0) 
        {
            if (iResult >= 1000)
            {
                sResult = sResult.concat("M");
                iResult -= 1000;
                continue;
            }
            if (iResult >= 500)
            {
                sResult = sResult.concat("D");
                iResult -= 500;
                continue;
            }
            if (iResult >= 100)
            {
                sResult = sResult.concat("C");
                iResult -= 100;
                continue;
            }
            if (iResult >= 50)
            {
                sResult = sResult.concat("L");
                iResult -= 50;
                continue;
            }
            if (iResult >= 10) 
            {
                sResult = sResult.concat("X");
                iResult -= 10;
                continue;
            }
            if (iResult >= 9) 
            {
                sResult = sResult.concat("IX");
                iResult -= 9;
                continue;
            }
            if (iResult >= 8) 
            {
                sResult = sResult.concat("VIII");
                iResult -= 8;
                continue;
            }
            if (iResult >= 7) 
            {
                sResult = sResult.concat("VII");
                iResult -= 7;
                continue;
            }
            if (iResult >= 6) 
            {
                sResult = sResult.concat("VI");
                iResult -= 6;
                continue;
            }
            if (iResult >= 5) 
            {
                sResult = sResult.concat("V");
                iResult -= 5;
                continue;
            }
            if (iResult >= 4) 
            {
                sResult = sResult.concat("IV");
                iResult -= 4;
                continue;
            }
            if (iResult >= 3) 
            {
                sResult = sResult.concat("III");
                iResult -= 3;
                continue;
            }
            if (iResult >= 2) 
            {
                sResult = sResult.concat("II");
                iResult -= 2;
                continue;
            }
            sResult = sResult.concat("I");
            iResult -= 1;

        }
        return sResult;
    }
}