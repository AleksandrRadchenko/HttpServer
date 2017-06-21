package javase01.t06;

import lombok.Data;

/**
 * POJO containing single String field to store notepad's record's text.
 */
@Data
class NotepadRecord {
    private String text;

    /**
     * Overrides java.lang.Object.clone() to support Notepad.addRecord() method
     * by providing guaranteed uniqueness of added NotepadRecords.
     * @return copy of current NotepadRecord.
     */
    @Override
    public NotepadRecord clone() {
        NotepadRecord newRecord = new NotepadRecord();
        if (this.getText() != null) {
            newRecord.setText(this.getText());
        }
        return newRecord;
    }
}
