package com.company;

public class TaskCheck
{
    String[][] dependencies = new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}}; //new String[]{ "A" , "B", "C", "D" })

    public boolean isWellSorted(String[] sequence)
    {
        for (int i = 0; i < sequence.length; i++)
        {
            for (int x = i+1; x < sequence.length; x++)
            {
                if(sequence[x].equals(sequence[i]))
                    return false;
            }
        }

        for (String[] dependency : dependencies)
        {
            int index1 = 0;
            int index2 = 0;

            for (int x = 0; x < sequence.length; x++)
            {
                if (dependency[0] == sequence[x])
                    index1 = x;
                else if (dependency[1] == sequence[x])
                    index2 = x;
            }

            if (index1 > index2)
                return false;
        }

        return true;
    }
}
