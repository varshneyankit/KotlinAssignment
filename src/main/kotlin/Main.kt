/**
 * This function is used to execute and test the implementation of doubly linked list.
 */
fun main() {
    val doublyLinkedList = DoublyLinkedList<Int>()
    doublyLinkedList.insertAtStart(2)
    println("Inserted at start $doublyLinkedList")
    doublyLinkedList.insertAtStart(5)
    println("Inserted at start $doublyLinkedList")
    doublyLinkedList.insertAtEnd(1)
    println("Inserted at end$doublyLinkedList")
    doublyLinkedList.insertAtEnd(3)
    println("Inserted at end $doublyLinkedList")
    doublyLinkedList.insertAtIndex(10, 1)
    println("Inserted at index 1 $doublyLinkedList")
    doublyLinkedList.insertAtIndex(4, 3)
    println("Inserted at index 3 $doublyLinkedList")
    doublyLinkedList.removeFirst()
    println("Remove from start $doublyLinkedList")
    doublyLinkedList.removeLast()
    println("Remove from end $doublyLinkedList")
    doublyLinkedList.removeAtIndex(2)
    println("Remove from index 2 $doublyLinkedList")
}