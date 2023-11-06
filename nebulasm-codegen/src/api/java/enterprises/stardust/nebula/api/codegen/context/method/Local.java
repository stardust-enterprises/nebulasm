package enterprises.stardust.nebula.api.codegen.context.method;

import enterprises.stardust.nebula.api.codegen.StackHolder;
import enterprises.stardust.nebula.api.codegen.TypeInstance;

import java.util.Collections;
import java.util.List;

public interface Local extends StackHolder {
    TypeInstance asType();

    @Override
    default List<TypeInstance> stack() {
        return Collections.singletonList(asType());
    }
}
