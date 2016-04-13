/** Exception class for empty Queues.
 * Jeffrey Chang, jchang88
 * Allan Wang, awang53
 * 600.226.02
 * Assignment a4
 */
public class QueueEmptyException extends RuntimeException {

    /** Create a default exception object.
     */
    public QueueEmptyException() {
        super("ERROR: queue is empty, invalid operation");
    }

    /** Create a specific exception object.
     *  @param err the error message
     */
    public QueueEmptyException(String err) {
        super(err);
    }
}
