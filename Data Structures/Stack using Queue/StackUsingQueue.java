public class StackUsingQueue{

		public static void main(String args[]){

					Stack stack = new Stack();

					stack.push(10);
					stack.push(15);
					stack.push(152);

					stack.pop();

					stack.push(4);
					stack.push(54);

					stack.print();

				//Output
					//54
					//4
					//15
					//10
	}
}

class Stack{

	Node front;
	Node back;

	Queue q1 = new Queue();
	Queue q2 = new Queue();

	//insertion
	public void push(int data){
		Node current = q1.head;

		if(q1.head != null){
			while(current != null){
				q2.enqueue(q1.dequeue().data);
				current = current.next;
			}

			q1.enqueue(data);

			current = q2.head;

			while(current != null){
				q1.enqueue(q2.dequeue().data);
				current = current.next;
			}
		}else{
			q1.head= new Node(data);
		}

	}

	//pop

	public Node pop(){
		return q1.dequeue();
	}


		public void print(){

			Node current = q1.head;

				while(current != null){
					System.out.println(current.data);
					current = current.next;
				}
		}

}



class Queue{
		Node head;
		Node tail;


		public void enqueue(int data){
					Node newNode = new Node(data);

					if(head == null){
						head = newNode;
						tail = newNode;
					}else{
						tail.next = newNode;
						tail = newNode;
					}

				tail = newNode;
		}

		public Node dequeue(){
					if(head != null){
					Node dequeueNode = new Node(head.data);

					head = head.next;

					return dequeueNode;
					}
		//if head is null , this is an empty queue
			return null;
		}
}

class Node{

	int data;
	Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
