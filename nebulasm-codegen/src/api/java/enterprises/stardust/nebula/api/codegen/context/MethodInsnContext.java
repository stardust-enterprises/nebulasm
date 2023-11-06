package enterprises.stardust.nebula.api.codegen.context;

import enterprises.stardust.nebula.api.codegen.StackHolder;
import enterprises.stardust.nebula.api.codegen.TypeInstance;
import enterprises.stardust.nebula.api.codegen.context.method.Local;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 *
 */
public interface MethodInsnContext extends StackHolder {
    default Local self() {
        if (isStatic()) {
            throw new IllegalStateException("Cannot get self for static method");
        }
        return local(0);
    }

    Local local(int index);

    TypeInstance type(Type type);

    TypeInstance constant(Object value);

    default TypeInstance type(String internalName) {
        return type(Type.getObjectType(internalName));
    }

    default TypeInstance type(Class<?> clazz) {
        return type(Type.getType(clazz));
    }

    void returnVoid();

    void returnValue(Local local);

    default boolean isStatic() {
        return (getModifiers() & Opcodes.ACC_STATIC) != 0;
    }

    int getModifiers();

    abstract class AbstractMethodInsnContext implements MethodInsnContext, Runnable {

    }
}
