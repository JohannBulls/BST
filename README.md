# Binary Search Tree (BST) Project

This project implements a Binary Search Tree (BST) using Java and Spring Boot. It provides a RESTful API to add, find, remove nodes, and retrieve the in-order traversal of the tree.


## Features
- Add a node to the BST
- Find a node in the BST
- Remove a node from the BST
- Get the in-order traversal of the BST

## Technologies Used
- Java
- Spring Boot
- Maven

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/JohannBulls/BST
   ```

2. **Navigate to the project directory:**
   ```bash
   cd BST
   ```

3. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

4. **Run the Spring Boot application:**
   ```bash
   mvn spring-boot:run
   ```

## Usage
Once the application is running, you can interact with the RESTful API using tools like Postman, curl, or a web browser.

## API Endpoints
Here are the available endpoints in the API:

### Add a Node
- **URL:** `/bst/add`
- **Method:** `POST`
- **Parameters:** 
  - `value`: Integer (the value of the node to be added)

### Find a Node
- **URL:** `/bst/find`
- **Method:** `GET`
- **Parameters:**
  - `value`: Integer (the value of the node to be found)

### Remove a Node
- **URL:** `/bst/remove`
- **Method:** `DELETE`
- **Parameters:**
  - `value`: Integer (the value of the node to be removed)

### In-Order Traversal
- **URL:** `/bst/inorder`
- **Method:** `GET`
- **Response:** List of integers representing the in-order traversal of the BST.

## Example Requests
### Add a Node
```bash
curl -X POST "http://localhost:8080/bst/add?value=10"
```

### Find a Node
```bash
curl -X GET "http://localhost:8080/bst/find?value=10"
```

### Remove a Node
```bash
curl -X DELETE "http://localhost:8080/bst/remove?value=10"
```

### Get In-Order Traversal
```bash
curl -X GET "http://localhost:8080/bst/inorder"
```



Aquí tienes el contenido en inglés listo para copiar:

```markdown
# Binary Search Tree (BST) Implementation

## Overview
This project implements a Binary Search Tree (BST) in Java, providing basic functionalities such as insertion, deletion, and traversal. The BST is designed to be a generic data structure that can hold any type that extends `Comparable`.

## Features
- Add elements to the BST.
- Remove elements from the BST.
- Check if the BST contains a certain value.
- Find the minimum and maximum values in the BST.
- In-order traversal of the BST.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/BST.git
   ```
2. Navigate to the project directory:
   ```bash
   cd BST
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Usage
You can use the `BST` class in your Java application as follows:

 ```bash
    http://localhost:8080/index.html
   ```

## Testing

### Unit Tests
The project includes unit tests using JUnit to ensure the functionality of the BST implementation. Tests cover various operations such as adding, removing, and searching for elements, as well as checking minimum and maximum values.

### Running Tests
To run the tests, execute the following command in the project directory:

```bash
mvn test
```

### Test Cases
Here are some of the test cases implemented in `BSTTest.java`:

- **testAdd**: Verifies that elements can be added to the BST.
- **testContains**: Checks if specific values are contained in the BST.
- **testRemoveLeafNode**: Tests the removal of a leaf node.
- **testRemoveNodeWithOneChild**: Tests the removal of a node with one child.
- **testRemoveNodeWithTwoChildren**: Tests the removal of a node with two children.
- **testFindMin**: Checks the minimum value in the BST.
- **testFindMax**: Checks the maximum value in the BST.
- **testInOrderTraversal**: Verifies the in-order traversal of the BST.
- **testClear**: Tests the clearing of the BST.


## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.