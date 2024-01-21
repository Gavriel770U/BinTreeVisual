package bintreevisual;

public enum BTSettings
{
    FRAME_WIDTH (800),
    FRAME_HEIGHT(600),
    PIXEL_SIZE (1);

    public final Integer value;

    private BTSettings(Integer value)
    {
        this.value = value;
    }
}