package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE}) @public interface RestrictTo {
    public enum Scope {
        @Deprecated public static final enum Scope GROUP_ID;
        public static final enum Scope LIBRARY;
        public static final enum Scope LIBRARY_GROUP;
        public static final enum Scope SUBCLASSES;
        public static final enum Scope TESTS;

        static {
            Scope.LIBRARY = new Scope("LIBRARY", 0);
            Scope.LIBRARY_GROUP = new Scope("LIBRARY_GROUP", 1);
            Scope.GROUP_ID = new Scope("GROUP_ID", 2);
            Scope.TESTS = new Scope("TESTS", 3);
            Scope.SUBCLASSES = new Scope("SUBCLASSES", 4);
            Scope.$VALUES = new Scope[]{Scope.LIBRARY, Scope.LIBRARY_GROUP, Scope.GROUP_ID, Scope.TESTS, Scope.SUBCLASSES};
        }

        private Scope(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Scope valueOf(String arg1) {
            return Enum.valueOf(Scope.class, arg1);
        }

        public static Scope[] values() {
            return Scope.$VALUES.clone();
        }
    }

    Scope[] value();
}

