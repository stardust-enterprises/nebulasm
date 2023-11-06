package enterprises.stardust.nebula.rift;

import enterprises.stardust.nebula.api.rift.Builder;

public class Rift {
    private Rift() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static <T> Builder<T> newProxyClass(Class<?> targetClass) {
        return null;
    }
}
