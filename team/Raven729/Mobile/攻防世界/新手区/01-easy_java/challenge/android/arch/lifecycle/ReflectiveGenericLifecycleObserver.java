package android.arch.lifecycle;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

class ReflectiveGenericLifecycleObserver implements a {
    class android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a {
        final Map a;
        final Map b;

        android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a(Map arg6) {
            ArrayList v2_1;
            super();
            this.b = arg6;
            this.a = new HashMap();
            Iterator v3 = arg6.entrySet().iterator();
            while(v3.hasNext()) {
                Object v0 = v3.next();
                Object v1 = ((Map$Entry)v0).getValue();
                Object v2 = this.a.get(v1);
                if(v2 == null) {
                    v2_1 = new ArrayList();
                    this.a.put(v1, v2_1);
                }

                ((List)v2_1).add(((Map$Entry)v0).getKey());
            }
        }
    }

    class b {
        final int a;
        final Method b;

        b(int arg3, Method arg4) {
            super();
            this.a = arg3;
            this.b = arg4;
            this.b.setAccessible(true);
        }

        public boolean equals(Object arg5) {
            boolean v0 = true;
            if(this != (((b)arg5))) {
                if(arg5 != null && this.getClass() == arg5.getClass()) {
                    if(this.a == ((b)arg5).a && (this.b.getName().equals(((b)arg5).b.getName()))) {
                        return v0;
                    }

                    return false;
                }

                v0 = false;
            }

            return v0;
        }

        public int hashCode() {
            return this.a * 0x1F + this.b.getName().hashCode();
        }
    }

    static final Map a;
    private final Object b;
    private final android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a c;

    static {
        ReflectiveGenericLifecycleObserver.a = new HashMap();
    }

    ReflectiveGenericLifecycleObserver(Object arg2) {
        super();
        this.b = arg2;
        this.c = ReflectiveGenericLifecycleObserver.a(this.b.getClass());
    }

    private static android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a a(Class arg1) {
        Object v0 = ReflectiveGenericLifecycleObserver.a.get(arg1);
        if(v0 == null) {
            android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a v0_1 = ReflectiveGenericLifecycleObserver.b(arg1);
        }

        return ((android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a)v0);
    }

    private void a(android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a arg3, c arg4, android.arch.lifecycle.b$a arg5) {
        this.a(arg3.a.get(arg5), arg4, arg5);
        this.a(arg3.a.get(android.arch.lifecycle.b$a.ON_ANY), arg4, arg5);
    }

    private void a(List arg3, c arg4, android.arch.lifecycle.b$a arg5) {
        if(arg3 != null) {
            int v1;
            for(v1 = arg3.size() - 1; v1 >= 0; --v1) {
                this.a(arg3.get(v1), arg4, arg5);
            }
        }
    }

    private void a(b arg5, c arg6, android.arch.lifecycle.b$a arg7) {
        try {
            switch(arg5.a) {
                case 0: {
                    arg5.b.invoke(this.b);
                    break;
                }
                case 1: {
                    arg5.b.invoke(this.b, arg6);
                    break;
                }
                case 2: {
                    arg5.b.invoke(this.b, arg6, arg7);
                    break;
                }
            }

            return;
        }
        catch(IllegalAccessException v0) {
            throw new RuntimeException(((Throwable)v0));
        }
        catch(InvocationTargetException v0_1) {
            throw new RuntimeException("Failed to call observer method", v0_1.getCause());
        }
    }

    private static void a(Map arg5, b arg6, android.arch.lifecycle.b$a arg7, Class arg8) {
        Object v0 = arg5.get(arg6);
        if(v0 != null && arg7 != (((android.arch.lifecycle.b$a)v0))) {
            throw new IllegalArgumentException("Method " + arg6.b.getName() + " in " + arg8.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + v0 + ", new value " + arg7);
        }

        if(v0 == null) {
            arg5.put(arg6, arg7);
        }
    }

    public void a(c arg2, android.arch.lifecycle.b$a arg3) {
        this.a(this.c, arg2, arg3);
    }

    private static android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a b(Class arg12) {
        int v1;
        android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a v0_1;
        int v4 = 2;
        Class v0 = arg12.getSuperclass();
        HashMap v6 = new HashMap();
        if(v0 != null) {
            v0_1 = ReflectiveGenericLifecycleObserver.a(v0);
            if(v0_1 != null) {
                ((Map)v6).putAll(v0_1.b);
            }
        }

        Method[] v7 = arg12.getDeclaredMethods();
        Class[] v8 = arg12.getInterfaces();
        int v9 = v8.length;
        int v5;
        for(v5 = 0; v5 < v9; ++v5) {
            Iterator v10 = ReflectiveGenericLifecycleObserver.a(v8[v5]).b.entrySet().iterator();
            while(v10.hasNext()) {
                Object v0_2 = v10.next();
                ReflectiveGenericLifecycleObserver.a(((Map)v6), ((Map$Entry)v0_2).getKey(), ((Map$Entry)v0_2).getValue(), arg12);
            }
        }

        int v8_1 = v7.length;
        for(v5 = 0; v5 < v8_1; ++v5) {
            Method v9_1 = v7[v5];
            Annotation v0_3 = v9_1.getAnnotation(f.class);
            if(v0_3 != null) {
                Class[] v10_1 = v9_1.getParameterTypes();
                if(v10_1.length <= 0) {
                    v1 = 0;
                }
                else if(!v10_1[0].isAssignableFrom(c.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                else {
                    v1 = 1;
                }

                android.arch.lifecycle.b$a v0_4 = ((f)v0_3).a();
                if(v10_1.length > 1) {
                    if(!v10_1[1].isAssignableFrom(android.arch.lifecycle.b$a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    else if(v0_4 != android.arch.lifecycle.b$a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    else {
                        v1 = v4;
                    }
                }

                if(v10_1.length > v4) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }

                ReflectiveGenericLifecycleObserver.a(((Map)v6), new b(v1, v9_1), v0_4, arg12);
            }
        }

        v0_1 = new android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a(((Map)v6));
        ReflectiveGenericLifecycleObserver.a.put(arg12, v0_1);
        return v0_1;
    }
}

