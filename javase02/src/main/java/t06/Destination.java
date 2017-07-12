package t06;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Describes x and y coordinates for Submarine to go to
 */
@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
@Getter
public class Destination {
    private double y;
    private double x;
}
