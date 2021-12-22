package com.arvoreBinariaBusca.model;

import org.jetbrains.annotations.NotNull;

public abstract class ObjetoArvore<T> implements Comparable<T> {
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(@NotNull T o);
    public abstract String toString();

}
