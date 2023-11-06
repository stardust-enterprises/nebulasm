package enterprises.stardust.nebula.api.codegen.access;

import enterprises.stardust.nebula.api.codegen.StackHolder;

public interface MethodAccessor extends StackHolder {
    void call(String name, String descriptor, boolean itf);

    default void call(String name, String descriptor) {
        call(name, descriptor, false);
    }
}
