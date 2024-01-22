package bintreevisual;

public enum BTSettings
{
    FRAME_WIDTH (1400),
    FRAME_HEIGHT(600),
    RADIUS (40);

    public final Integer value;

    private BTSettings(Integer value)
    {
        this.value = value;
    }
}