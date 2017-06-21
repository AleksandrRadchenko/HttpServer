package javase01.t06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotepadTest {
    private NotepadRecord record = new NotepadRecord();
    private void addTwoRecords(Notepad notepad) {
        record.setText("record 1");
        notepad.addRecord(record);
        record.setText("record 2");
        notepad.addRecord(record);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeNonExistentRecordOnEmptyNotepad() {
        Notepad notepad = new Notepad();
        assertEquals(true, notepad.deleteRecord(0));
        assertEquals(true, notepad.deleteRecord(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void editNonExistentRecordOnEmptyNotepad() {
        Notepad notepad = new Notepad();
        assertEquals(true, notepad.editRecord(0, record));
        assertEquals(true, notepad.editRecord(1, record));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void wrongIndexValuesOnEmptyNotepad() {
        Notepad notepad = new Notepad();
        assertEquals(true, notepad.deleteRecord(-1));
        assertEquals(true, notepad.deleteRecord(6548));
    }

    @Test
    public void addTwoRecordsTest() {
        Notepad notepad = new Notepad();
        record.setText("record 1");
        assertEquals(true, notepad.addRecord(record));
        record.setText("record 2");
        assertEquals(true, notepad.addRecord(record));
    }

    @Test
    public void removeExistingRecord() {
        Notepad notepad = new Notepad();
        addTwoRecords(notepad);
        assertEquals(true, notepad.deleteRecord(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeNonExistingRecord() {
        Notepad notepad = new Notepad();
        addTwoRecords(notepad);
        notepad.deleteRecord(2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void editNonExistingRecord() {
        Notepad notepad = new Notepad();
        addTwoRecords(notepad);
        assertEquals(true, notepad.editRecord(5, record));
    }

    @Test
    public void editExistingRecord() {
        Notepad notepad = new Notepad();
        addTwoRecords(notepad);
        assertEquals(true, notepad.editRecord(1, record));
    }

    @Test
    public void showAllRecords() {
        Notepad notepad = new Notepad();
        addTwoRecords(notepad);
        notepad.showAllRecords();
    }

}