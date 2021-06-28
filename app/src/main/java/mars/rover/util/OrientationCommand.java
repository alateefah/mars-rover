package mars.rover.util;

/**
 * OrientationCommand
 */
public enum OrientationCommand {

    NL("W"), //NORTH LEFT -> WEST
    WL("S"), //WEST LEFT -> SOUTH
    SL("E"), //SOUTH LEFT -> EAST
    EL("N"), //WEST LEFT -> NORTH
    NR("E"), //NORTH RIGHT -> EAST
    WR("N"), //WEST RIGHT -> NORTH
    SR("W"), //SOUTH RIGHT -> WEST
    ER("S"); //WEST RIGHT -> SOUTH

    private String value;

    OrientationCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}