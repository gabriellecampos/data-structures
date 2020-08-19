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
}
