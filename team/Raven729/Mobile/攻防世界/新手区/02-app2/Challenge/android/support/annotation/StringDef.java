package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.ANNOTATION_TYPE}) @public interface StringDef {
    String[] value();
}

