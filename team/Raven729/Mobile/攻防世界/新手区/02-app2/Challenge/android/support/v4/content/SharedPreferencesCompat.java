package android.support.v4.content;

import android.content.SharedPreferences$Editor;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat {
    public final class EditorCompat {
        class Helper {
            Helper() {
                super();
            }

            public void apply(@NonNull SharedPreferences$Editor arg2) {
                try {
                    arg2.apply();
                }
                catch(AbstractMethodError v0) {
                    arg2.commit();
                }
            }
        }

        private final Helper mHelper;
        private static EditorCompat sInstance;

        private EditorCompat() {
            super();
            this.mHelper = new Helper();
        }

        public void apply(@NonNull SharedPreferences$Editor arg2) {
            this.mHelper.apply(arg2);
        }

        public static EditorCompat getInstance() {
            if(EditorCompat.sInstance == null) {
                EditorCompat.sInstance = new EditorCompat();
            }

            return EditorCompat.sInstance;
        }
    }

    private SharedPreferencesCompat() {
        super();
    }
}

