package enterprises.stardust.nebula.api.rift;

public interface MethodHandler {
    void buildMethod()

    default boolean shouldHandleMethod(String name, String descriptor) {
        return false;
    }
}
