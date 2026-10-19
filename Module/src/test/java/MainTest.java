import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    String[] names = {"Andy", "Kat", "Jean", "Martin", "Jennifer", "Sky"};
    String[] namesShort = {"Andy", "Kat", "Jean", "Martin", "Jennifer"};
    String[] nameEmpty = null;
    String[] nameOne = {"Sky"};

    AStack fam = new AStack(names, 6);
    AStack adultFam = new AStack(namesShort, 5);
    AStack orphanFam = new AStack(nameEmpty, 0);
    AStack onePerson = new AStack(nameOne, 1);
    AStack famRepeat = new AStack(names, 6);

    LLStack.pair animals = new LLStack.pair("Panda", new LLStack.pair("crocodile", new LLStack.pair("snake", null)));
    LLStack.pair reptiles = new LLStack.pair("crocodile", new LLStack.pair("snake", null));

    LLStack reptileStack = new LLStack(reptiles, 2);
    LLStack animalStack = new LLStack(animals, 3);
    LLStack nullStack = new LLStack(null, 0);

    @Test
    void LLisEmptyTrue(){
        long startTime = System.nanoTime();
        assertEquals(true, nullStack.is_Empty());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void LLisEmptyFalse(){
        assertEquals(false, animalStack.is_Empty());
    }

    @Test
    void LLpop(){
        long startTime = System.nanoTime();
        animalStack.pop();
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

        System.out.println("animalStack " + animalStack.toString());
        System.out.println("reptileStack " + reptileStack.toString());
        assertEquals(animalStack.stack, reptileStack.stack);
    }

    @Test
    void LLpopLive(){
        long startTime = System.nanoTime();
        animalStack.pop();
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

        //System.out.println("animalStack " + animalStack.toString());
        //System.out.println("reptileStack " + reptileStack.toString());
        assertEquals(animalStack.liveNums, reptileStack.liveNums);
    }

    @Test
    void LLpopReturn(){
        long startTime = System.nanoTime();
        assertEquals("Panda", animalStack.pop());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void LLPopThrows(){
        long startTime = System.nanoTime();
        assertThrows(NoSuchElementException.class, () -> nullStack.pop());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void LLPush(){
        long startTime = System.nanoTime();
        reptileStack.push("Panda");
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

        assertEquals(animalStack.stack, reptileStack.stack);
    }

    @Test
    void LLPushlive(){
        long startTime = System.nanoTime();
        reptileStack.push("Panda");
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");


        assertEquals(animalStack.liveNums, reptileStack.liveNums);
    }

    @Test
    void LLPeek(){
        long startTime = System.nanoTime();
        assertEquals("Panda", animalStack.peek());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void LLPeekThrows(){
        long startTime = System.nanoTime();
        assertThrows(NoSuchElementException.class, () -> nullStack.peek());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void size(){
        long startTime = System.nanoTime();
        assertEquals(3, animalStack.size(animalStack.stack));
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void equalThings(){
        assertEquals(true, fam.equalElts(famRepeat));
    }

    @Test
    void unequalThings(){
        assertEquals(false, fam.equalElts(adultFam));
    }

    @Test
    void pushLarge(){
        long startTime = System.nanoTime();
        adultFam.push("Sky");
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

        assertEquals(true,adultFam.equalElts(fam));
    }

    @Test
    void pushEmpty(){
        orphanFam.push("Sky");
        assertEquals(true,orphanFam.equalElts(onePerson));
    }

    @Test
    void popLarge(){
        long startTime = System.nanoTime();
        fam.pop();
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

        assertEquals(true, adultFam.equalElts(fam));
    }

    @Test
    void isEmptyTrue(){
        assertEquals(true, orphanFam.isEmpty());
    }

    @Test
    void emptyList(){
        AStack empt = Main.emptyStack();
        assertEquals(true, empt.equalElts(orphanFam));
    }

    @Test
    void isEmptyFalse(){
        assertEquals(false, fam.isEmpty());
    }

    @Test
    void popReturn(){
        assertEquals("Sky", fam.pop());
    }

    @Test
    void popThrow(){
        assertThrows(NoSuchElementException.class, () -> orphanFam.pop());
    }

    @Test
    void sizeNull(){
        assertEquals(0,orphanFam.size());
    }

    @Test
    void sizeTest(){
        long startTime = System.nanoTime();
        assertEquals(6, fam.size());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }


    @Test
    void peek(){
        long startTime = System.nanoTime();
        assertEquals("Sky", fam.peek());
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        IO.println("calling f took "+duration+" milliseconds.\n");

    }

    @Test
    void peekThrows(){
    assertThrows(NoSuchElementException.class, () -> orphanFam.peek());
    }




}
