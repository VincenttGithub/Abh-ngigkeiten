package com.company;

public class TaskCheck
{
    String[][] dependencies = new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}}; //new String[]{ "A" , "B", "C", "D" })

    public boolean isWellSorted(String[] sequence)
    {
        //If duplicates, false

        for (int i = 0; i < dependencies.length; i++)
        {
            int index1 = 0;
            int index2 = 0;

            for (int x = 0; x < sequence.length; x++)
            {
                if (dependencies[i][0] == sequence[x])
                    index1 = x;
                else if (dependencies[i][1] == sequence[x])
                    index2 = x;
            }

            if (index1 > index2)
                return false;
        }

        return true;
    }
}
