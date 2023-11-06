package enterprises.stardust.nebula.api.codegen.access;

import enterprises.stardust.nebula.api.codegen.StackHolder;

public interface FieldAccessor<T> extends StackHolder {
    T get(String name, String descriptor);

    T get(String name, Class<?> type);

    void set(String name, String descriptor);
}
