async function addNode() {
    const value = document.getElementById("nodeValue").value;
    const response = await fetch(`/bst/add?value=${value}`, { method: 'POST' });
    const result = await response.text();
    alert(result);
}

async function findNode() {
    const value = document.getElementById("nodeValue").value;
    const response = await fetch(`/bst/find?value=${value}`);
    const result = await response.text();
    alert(result);
}

async function removeNode() {
    const value = document.getElementById("nodeValue").value;
    const response = await fetch(`/bst/remove?value=${value}`, { method: 'DELETE' });
    const result = await response.text();
    alert(result);
}

async function displayInOrder() {
    const response = await fetch(`/bst/inorder`);
    const result = await response.json();
    alert(`In-Order Traversal: ${result.join(', ')}`);
}
