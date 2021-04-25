package by.ovsyanka.domain.train;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Getter
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

        log.info("Train {} created", toString());
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

        log.info("add carriage {}, currentTrainLength ", carriage.toString(), currentTrainLength);
    }

    public Carriage getCarriageByIndex(int index) {
        checkArgument(index > 0, "Index must be > 0");
        checkArgument(index <= currentTrainLength, "There is no such carriage");

        Node node = locomotiveCarriage;
        for (int i = 1; i < index; i++) {
            node = node.getNextNode();
        }

        return node.getCurrentNode();
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

    @Override
    public String toString() {
        return "Train{" +
                "maxTrainLength=" + maxTrainLength +
                ", currentTrainLength=" + currentTrainLength +
                ", locomotiveCarriage=" + locomotiveCarriage +
                ", lastCarriage=" + lastCarriage +
                '}';
    }
}
