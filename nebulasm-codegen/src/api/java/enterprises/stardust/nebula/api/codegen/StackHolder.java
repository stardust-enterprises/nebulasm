package enterprises.stardust.nebula.api.codegen;

import enterprises.stardust.nebula.api.codegen.access.MethodAccessor;

import java.util.List;

/**
 * A marker interface for classes that holds stack values.
 * <p>
 * This is useful in the context of stack usage, where an instruction might need
 * multiple stack values at once.
 *
 * @see MethodAccessor
 *
 * @author xtrm
 * @since 0.1.0
 */
public interface StackHolder {
    List<TypeInstance> stack();
}
