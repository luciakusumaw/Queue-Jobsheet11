public class KRSQueue {
    KRS[] data;
    int front, rear, size, max;
    int completedCount = 0; 

    public KRSQueue(int n) {
        max = n;
        data = new KRS[max];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(KRS mhs) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            data[rear] = mhs;
            size++;
            System.out.println(mhs.name + " successfully added to the queue.");
        } else {
            System.out.println("Queue is full! (Maximum 10)");
        }
    }

    public void dequeueTwo() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        int processedThisTime = (size >= 2) ? 2 : 1; 
        for (int i = 0; i < processedThisTime; i++) {
            KRS s = data[front];
            front = (front + 1) % max;
            size--;
            completedCount++;
            System.out.println("KRS approved for: " + s.name);
        }
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("No students in the queue.");
            return;
        }
        int i = front;
        while (i != rear) {
            data[i].print();
            i = (i + 1) % max;
        }
        data[i].print();
    }

    public void peekFirstTwo() {
        if (size >= 1) {
            System.out.print("1st in line: ");
            data[front].print();
            if (size >= 2) {
                int second = (front + 1) % max;
                System.out.print("2nd in line: ");
                data[second].print();
            }
        } else {
            System.out.println("Fewer than 2 students in the queue.");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.print("Last student in line: ");
            data[rear].print();
        }
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Queue cleared.");
    }

    public void displayStats() {
        System.out.println("Number of students in queue: " + size);
        System.out.println("Students completed processing: " + completedCount);
        System.out.println("Remaining advisor capacity (max 30): " + (30 - completedCount));
    }
}