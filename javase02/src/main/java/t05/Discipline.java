package t05;

/**
 * Enum of disciplines. Used to arrange students into groups by discipline.
 * Uses t05.GradeTypes enum to define type (integer or decimal) of marks for every discipline.
 */
public enum Discipline {
    HISTORY, LANG, MATH, MUSIC, SPORT;

    public GradeTypes markType() {
        switch (this) {
            case HISTORY:
                return GradeTypes.DECIMAL;
            case LANG:
                return GradeTypes.DECIMAL;
            case MATH:
                return GradeTypes.INTEGER;
            case MUSIC:
                return GradeTypes.INTEGER;
            case SPORT:
                return GradeTypes.INTEGER;
            default:
                return GradeTypes.INTEGER;
        }
    }
}
