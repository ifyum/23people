package com.example.demo.models.Services;

public class RutValidator {
    public  static boolean validateRun(String run)
    {
        if (run != null && run.length() >= 2)
        {
            String dv = run.trim().substring(run.indexOf("-") + 1);

            if (dv.length() > 1)
            {
                return false;
            }

            String runWithoutDv = run.trim().substring(0, run.indexOf("-"));

            int result = 0;
            int n = 2;

            for(int i = 0; i < runWithoutDv.length(); i++)
            {
                if (n < 8)
                {
                    result += Integer.valueOf(String.valueOf(runWithoutDv.charAt(runWithoutDv.length() - 1 - i))) * n;
                }
                else
                {
                    n = 2;
                    result += Integer.valueOf(String.valueOf(runWithoutDv.charAt(runWithoutDv.length() - 1 - i))) * n;
                }

                n++;
            }

            int dvResult = 11 - (result % 11);

            if (dvResult < 10)
            {
                return Integer.valueOf(dv) == dvResult;
            }
            else if (dvResult == 10)
            {
                return dv.equalsIgnoreCase("k");
            }
            else
            {
                return Integer.valueOf(dv) == 0;
            }
        }

        return false;
    }

}
