package escuelaing.edu.BST;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bst")
public class HomeController {
    private BST<Integer> bst = new BST<>();

    @PostMapping("/add")
    public String addNode(@RequestParam int value) {
        bst.add(value);
        return "Node " + value + " added!";
    }

    @GetMapping("/find")
    public String findNode(@RequestParam int value) {
        boolean found = bst.contains(Integer.valueOf(value)); 
        return found ? "Node " + value + " found!" : "Node " + value + " not found.";
    }

    @DeleteMapping("/remove")
    public String removeNode(@RequestParam int value) {
        boolean removed = bst.remove(Integer.valueOf(value));
        return removed ? "Node " + value + " removed!" : "Node " + value + " not found.";
    }


    @GetMapping("/inorder")
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal();
        return result;
    }

    private void inOrderTraversal(Node<Integer> node, List<Integer> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.value);
            inOrderTraversal(node.right, result);
        }
    }
}
