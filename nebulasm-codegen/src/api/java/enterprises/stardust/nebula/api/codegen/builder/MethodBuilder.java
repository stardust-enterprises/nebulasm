package enterprises.stardust.nebula.api.codegen.builder;

import enterprises.stardust.nebula.api.codegen.context.MethodInsnContext;

import java.util.function.Consumer;

public interface MethodBuilder {
    void body(Closure<MethodInsnContext> contextConsumer);
}
