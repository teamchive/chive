package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER}) @public interface RequiresPermission {
    @Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER}) @public interface Read {
        RequiresPermission value();
    }

    @Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER}) @public interface Write {
        RequiresPermission value();
    }

    String[] allOf();

    String[] anyOf();

    boolean conditional();

    String value();
}

