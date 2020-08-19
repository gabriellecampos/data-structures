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
}
