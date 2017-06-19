package javase01.t01.Task06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotepadTest {
    Notepad notepad = new Notepad();

    @Test
    public void addRecord() throws Exception {
        assertEquals(true, notepad.addRecord());
    }

}