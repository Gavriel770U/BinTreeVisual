package bintreevisual;

public enum BTSettings
{
    FRAME_WIDTH (800),
    FRAME_HEIGHT(600),
    PIXEL_SIZE (1),
    RADIUS (40);

    public final Integer value;

    private BTSettings(Integer value)
    {
        this.value = value;
    }
}