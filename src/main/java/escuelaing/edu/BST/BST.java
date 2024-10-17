package escuelaing.edu.BST;

import java.util.*;

public class BST<E extends Comparable<E>> implements List<E> {
    private Node<E> root;
    private int size = 0;

    @Override
    public boolean add(E value) {
        root = addRecursive(root, value);
        size++;
        return true;
    }

    private Node<E> addRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            root = removeRecursive(root, (E) value);
            size--;
            return true;
        }
        return false;
    }

    private Node<E> removeRecursive(Node<E> current, E value) {
        if (current == null) {
            return null;
        }
        if (value.compareTo(current.value) == 0) {
            if (current.left == null && current.right == null) {
                return null; // Node with no children
            }
            if (current.right == null) {
                return current.left; // Node with one child
            }
            if (current.left == null) {
                return current.right; // Node with one child
            }
            // Node with two children
            E smallestValue = findMin(current.right);
            current.value = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }
        if (value.compareTo(current.value) < 0) {
            current.left = removeRecursive(current.left, value);
        } else {
            current.right = removeRecursive(current.right, value);
        }
        return current;
    }

    @Override
    public boolean contains(Object value) {
        return containsNode(root, (E) value);
    }

    private boolean containsNode(Node<E> current, E value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo(current.value) == 0) {
            return true;
        }
        return value.compareTo(current.value) < 0
                ? containsNode(current.left, value)
                : containsNode(current.right, value);
    }

    public E findMin() {
        return findMin(root);
    }

    private E findMin(Node<E> current) {
        return current.left == null ? current.value : findMin(current.left);
    }

    public E findMax() {
        return findMax(root);
    }

    private E findMax(Node<E> current) {
        return current.right == null ? current.value : findMax(current.right);
    }

    public void inOrderTraversal(List<E> result) {
        inOrderTraversal(root, result);
    }

    private void inOrderTraversal(Node<E> node, List<E> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.value);
            inOrderTraversal(node.right, result);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Implementar métodos restantes de List<E>

    @Override
    public E get(int index) {
        List<E> list = new ArrayList<>();
        inOrderTraversal(list);
        return list.get(index);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll() not implemented");
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        List<E> list = new ArrayList<>();
        inOrderTraversal(list);
        return list.toArray(arr);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) toArray();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterator() not implemented");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("indexOf() not implemented");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("lastIndexOf() not implemented");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("listIterator() not implemented");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator(index) not implemented");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList() not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll() not implemented");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("addAll(index, c) not implemented");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("set() not implemented");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("add(index, element) not implemented");
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("remove(index) not implemented");
    }
}
