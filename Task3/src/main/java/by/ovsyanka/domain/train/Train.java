package by.ovsyanka.domain.train;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Train {

    private final int maxTrainLength;
    private int currentTrainLength = 0;
    private Node locomotiveCarriage;
    private Node lastCarriage;

    public Train(int maxTrainLength, Locomotive locomotive) {
        checkArgument(maxTrainLength > 0, "The maxTrainLength must be > 0");
        checkNotNull(locomotive, "The locomotive of the train is required");

        this.maxTrainLength = maxTrainLength;
        this.lastCarriage = new Node(null, null, locomotiveCarriage);
        this.locomotiveCarriage = new Node(locomotive, lastCarriage, null);
        currentTrainLength++;
    }

    public static Train of(int maxTrainLength, Locomotive locomotive) {
        return new Train(maxTrainLength, locomotive);
    }

    public int getCurrentTrainLength() {
        return currentTrainLength;
    }

    public void addCarriage(Carriage carriage) {
        checkArgument(carriage.getClass() != Locomotive.class,
                "A train can only have one locomotive");
        checkArgument(currentTrainLength != maxTrainLength,
                "Exceeded the number of train cars");

        Node previous = lastCarriage;
        previous.setCurrentNode(carriage);
        lastCarriage = new Node(null, null, previous);
        previous.setNextNode(lastCarriage);

        currentTrainLength++;
    }

    private class Node {
        private Carriage currentNode;
        private Node nextNode;
        private Node prevNode;

        public Node(Carriage currentNode, Node nextNode, Node prevNode) {
            this.currentNode = currentNode;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public Carriage getCurrentNode() {
            return currentNode;
        }

        public void setCurrentNode(Carriage currentNode) {
            this.currentNode = currentNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
    }
}
