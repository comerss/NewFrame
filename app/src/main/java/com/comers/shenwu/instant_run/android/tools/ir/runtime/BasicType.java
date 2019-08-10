package com.comers.shenwu.instant_run.android.tools.ir.runtime;


public enum BasicType {
    I(Integer.TYPE),
    J(Long.TYPE),
    C(Character.TYPE),
    Z(Boolean.TYPE),
    F(Float.TYPE),
    D(Double.TYPE),
    V(Void.TYPE);

    private final Class<?> primitiveJavaType;

    private BasicType(Class<?> primitiveType) {
        this.primitiveJavaType = primitiveType;
    }

    public Class getJavaType() {
        return this.primitiveJavaType;
    }

    public static BasicType parse(String name) {
        for (BasicType basicType :) {
            if (basicType.getJavaType().getName().equals(name)) {
                return basicType;
            }
        }
        return null;
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/runtime/BasicType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */