package escuelaing.edu.BST;

import java.util.*;

public class BST<E extends Comparable<E>> implements List<E> {
    private Node<E> root;
    private int size = 0;
    

    private static class Node<E> {
        E value;
        Node<E> left, right;

        Node(E value) {
            this.value = value;
        }
    }

    public Node<E> getRoot() {
        return root;
    }

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
                return null;
            }

            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

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

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<E> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
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


    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("get() no está implementado");
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
        boolean modified = false;
        for (Node<E> current = root; current != null;) {
            if (!c.contains(current.value)) {
                remove(current.value);
                modified = true;
            }
            current = current.left; 
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        inOrderTraversalToArray(root, arr, 0);
        return arr;
    }

    private int inOrderTraversalToArray(Node<E> node, Object[] arr, int index) {
        if (node != null) {
            index = inOrderTraversalToArray(node.left, arr, index);
            arr[index++] = node.value;
            index = inOrderTraversalToArray(node.right, arr, index);
        }
        return index;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) toArray();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterator() no está implementado");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("indexOf() no está implementado");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("lastIndexOf() no está implementado");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("listIterator() no está implementado");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator(index) no está implementado");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList() no está implementado");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll() no está implementado");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("addAll(int, Collection) no está implementado");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("set() no está implementado");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("add(int, E) no está implementado");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("remove(int) no está implementado");
    }

}
