package escuelaing.edu.BST;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bst")
public class HomeController {

    private BST<Integer> bst = new BST<>();

    // Añadir un nodo
    @PostMapping("/add")
    public String addNode(@RequestParam int value) {
        bst.add(value);
        return "Node " + value + " added!";
    }

    // Buscar un nodo
    @GetMapping("/find")
    public String findNode(@RequestParam int value) {
        boolean found = bst.contains(value);
        return found ? "Node " + value + " found!" : "Node " + value + " not found.";
    }

    // Eliminar un nodo
    @DeleteMapping("/remove")
    public String removeNode(@RequestParam int value) {
        boolean removed = bst.remove(value);
        return removed ? "Node " + value + " removed!" : "Node " + value + " not found.";
    }

    // Mostrar el recorrido in-order del árbol
    @GetMapping("/inorder")
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        bst.inOrderTraversal(result);
        return result;
    }
}
