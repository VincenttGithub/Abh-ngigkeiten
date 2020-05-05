package com.company;

public class TaskCheck
{
    String[][] dependencies = new String[][]{{"A", "B"}, {"B", "C"}, {"C", "D"}};//new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}} //new String[]{ "A" , "B", "C", "D" })

    public boolean isWellSorted(String[] sequence)
    {
        for (int i = 0; i < sequence.length; i++)
        {
            for (int x = i + 1; x < sequence.length; x++)
            {
                if (sequence[x].equals(sequence[i]))
                    return false;
            }
        }

        for (String[] d : dependencies)
        {
            int depA = -1;
            int depB = -1;

            for (int x = 0; x < sequence.length; x++)
            {
                if (d[0].equals(sequence[x]))
                    depA = x;
                else if (d[1].equals(sequence[x]))
                    depB = x;
            }

            //Transitiv, wenn die Vorrausgesetze Aufgabe nicht gefunden wurde, suche eine mit höherer Priorität
            if (depA == -1 && depB != -1)
            {
                String letterToFind = d[0];
                while (depA == -1)
                {
                    String depZ = null;
                    for (String[] dependency : dependencies)
                    {
                        if (dependency[1].equals(letterToFind))
                            depZ = dependency[0];
                    }

                    if (depZ == null) //No dependency found
                    {
                        break;
                    }
                    else //Dependency found, follow it
                    {
                        for (int x = 0; x < sequence.length; x++)
                        {
                            if (depZ.equals(sequence[x]))
                            {
                                depA = x;
                                break;
                            }
                        }
                        letterToFind = depZ;
                    }
                }
            }

            if (depB != -1 && depA > depB)
                return false;
        }

        return true;
    }
}
