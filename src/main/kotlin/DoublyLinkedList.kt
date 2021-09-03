/**
 * This class implements the Doubly Linked List.
 *
 * @param T the type of data which is accepted by this class *
 */
class DoublyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var length = 0

    /**
     * This class contains node which is used by outer class.
     *
     * @param T the type of data which is accepted by this class.
     */
    class Node<T>(var data: T) {
        var next: Node<T>? = null
        var previous: Node<T>? = null
    }

    /**
     * This function checks whether the doubly linked is empty.
     *
     * @return Boolean is returned after checking the conditions.
     */
    private fun isEmpty(): Boolean = head == null && tail == null && length == 0

    /**
     * This function overrides the toString function
     *
     * @return String is returned.
     */
    override fun toString(): String =
        if (isEmpty())
            "List is empty"
        else {
            var string = "[ "
            var node = head
            while (node != null) {
                string += "${node.data}"
                node = node.next
                if (node != null)
                    string += ", "
            }
            "$string ]"
        }


    /**
     * This function inserts data at the start of doubly linked list.
     *
     * @param data of type T is required by this function.
     */
    fun insertAtStart(data: T) {
        val newNode = Node(data)
        if (isEmpty())
            tail = newNode
        else {
            head?.previous = newNode
            newNode.next = head
        }
        head = newNode
        length++
    }

    /**
     * This function inserts data at the end of doubly linked list.
     *
     * @param data of type T is required by this function.
     */
    fun insertAtEnd(data: T) {
        val newNode = Node(data)
        if (isEmpty())
            head = newNode
        else {
            tail?.next = newNode
            newNode.previous = tail
        }
        tail = newNode
        length++
    }

    /**
     * This function inserts data at given index of doubly linked list.
     *
     * @param data of type T is required by this function.
     * @param index of type Int is required by this function.
     */
    fun insertAtIndex(data: T, index: Int) {
        val newNode = Node(data)
        if (isEmpty()) {
            tail = newNode
            head = newNode
            length++
        } else {
            if (index < length && index >= 0) {
                when (index) {
                    0 -> insertAtStart(data)
                    length - 1 -> insertAtEnd(data)
                    else -> {
                        var currentNode = head
                        var count = 1
                        while (count < index) {
                            currentNode = currentNode?.next
                            count++
                        }
                        newNode.next = currentNode?.next
                        currentNode?.next = newNode
                        newNode.previous = currentNode
                        currentNode?.next?.previous = newNode
                        length++
                    }
                }
            } else
                print("Index out of bounds")
        }
    }

    /**
     * This function removes data at the start of doubly linked list.
     */
    fun removeFirst() {
        when {
            isEmpty() -> print("List is empty")
            length == 1 -> {
                head = null
                tail = null
                length--
            }
            else -> {
                val node = head
                head = node?.next
                length--
            }
        }
    }

    /**
     * This function removes data at the end of doubly linked list.
     */
    fun removeLast() {
        when {
            isEmpty() -> print("List is empty")
            length == 1 -> {
                head = null
                tail = null
                length--
            }
            else -> {
                val node = tail
                tail = node?.previous
                length--
            }
        }
    }

    /**
     * This function removes data at given index of doubly linked list.
     *
     * @param index of type Int is required by this function.
     */
    fun removeAtIndex(index: Int) {
        if (isEmpty())
            print("List is empty")
        else {
            if (index < length && index >= 0) {
                when (index) {
                    0 -> removeFirst()
                    length - 1 -> removeLast()
                    else -> {
                        var currentNode = head
                        var count = 1
                        while (count < index) {
                            currentNode = currentNode?.next
                            count++
                        }
                        val tempNode = currentNode?.next
                        currentNode?.next = tempNode?.next
                        tempNode?.next?.previous = currentNode
                        length--
                    }
                }
            } else
                print("Index out of bounds")
        }
    }
}