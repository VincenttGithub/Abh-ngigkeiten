package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskCheckTest
{
    @Test
    void testIsWellSorted()
    {
        TaskCheck check = new TaskCheck();
        //assertTrue(check.isWellSorted(new String[]{ "A" , "D" }));
        //assertTrue(check.isWellSorted(new String[]{ "A" , "A", "C", "D" }));
        //assertTrue(check.isWellSorted(new String[]{ "C" , "B", "D" }));
        assertTrue(check.isWellSorted(new String[]{ "A", "B", "D" }));
    }
}