package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @Test
    public void shouldHaveRightAndLeftNodesAsNullWhenThereIsOnlyOneElementInTheTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getLeft()).isNull();
        assertThat(binarySearchTree.getRoot().getRight()).isNull();
    }

    @Test
    public void shouldInsertElementInTheLeftNodeWhenItIsSmallerThanRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getLeft()).isNotNull();
        assertThat(binarySearchTree.getRoot().getLeft().getData()).isEqualTo(3);
        assertThat(binarySearchTree.getRoot().getRight()).isNull();
    }

    @Test
    public void shouldInsertElementInTheLeftNodeWhenItIsEqualToTheRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(4);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getLeft()).isNotNull();
        assertThat(binarySearchTree.getRoot().getLeft().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getRight()).isNull();
    }

    @Test
    public void shouldInsertElementInTheRightNodeWhenItIsGreaterThanRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getRight()).isNotNull();
        assertThat(binarySearchTree.getRoot().getRight().getData()).isEqualTo(5);
        assertThat(binarySearchTree.getRoot().getLeft()).isNull();
    }

    @Test
    public void shouldInsertElementInLeftSubTreeWhenItIsSmallerThanParent() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(5);
        assertThat(binarySearchTree.getRoot().getRight()).isNull();
        assertThat(binarySearchTree.getRoot().getLeft().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getLeft().getLeft().getData()).isEqualTo(3);
    }

    @Test
    public void shouldInsertElementInRightSubTreeWhenItIsGreaterThanParent() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        assertThat(binarySearchTree.getRoot().getData()).isEqualTo(5);
        assertThat(binarySearchTree.getRoot().getRight()).isNotNull();
        assertThat(binarySearchTree.getRoot().getRight().getData()).isEqualTo(6);
        assertThat(binarySearchTree.getRoot().getRight().getRight().getData()).isEqualTo(7);
        assertThat(binarySearchTree.getRoot().getLeft()).isNotNull();
        assertThat(binarySearchTree.getRoot().getLeft().getData()).isEqualTo(4);
        assertThat(binarySearchTree.getRoot().getLeft().getLeft().getData()).isEqualTo(3);
    }

    @Test
    public void shouldReturnInOrderTraversalStringWhenTreeIsNotEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(33);
        binarySearchTree.insert(89);
        binarySearchTree.insert(41);
        binarySearchTree.insert(27);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        String inOrder = binarySearchTree.inOrder();
        assertThat(inOrder).isEqualTo("1,5,9,10,27,33,41,89");
    }

    @Test
    public void shouldReturnEmptyStringForInOrderTraversalWhenTreeIsEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String inOrder = binarySearchTree.inOrder();
        assertThat(inOrder).isEmpty();
    }

    @Test
    public void shouldReturnRootInOrderWhenTreeHasOnlyOneElement() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(33);
        String inOrder = binarySearchTree.inOrder();
        assertThat(inOrder).isEqualTo("33");
    }

    @Test
    public void shouldReturnPreOrderTraversalStringWhenTreeIsNotEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(31);
        binarySearchTree.insert(78);
        binarySearchTree.insert(90);
        binarySearchTree.insert(1);
        binarySearchTree.insert(43);
        binarySearchTree.insert(7);
        binarySearchTree.insert(25);
        binarySearchTree.insert(83);
        String preOrder = binarySearchTree.preOrder();
        assertThat(preOrder).isEqualTo("31,1,7,25,78,43,90,83");
    }

    @Test
    public void shouldReturnEmptyStringForPreOrderTraversalWhenTreeIsEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String preOrder = binarySearchTree.preOrder();
        assertThat(preOrder).isEmpty();
    }

    @Test
    public void shouldReturnRootPreOrderWhenTreeHasOnlyOneElement() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        String preOrder = binarySearchTree.preOrder();
        assertThat(preOrder).isEqualTo("8");
    }

    @Test
    public void shouldReturnPostOrderTraversalStringWhenTreeIsNotEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(52);
        binarySearchTree.insert(14);
        binarySearchTree.insert(39);
        binarySearchTree.insert(88);
        binarySearchTree.insert(76);
        binarySearchTree.insert(56);
        binarySearchTree.insert(6);
        binarySearchTree.insert(102);
        String postOrder = binarySearchTree.postOrder();
        assertThat(postOrder).isEqualTo("6,39,14,56,76,102,88,52");
    }

    @Test
    public void shouldReturnEmptyStringForPostOrderTraversalWhenTreeIsEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String postOrder = binarySearchTree.postOrder();
        assertThat(postOrder).isEmpty();
    }

    @Test
    public void shouldReturnRootPosteOrderWhenTreeHasOnlyOneElement() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(29);
        String postOrder = binarySearchTree.postOrder();
        assertThat(postOrder).isEqualTo("29");
    }
}
