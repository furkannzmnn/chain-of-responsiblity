package org.furkan.chaninofresponsibility;

import java.util.List;

public interface Element<T> {

    void setNext(T step);

    static <T extends Element<T>> T buildChain(List<T> elements, T lastElement) {
        if (elements.isEmpty()) {
            return lastElement;
        }
        for (int i = 0; i < elements.size(); i++) {
            var current = elements.get(i);
            var next = i < elements.size() - 1 ? elements.get(i + 1) : lastElement;
            current.setNext(next);
        }
        return elements.get(0);
    }
}
