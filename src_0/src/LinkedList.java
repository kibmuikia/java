import org.w3c.dom.Node;

public class LinkedList {
     Pupil p;
    LinkedList next;
    LinkedList previous;

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public void setPrevious(LinkedList previous) {
        this.previous = previous;
    }


    public Pupil getP() {
        return p;
    }

    public void setP(Pupil p) {
        this.p = p;
    }

    public LinkedList getNext() {
        return next;
    }

    public LinkedList getPrevious() {
        return previous;
    }

}
