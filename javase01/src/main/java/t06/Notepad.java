package t06;

import java.util.Locale;

/**
 * Implements basic notepad with abilities to add, edit, remove and printAll records.
 */
@SuppressWarnings("WeakerAccess")
public class Notepad {
    private static final int initialArrayLength = 3;
    private NotepadRecord[] notepadRecords = new NotepadRecord[initialArrayLength];
    private int recordsCounter;

    /**
     * Adds record to notepad by cloning it. If backing array is full, creates
     * new array with double capacity and puts initial array into it.
     * @return true if adding succeeded.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean addRecord(NotepadRecord record) {
        if (recordsCounter > notepadRecords.length - 1) {
            notepadRecords = doubleArrayCapasity(notepadRecords);
        }
        notepadRecords[recordsCounter++] = record.clone();
        return true;
    }

    /**
     * Deletes record[index] and shifts all consecutive records indexes by -1.
     * @param index index of the deleted record.
     * @return boolean true if deletion succeeded.
     * @throws ArrayIndexOutOfBoundsException if no such record or index incorrect.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean deleteRecord(int index) throws ArrayIndexOutOfBoundsException {
        if ((0 <= index) && (index <= recordsCounter - 1)) {
            System.arraycopy(notepadRecords, index + 1, notepadRecords, index, recordsCounter - 1 - index);
            notepadRecords[recordsCounter - 1] = null;
            recordsCounter--;
            return true;
        } else throw new ArrayIndexOutOfBoundsException("No such record");
    }

    /**
     * Replaces record[index] with newRecord.
     * @throws ArrayIndexOutOfBoundsException if index incorrect.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean editRecord(int index, NotepadRecord newRecord) throws ArrayIndexOutOfBoundsException {
        if (0 <= index && index <= recordsCounter) {
            notepadRecords[index] = newRecord;
            return true;
        } else throw new ArrayIndexOutOfBoundsException("No such record");
    }

    /**
     * Prints all records to System.out in form of table "Rec [index]: 'record's text'".
     * @return true if printing succeeded.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean showAllRecords() {
        for (int i = 0; i < recordsCounter; i++) {
            System.out.printf(new Locale("ru"), "Rec %d: %s%n", i, notepadRecords[i].getText());
        }
        return true;
    }

    /**
     * Doubles the capacity of backing array, keeping all records on their places.
     * @param notepadRecords initial array.
     * @return array with doubled capacity.
     */
    private static NotepadRecord[] doubleArrayCapasity(NotepadRecord[] notepadRecords) {
        NotepadRecord[] result = new NotepadRecord[notepadRecords.length * 2];
        System.arraycopy(notepadRecords, 0, result, 0, notepadRecords.length);
        return result;
    }
}
