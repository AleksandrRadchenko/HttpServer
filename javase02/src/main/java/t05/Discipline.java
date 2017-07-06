package t05;

/**
 * Enum of disciplines. Used to arrange students into groups by discipline.
 * Uses t05.Marks enum to define type (integer or decimal) of marks for every discipline.
 */
public enum Discipline {
    MATH, LANG, HISTORY, SPORT, MUSIC;

    public Marks markType() {
        switch (this) {
            case MATH:
                return Marks.INTEGER;
            case LANG:
                return Marks.DECIMAL;
            case HISTORY:
                return Marks.DECIMAL;
            case SPORT:
                return Marks.INTEGER;
            case MUSIC:
                return Marks.INTEGER;
            default:
                return Marks.INTEGER;
        }
    }
}
