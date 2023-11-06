package enterprises.stardust.nebula.codegen;

import enterprises.stardust.nebula.api.codegen.builder.MethodBuilder;
import org.objectweb.asm.Opcodes;

/**
 * @author xtrm
 * @since 0.1.0
 */
public class Nebula {
    private Nebula() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static MethodBuilder method(String name, String descriptor) {
        return method(name, descriptor, Opcodes.ACC_PUBLIC, null, null);
    }

    public static MethodBuilder method(String name, String descriptor, int access, String signature, String[] exceptions, String... parameterNames) {
        return null;
    }
}
