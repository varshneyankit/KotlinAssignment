class DoublyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var length = 0

    class Node<T>(var data: T) {
        var next: Node<T>? = null
        var previous: Node<T>? = null
    }

    private fun isEmpty(): Boolean = head == null || length == 0

    override fun toString(): String {
        return if (isEmpty())
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
    }

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

    fun removeFirst() {
        when {
            isEmpty()-> print("List is empty")
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

    fun removeAtIndex(index: Int) {
        if (isEmpty())
            print("List is empty")
        else{
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

