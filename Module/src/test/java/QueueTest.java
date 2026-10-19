import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;




public class QueueTest {
        String[] family = {"Skyler", "Jen", "Marty", "Cat", "Oscar"};
        String[] adultFamily = {"Jen", "Marty", "Cat", "Oscar"};
        String[] addGranFamily = {"Jen", "Marty", "Cat", "Oscar", "Jean"};
        String[] abcEncircles = {"d", null, "a", "b", "c"};
        String[] abcPreAdded = {null, null, "a", "b", "c"};
        String[] nullStr = {null};

        circularQueue adultFam = new circularQueue(adultFamily, 10);
        circularQueue fam = new circularQueue(family, 10);
        circularQueue equalFam = new circularQueue(family, 10);
        circularQueue granFam = new circularQueue(addGranFamily, 10);
        circularQueue nullFam = null;
        circularQueue nullStrCirc = new circularQueue(nullStr, 1);
        circularQueue postEncircle = new circularQueue(abcEncircles, 5);
        circularQueue preEncircle = new circularQueue(abcPreAdded, 5);

        LLQueue.ll toDo = new LLQueue.ll("physics", new LLQueue.ll("IME", null));
        LLQueue.ll shortened = new LLQueue.ll("physics", null);

        LLQueue.ll abcs = new LLQueue.ll("a", new LLQueue.ll("b", new LLQueue.ll("c", null)));
        LLQueue.ll cbas = new LLQueue.ll("c", new LLQueue.ll("b", new LLQueue.ll("a", null)));

        LLQueue abcsQueue = new LLQueue(null, cbas);
        LLQueue cbasQueue = new LLQueue(abcs, null);
        LLQueue maddieToDo = new LLQueue(null, toDo);
        LLQueue shortenedToDo = new LLQueue(shortened, null);
        LLQueue nothingToDo = new LLQueue(null, null);

        @Test
        void equalLLTest(){
            long startTime = System.nanoTime();
            assertTrue(abcsQueue.equals(cbasQueue));
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
            assertTrue(abcsQueue.equals(abcsQueue));
            assertTrue(cbasQueue.equals(cbasQueue));
            assertFalse(maddieToDo.equals(shortenedToDo));
            assertFalse(maddieToDo.equals(null));
        }

        @Test
        void isEmptyLL(){
            long startTime = System.nanoTime();
            assertTrue(nothingToDo.isEmpty());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
            assertFalse(maddieToDo.isEmpty());
        }

        @Test
        void enqueueLLTest(){
            long startTime = System.nanoTime();
            nothingToDo.enqueue("physics");
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
            assertTrue(shortenedToDo.equals(nothingToDo));
        }

        @Test
        void dequeueLL(){
            long startTime = System.nanoTime();
            assertEquals("IME", maddieToDo.dequeue());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
            assertThrows(NoSuchElementException.class, () -> nothingToDo.dequeue());
            assertTrue(maddieToDo.equals(shortenedToDo));
        }

        @Test
        void peekLL(){
            assertThrows(NoSuchElementException.class, () -> nothingToDo.peek());
            long startTime = System.nanoTime();
            assertEquals("IME", maddieToDo.peek());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
        }

        @Test
        void equalEltsTests(){
            assertTrue(fam.equalElts(equalFam));
        }

        @Test
        void sizeCirc(){
            long startTime = System.nanoTime();
            assertEquals(4, adultFam.size());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            IO.println("calling f took "+duration+" milliseconds.\n");
            assertEquals(5, fam.size());
            fam.dequeue();
            assertEquals(4, fam.size());
        }

        @Test
        void equalTests(){
            assertTrue(fam.equals(equalFam));
        }

        @Test
        void dequeueCircular(){
            long startTime = System.nanoTime();
            assertEquals("Skyler", fam.dequeue());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);
            IO.println("calling f took "+duration+" milliseconds.\n");

            assertTrue(fam.equalElts(adultFam));
        }

        @Test
        void EnqueueCircular(){
            long startTime = System.nanoTime();
            adultFam.enqueue("Jean");
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);
            IO.println("calling f took "+duration+" milliseconds.\n");

            assertEquals(true, granFam.equalElts(adultFam));

            startTime = System.nanoTime();
            preEncircle.enqueue("d");
            endTime = System.nanoTime();
            duration = ((endTime - startTime) / 1000000);
            IO.println("calling f took "+duration+" milliseconds.\n");

            assertEquals(true, preEncircle.equalElts(postEncircle));

        }

        @Test
        void isEmpty(){
            long startTime = System.nanoTime();
            assertTrue(fam.is_empty(nullFam));
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);
            IO.println("calling f took "+duration+" milliseconds.\n");

            assertTrue(nullStrCirc.is_empty(nullStrCirc));
            assertFalse(fam.is_empty(fam));
        }

        @Test
        void peekCircular(){
            long startTime = System.nanoTime();
            assertEquals("Skyler", fam.peek());
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);
            IO.println("calling f took "+duration+" milliseconds.\n");

            fam.dequeue();
            assertEquals("Jen", fam.peek());
        }


}
